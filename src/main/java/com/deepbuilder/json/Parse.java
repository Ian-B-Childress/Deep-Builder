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
            Talent newTalent = new Talent();
            Map<StatType, Integer> map = new EnumMap<>(StatType.class);
            String key = talentKeys.next();
            JsonNode talentJson = root.get(key);

            String statName;
            int statValue;
            String description;

            StatType strength = StatType.Strength;
            JsonNode reqNode = talentJson.get("reqs");
            JsonNode baseReqs = reqNode.get("base");
            JsonNode weaponReqs = reqNode.get("weapon");
            JsonNode attunementReq = reqNode.get("attunement");
            JsonNode talentDesc = talentJson.get("desc");

          Iterator<String> baseFieldNames = baseReqs.fieldNames();
          Iterator<String> weaponFieldNames = weaponReqs.fieldNames();
          Iterator<String> attunementFieldNames = attunementReq.fieldNames();
          int count = 0;

          while (baseFieldNames.hasNext()){
              count++;
              statName = baseFieldNames.next();
              statValue = baseReqs.get(statName).intValue();
              description = talentDesc.toString();

              StatType name = StatType.valueOf(statName);

              map.put(name, statValue);
               newTalent.setTalentName(String.valueOf(talentJson.get("name")));
               newTalent.setRequirements(name, statValue);
               newTalent.setTalentDesc(description);

              if(count >= 8 && weaponFieldNames.hasNext()){
                  count = 0;
                  while(count < 3){
                      count++;
                      statName = weaponFieldNames.next();
                      String enumName = statName.split(" ")[0];
                      statValue = weaponReqs.get(statName).intValue();

                      name = StatType.valueOf(enumName);
                      map.put(name, statValue);
                      newTalent.setRequirements(name, statValue);
                  }
                  count = 0;
                  while(count < 7 && attunementFieldNames.hasNext()){
                      count++;
                      statName = attunementFieldNames.next();
                      statValue = attunementReq.get(statName).intValue();

                      name = StatType.valueOf(statName);
                      map.put(name, statValue);
                      newTalent.setRequirements(name, statValue);

                  }
              }
          }
            talentService.createTalent(newTalent);
            System.out.println(newTalent.getTalentName());
            System.out.println(newTalent.getRequirements());
            System.out.println(newTalent.getTalentDesc());
        }
    }


}

