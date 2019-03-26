package com.chiara.core;

import com.chiara.core.datasources.ChiaraData;
import com.chiara.core.datasources.iDataSource;

import java.io.IOException;

public class Facade {
    public static void main(String[] args){
        Library library;
        PlayList p1, p2, p3;

        try {
            iDataSource source = new ChiaraData("src/main/resources/movies-database-v2.json");
            library = source.getLibrary();

            System.out.println("TERMINADO");

            p1 = library.getPlaylistByGenre("Drama");
            p2 = library.getPlayListByActor("Hugh Jackman");
            p3 = library.getPlaylistByPopularity();

            System.out.println("TERMINADO");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
