package com.example.forumalex.repository;

import com.example.forumalex.domain.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaFilmsRepository extends CrudRepository<Film, Integer> {

    List<Film> findAll();
    List<Film> findByRatingGreaterThan(int Min);
    List<Film> findByTitle(String title);
    void deleteById(int id);
    List<Film> findByWatchedTrue();
}
