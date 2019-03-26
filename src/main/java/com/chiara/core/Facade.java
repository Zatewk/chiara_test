package com.chiara.core;

import com.chiara.core.datasources.ChiaraData;
import com.chiara.core.datasources.iDataSource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class Facade {
    private Library library;
    private HashMap<String, PlayList> playlists;

    public Facade (){
        iDataSource source = null;
        try {
            source = new ChiaraData("src/main/resources/movies-database-v2.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.library = source.getLibrary();
        this.playlists = new HashMap<String, PlayList>();
        this.playlists.put("Library", this.library.getDefaultPlaylist());
    }

    public Set<String> getAvailablePlaylists(){
        return this.playlists.keySet();
    }

    public boolean existPlaylist (String key){
        return this.playlists.containsKey(key);
    }

    public PlayList getPlaylist (String key){
        return this.playlists.get(key);
    }

    public void createPlayListbyPopularity (String name){
        this.playlists.put(name, this.library.getPlaylistByPopularity());
    }

    public void createPlayListbyActor (String name, String actor){
        this.playlists.put(name, this.library.getPlayListByActor(actor));
    }

    public void createPlayListbyGenre (String name, String genre){
        this.playlists.put(name, this.library.getPlaylistByGenre(genre));
    }
}
