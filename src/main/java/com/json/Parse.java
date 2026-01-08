package com.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

@Component
public class Parse implements CommandLineRunner {
    @Override
    public void run(String... args) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/talents.json");
        if(inputStream == null){
            throw new RuntimeException("talents.json cant be found.");
        }
        ObjectMapper om = new ObjectMapper();

        JsonNode root = om.readTree(inputStream);

        Iterator<String> talentKeys = root.fieldNames();

        while(talentKeys.hasNext()){
            String key = talentKeys.next();
            JsonNode talentJson = root.get(key);

            System.out.println(talentJson.get("name").asText());
        }
    }


}
