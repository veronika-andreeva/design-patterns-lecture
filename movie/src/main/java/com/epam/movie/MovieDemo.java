package com.epam.movie;

public class MovieDemo {
    public static void main(String[] args) {
        Movie movie = new Movie.Builder()
                .withName("Avatar: The Way of Water")
                .withDirector("James Cameron")
                .withYear(2022)
                .withGenre("Fantasy")
                .withRating(9)
                .build();

        System.out.println("My movie:");
        System.out.println("Name: " + movie.getName());
        System.out.println("Director: " + movie.getDirector());
        System.out.println("Year: " + movie.getYear());
        System.out.println("Genre: " + movie.getGenre());
        System.out.println("Rating: " + movie.getRating());
    }
}
