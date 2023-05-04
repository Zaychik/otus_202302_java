package ru.otus.dataprocessor;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import ru.otus.model.Measurement;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class ResourcesFileLoader implements Loader {
    private String fileName;
    public ResourcesFileLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Measurement> load() throws IOException {
        List<Measurement> list;
        var gson = new Gson();
        try (JsonReader jsonReader = new JsonReader(new InputStreamReader(ResourcesFileLoader.class.getClassLoader().getResourceAsStream("inputData.json")))) {
            Type listType = new TypeToken<List<Measurement>>() {}.getType();
            list = gson.fromJson(jsonReader, listType);
        }
        return list;
    }
}
