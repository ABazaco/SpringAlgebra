package com.example.forumalex.service;

import com.example.forumalex.domain.Film;
import com.example.forumalex.repository.JpaFilmsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmsService {
    private final JpaFilmsRepository filmsRepository;

    public FilmsService(JpaFilmsRepository filmsRepository) {
        this.filmsRepository = filmsRepository;
    }

    public List<Film> findAll(){
        return filmsRepository.findAll();
    }

    public Optional<Film> findById (int id) {
        return filmsRepository.findById(id);
    }

    public Film save(Film film){
        return filmsRepository.save(film);
    }
    public List<Film> findByRatingGreaterThan(int Min){
        return filmsRepository.findByRatingGreaterThan(Min);
    }
    public List<Film> findByTitle(String title){
        return filmsRepository.findByTitle(title);
    }
    public void deleteById(int id){
        filmsRepository.deleteById(id);
    }
    public List<Film> findByWatchedTrue(){
        return filmsRepository.findByWatchedTrue();
    }
}
