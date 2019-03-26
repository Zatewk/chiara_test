package com.chiara.core;

import java.util.ArrayList;
import java.util.Iterator;

public class Library extends MovieCollection {

    public Library (){
        super();
    }

    public Library (Movie[] movies){
        super(movies);
    }

    public PlayList getDefaultPlaylist(){
        return new PlayList (this.collection);
    }

    public PlayList getPlaylistByPopularity() {
        PlayList playlist;
        Movie[] sortedMovies = this.collection.toArray(new Movie[this.collection.size()]);
        mergeSort(sortedMovies);
        playlist = new PlayList(sortedMovies);

        return playlist;
    }

    private void mergeSort(Movie[] unsorted) {
        if (unsorted.length > 1) {
            Movie[] left = leftHalf(unsorted);
            Movie[] right = rightHalf(unsorted);

            mergeSort(left);
            mergeSort(right);

            merge(unsorted, left, right);
        }
    }

    private Movie[] leftHalf(Movie[] unsorted) {
        int size1 = unsorted.length / 2;
        Movie[] left = new Movie[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = unsorted[i];
        }
        return left;
    }

    private Movie[] rightHalf(Movie[] unsorted) {
        int size1 = unsorted.length / 2;
        int size2 = unsorted.length - size1;
        Movie[] right = new Movie[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = unsorted[i + size1];
        }
        return right;
    }

    private void merge(Movie[] result, Movie[] left, Movie[] right) {
        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1].getAvgRating() >= right[i2].getAvgRating())) {
                result[i] = left[i1];
                i1++;
            } else {
                result[i] = right[i2];
                i2++;
            }
        }
    }

    public PlayList getPlaylistByGenre(String genre){
        PlayList playlist;

        playlist = new PlayList();
        for (Movie movie : collection){
            if (movie.hasGenre(genre))
                playlist.addMovie(movie);
        }
        return playlist;
    }

    public PlayList getPlayListByActor(String actor){
        PlayList playlist;

        playlist = new PlayList();
        for (Movie movie : collection){
            if (movie.belongsCast(actor))
                playlist.addMovie(movie);
        }
        return playlist;
    }
}
