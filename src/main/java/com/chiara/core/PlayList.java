package com.chiara.core;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayList extends MovieCollection{

    private int index;

    public PlayList(){
        super();
    }

    public PlayList (ArrayList<Movie> list){
        super(list);
        this.index = 0;
    }

    public PlayList (Movie[] list){
        super(list);
        this.index = 0;
    }

    public Movie getCurrentElement (){
        return this.getMovie(this.index);
    }

    public Movie getPreviousElement(){
        this.index = this.index == 0 ? this.getMovieCount()-1 : --this.index;
        return this.getCurrentElement();
    }

    public Movie getNextElement (){
        this.index = this.index == this.getMovieCount()-1 ? 0 : ++this.index;
        return this.getCurrentElement();
    }
}
