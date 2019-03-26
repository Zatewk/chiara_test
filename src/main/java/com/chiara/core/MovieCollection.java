package com.chiara.core;

import java.util.ArrayList;
import java.util.Arrays;

public class MovieCollection {

    protected ArrayList<Movie> collection;

    public MovieCollection (){
        this.collection = new ArrayList<>();
    }

    public MovieCollection (Movie[] movies){
        this.collection = new ArrayList<>(Arrays.asList(movies));
    }

    public MovieCollection (ArrayList<Movie> movies) {
        this.collection = movies;
    }

    public void addMovie (Movie m){
        this.collection.add(m);
    }

    public void removeMovie (Movie m){
        this.collection.remove(m);
    }

    public int getMovieCount (){
        return this.collection.size();
    }

    public Movie getMovie (int index){
        return this.collection.get(index);
    }
}
