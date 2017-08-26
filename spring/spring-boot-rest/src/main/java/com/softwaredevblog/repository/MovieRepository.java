package com.softwaredevblog.repository;

import com.softwaredevblog.entities.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findByDirector(String director);
}
