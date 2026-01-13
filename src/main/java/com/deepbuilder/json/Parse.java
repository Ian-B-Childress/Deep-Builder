package com.deepbuilder.json;

import com.deepbuilder.entities.Stat.StatType;
import com.deepbuilder.entities.Talent;
import com.deepbuilder.services.TalentService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component
public class Parse implements CommandLineRunner {
    TalentService talentService;


    public Parse(TalentService talentService) {
        this.talentService = talentService;
    }

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
            Map<StatType, Integer> map = new EnumMap<>(StatType.class);
            String key = talentKeys.next();
            JsonNode talentJson = root.get(key);

            String statName;
            int statValue;

            StatType strength = StatType.Strength;
            JsonNode reqNode = talentJson.get("reqs");
            JsonNode baseReqs = reqNode.get("base");
            JsonNode weaponReqs = reqNode.get("weapon");
            JsonNode attunementReq = reqNode.get("attunement");

          Iterator<String> baseFieldNames = baseReqs.fieldNames();
          Iterator<String> weaponFieldNames = weaponReqs.fieldNames();
          Iterator<String> attunementFieldNames = attunementReq.fieldNames();
          int count = 0;

          while (baseFieldNames.hasNext()){
              count++;
              statName = baseFieldNames.next();
              statValue = baseReqs.get(statName).intValue();

              StatType name = StatType.valueOf(statName);

              map.put(name, statValue);

              if(count == 8){
                  count = 0;
                  while(count < 4){
                      count++;
                      statName = weaponFieldNames.next().s;
                      statValue = weaponReqs.get(statName).intValue();

                      name = StatType.valueOf(statName);
                      map.put(name, statValue);
                  }
                  count = 0;
              }
          }

            System.out.println(talentJson.get("name").asText());
            System.out.println(map.toString());
        }
    }


}

