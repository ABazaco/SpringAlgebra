package com.example.forumalex.controller.rest;


import com.example.forumalex.domain.Film;
import com.example.forumalex.service.FilmsService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/films")
public class FilmRestController {
    private final FilmsService filmsService;

    public FilmRestController(FilmsService filmsService) {
        this.filmsService = filmsService;
    }

    @GetMapping
    public List<Film> findAll() { return filmsService.findAll(); }

    @GetMapping("{id}")
    public Film findById(@PathVariable int id){
        return filmsService.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "NO he encontrado la peli")
        );
    }

    @GetMapping("rating/{minRating}")
    public List<Film> findWithRatingGreaterThan (@PathVariable int minRating){
        List<Film> films = filmsService.findByRatingGreaterThan(minRating);
        if(films.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No films with rating greater than" + minRating);
        }

        return films;
    }


    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Film save(@Valid @RequestBody Film film){
        return filmsService.save(film);
    }

    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        if(filmsService.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "cant delete a film that doesnt exist");
        }

        filmsService.deleteById(id);
    }

    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("{id}/UpdateRating")
    public Film updateRating(@PathVariable int id, @RequestParam int newRating) {
        Optional<Film> film = filmsService.findById(id);
        if(film.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found film with that id");
        }

        film.get().setRating(newRating);
        return filmsService.save(film.get());
    }


}
