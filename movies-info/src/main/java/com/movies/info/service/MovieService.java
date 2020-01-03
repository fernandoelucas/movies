package com.movies.info.service;

import com.movies.info.dto.MovieDTO;
import com.movies.info.entity.Actor;
import com.movies.info.entity.Director;
import com.movies.info.entity.Movie;
import com.movies.info.repository.ActorRepository;
import com.movies.info.repository.DirectorRepository;
import com.movies.info.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    private final ActorRepository actorRepository;

    private final DirectorRepository directorRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, ActorRepository actorRepository, DirectorRepository directorRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
        this.directorRepository = directorRepository;
    }

    public Movie createMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setName(movieDTO.getName());
        movie.setYear(movieDTO.getYear());
        movie.setStudio(movieDTO.getStudio());
        movie.setDescription(movieDTO.getDescription());

        setActorAndDirectorSide(movie);

        return createMovie(movie);
    }

    private Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie getMovieById(Long id) {
        return movieRepository.getOne(id);
    }

    public Movie deleteMovieById(Long id) {
        Movie movie = getMovieById(id);
        movieRepository.delete(movie);
        return movie;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    private void setActorAndDirectorSide(Movie movie) {
        Optional<Actor> optionalActor = actorRepository.findById(1L);
        Actor realActor = optionalActor.get();
        Optional<Director> optionalDirector = directorRepository.findById(1L);
        Director realDirector = optionalDirector.get();

        optionalActor.ifPresent(actor -> {
            List<Actor> actors = new ArrayList<>();
            actors.add(actor);
            movie.setActors(actors);
        });

        optionalDirector.ifPresent(director -> {
            List<Director> directors = new ArrayList<>();
            directors.add(director);
            movie.setDirectors(directors);
        });
        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie);

        realActor.setMovies(movieList);

        realDirector.setMovies(movieList);
    }
}
