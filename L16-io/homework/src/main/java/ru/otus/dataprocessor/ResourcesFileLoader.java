package ru.otus.dataprocessor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.otus.model.Measurement;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ResourcesFileLoader implements Loader {
    private final ObjectMapper mapper = new ObjectMapper();
    private String fileName;

    public ResourcesFileLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Measurement> load() throws IOException {
        //читает файл, парсит и возвращает результат
        List<Measurement> myObjects = mapper.readValue(
                new InputStreamReader(ResourcesFileLoader.class.getClassLoader().getResourceAsStream("inputData.json")),
                new TypeReference<List<Measurement>>(){});
        System.out.println(myObjects);
        return myObjects;
    }
}
