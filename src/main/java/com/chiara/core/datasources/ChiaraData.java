package com.chiara.core.datasources;

import com.chiara.core.Library;
import com.chiara.core.Movie;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ChiaraData implements iDataSource {

    private JSONArray content;

    public ChiaraData (String path) throws IOException {
        InputStream is;
        String jsonTxt;
        File f;

        f = new File(path);
        is = f.exists() ? new FileInputStream(path) : ChiaraData.class.getResourceAsStream(path);
        jsonTxt = IOUtils.toString(is);
        this.content = (JSONArray) JSONSerializer.toJSON(jsonTxt);
    }

    @Override
    public Library getLibrary() {
        JSONObject json;
        Movie movie;
        Library library;

        library = new Library();
        for (Object element: this.content){
            json = (JSONObject) element;
            movie = new Movie (
                    json.getString("title"),
                    json.getInt("year"),
                    JSONArray.toCollection(json.getJSONArray("genres")),
                    JSONArray.toCollection(json.getJSONArray("ratings")),
                    json.getString("contentRating"),
                    json.getString("duration"),
                    json.getString("releaseDate"),
                    json.getString("originalTitle"),
                    json.getString("storyline"),
                    JSONArray.toCollection(json.getJSONArray("actors")),
                    json.getString("imdbRating"),
                    json.getString("posterurl")
            );
            library.addMovie(movie);
        }
        return library;
    }
}
