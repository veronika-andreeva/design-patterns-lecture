package com.epam.movie;

import com.epam.logger.LoggerSingleton;

public class MovieDemoWithLogger {
    public static void main(String[] args) {
        Movie movie = new Movie.Builder()
                .withName("Avatar: The Way of Water")
                .withDirector("James Cameron")
                .withYear(2022)
                .withGenre("Fantasy")
                .withRating(9)
                .build();

        LoggerSingleton logger = LoggerSingleton.getInstance();

        logger.info("Writing movie info in my Singleton logger.");
        logger.info("The director of the movie " + movie.getName() + " is " + movie.getDirector());
    }

}
