package com.epam.movie;

import com.epam.logger.LoggerSingleton;

public class Movie {

    private static final LoggerSingleton logger = LoggerSingleton.getInstance();

    private String name;
    private String director;
    private int year;
    private int rating;
    private String genre;


    public static class Builder {
        private String name;
        private String director;
        private int year;
        private int rating;
        private String genre;

        public Builder() {

        }

        public Movie build() {
            logger.info("Creating a movie object with the builder pattern.");
            return new Movie(this);
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDirector(String director) {
            this.director = director;
            return this;
        }


        public Builder withYear(int year) {
            this.year = year;
            return this;
        }

        public Builder withRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder withGenre(String genre) {
            this.genre = genre;
            return this;
        }

    }

    private Movie(Builder builder) {
        this.name = builder.name;
        this.director = builder.director;
        this.year = builder.year;
        this.rating = builder.rating;
        this.genre = builder.genre;
    }

    public String getName() {
        return name;
    }


    public String getDirector() {
        return director;
    }


    public int getYear() {
        return year;
    }


    public int getRating() {
        return rating;
    }


    public String getGenre() {
        return genre;
    }


}
