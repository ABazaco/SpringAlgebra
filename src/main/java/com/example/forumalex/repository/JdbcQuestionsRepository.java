package com.example.forumalex.repository;

import com.example.forumalex.domain.Question;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Repository
public class JdbcQuestionsRepository implements QuestionsRepository{

    private static final String TABLE_NAME = "questions";
    private static final String GENERATED_KEY_COLUMN = "id";
    private static final String SELECT_ALL = "SELECT * FROM questions";

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert jdbcInsert;

    public JdbcQuestionsRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.jdbcInsert = new SimpleJdbcInsert(jdbc)
                .withTableName(TABLE_NAME)
                .usingGeneratedKeyColumns(GENERATED_KEY_COLUMN);
    }

    @Override
    public Set<Question> findAll() {
        return Set.copyOf(jdbc.query(SELECT_ALL, this::mapRowToQuestion));
    }

    @Override
    public Optional<Question> findById(int id) {
        try{
            return Optional.ofNullable(
                    jdbc.queryForObject(SELECT_ALL + " WHERE id = ?", this::mapRowToQuestion, id)
            );
        } catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<Question> save(Question question) {
        try {
            question.setId(saveQuestionDetails(question));
            return Optional.of(question);
        } catch (DuplicateKeyException e){
            return Optional.empty();
        }
    }

    @Override
    public void deleteById(int id) {
        jdbc.update("DELETE FROM questions WHERE id = ?", id);
    }

    private int saveQuestionDetails(Question question) {
        Map<String, Object> values = new HashMap<>();

        values.put("title", question.getTitle());
        values.put("body",question.getBody());

        return jdbcInsert.executeAndReturnKey(values).intValue();
    }

    private Question mapRowToQuestion(ResultSet rs, int rowNum) throws SQLException {
        return new Question(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("body")
        );
    }


}
