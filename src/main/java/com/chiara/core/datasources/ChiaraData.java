package com.chiara.core.datasources;

import com.chiara.core.PlayList;
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

        System.out.println(jsonTxt);
        this.content = (JSONArray) JSONSerializer.toJSON(jsonTxt);
    }

    @Override
    public PlayList getPlaylist() {
        return null;
    }
}
