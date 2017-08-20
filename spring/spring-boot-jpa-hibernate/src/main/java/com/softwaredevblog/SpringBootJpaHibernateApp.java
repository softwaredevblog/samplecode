package com.softwaredevblog;

import com.softwaredevblog.entities.Movie;
import com.softwaredevblog.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootJpaHibernateApp implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(SpringBootJpaHibernateApp.class);

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void run(String... args) {
        System.out.println("Running Spring boot JPA Hibernate example");

        Movie movie1 = new Movie("Logan", "James Mangold");
        Movie movie2 = new Movie("Rogue One", "Gareth Edwards");
        Movie movie3 = new Movie("Hell or High Water", "David Mackenzie");

        System.out.println("Saving movies to DB...");
        movieRepository.save(
                Arrays.asList(movie1, movie2, movie3));

        System.out.println("Retrieving movies from DB");
        Iterable<Movie> moviedFromDb = movieRepository.findAll();

        for (Movie movie : moviedFromDb) {
            System.out.println("Movie: " + movie.getTitle() + ", directed by: " + movie.getDirector());
        }

        List<Movie> moviesByDirector = movieRepository.findByDirector("James Mangold");

        for (Movie movieByDirector : moviesByDirector) {
            System.out.println("Search for movies by director James Mangold found: " + movieByDirector.getTitle());
        }
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootJpaHibernateApp.class, args);
    }
}
