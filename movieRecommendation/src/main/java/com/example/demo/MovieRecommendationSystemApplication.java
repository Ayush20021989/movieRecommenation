package com.example.demo;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRecommendationSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MovieRecommendationSystemApplication.class, args);
	}

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public void run(String... args) throws Exception {
		// Added two rows in the table just to verify if the Schema has been created in MySQL
		Movie movie1 = new Movie();
		movie1.setTitle("Inception");
		movie1.setDirector("Christopher Nolan");
		movie1.setYear(2010);
		movie1.setGenre("Sci-Fi");
		movieRepository.save(movie1);

		Movie movie2 = new Movie();
		movie2.setTitle("The Godfather");
		movie2.setDirector("Francis Ford Coppola");
		movie2.setYear(1972);
		movie2.setGenre("Crime");
		movieRepository.save(movie2);
	}
}
