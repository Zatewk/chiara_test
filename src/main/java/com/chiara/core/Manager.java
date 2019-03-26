package com.chiara.core;

import com.chiara.core.datasources.ChiaraData;
import com.chiara.core.datasources.iDataSource;

import java.io.IOException;

public class Manager {
    public static void main(String[] args){
        try {
            iDataSource source = new ChiaraData("src/main/resources/movies-database-v2.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
