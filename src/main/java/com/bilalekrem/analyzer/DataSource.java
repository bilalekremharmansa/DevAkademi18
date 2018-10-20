package com.bilalekrem.analyzer;

import com.bilalekrem.Main;
import com.bilalekrem.endpoints.AllData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataSource {

    private static DataSource singleton;

    private List<AllData> immutableData;

    public DataSource() {
        try{
            File f = new File(Main.class.getResource("../../all_data.json").getFile());
            InputStream in = new FileInputStream(f);
            byte[] ba = new byte[in.available()];
            in.read(ba);
            in.close();

            Gson gson = new GsonBuilder().create();
            List<AllData> data = gson.fromJson(new String(ba), new TypeToken<ArrayList<AllData>>(){}.getType());
            immutableData = Collections.unmodifiableList(data);
        }catch (IOException ex) {
            System.out.println("error");
        }
    }

    public static DataSource getInstance() {
        if(singleton == null) singleton = new DataSource();
        return singleton;
    }

    public List<AllData> data() {
        return immutableData;
    }
}
