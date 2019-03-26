package com.chiara.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Movie {

    private String title;
    private int year;
    private ArrayList<String> genres;
    private ArrayList<Integer> ratings;
    private float avgRating;
    private String contentRating;
    private String duration;
    private String releaseDate;
    private String originalTitle;
    private String storyline;
    private ArrayList<String> cast;
    private String imdbRating;
    private String posterURL;

    public Movie (String title, int year, Collection<String> genres, Collection<Integer> ratings, String contentRating,
                  String duration, String releaseDate, String originalTitle, String storyline, Collection<String> cast,
                  String imdbRating, String posterURL){
        this.title = title;
        this.year = year;
        this.genres = new ArrayList<>(genres);
        this.ratings = new ArrayList<>(ratings);
        this.contentRating = contentRating;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.originalTitle = originalTitle;
        this.storyline = storyline;
        this.cast = new ArrayList<>(cast);
        this.imdbRating = imdbRating;
        this.posterURL = posterURL;

        this.avgRating = 0.f;
        for (int i: this.ratings)
            this.avgRating += i;
        this.avgRating = this.avgRating/this.ratings.size();
    }

    public boolean hasGenre (String genre){
        return this.genres.contains(genre);
    }

    public boolean belongsCast(String actor){
        return this.cast.contains(actor);
    }

    public float getAvgRating() {
        return avgRating;
    }

    public String getInformation (){
        String genres = Arrays.toString(this.genres.toArray(new String[this.genres.size()]));
        String cast = Arrays.toString(this.cast.toArray(new String[this.cast.size()]));

        return  "Title: " + this.title + "\n" +
                "Year: " + this.year + "\n" +
                "Genres: " + genres + "\n" +
                "Content Rating: " + this.contentRating + "\n" +
                "AVG Rating: " + this.avgRating + "\n" +
                "Duration: " + this.duration + "\n" +
                "Release Date: " + this.releaseDate + "\n" +
                "Original Title: " + this.originalTitle + "\n" +
                "Storyline: " + this.storyline + "\n" +
                "Cast: " + cast + "\n" +
                "IMDB Rating: " + this.imdbRating + "\n" +
                "Poster URL: " + this.posterURL + "\n";
    }
}
