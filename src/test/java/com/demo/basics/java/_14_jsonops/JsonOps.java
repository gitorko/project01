package com.demo.basics.java._14_jsonops;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

public class JsonOps {

    @Test
    @SneakyThrows
    public void test() {
        String json = "[{\"name\":\"accountKind\",\"value\":\"StorageV1\"},{\"name\":\"abc\",\"value\":\"def\"}]";
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, Object>> propLst = mapper.readValue(json, new TypeReference<List<HashMap<String, Object>>>() {
        });
        Map<String, String> resultMap = new HashMap<>();
        for (HashMap<String, Object> propMap : propLst) {
            String key = null;
            String value = null;
            for (Map.Entry<String, Object> entry : propMap.entrySet()) {
                if (entry.getKey().equals("name")) {
                    key = (String) entry.getValue();
                }
                if (entry.getKey().equals("value")) {
                    value = (String) entry.getValue();
                }
            }
            resultMap.put(key, value);
        }
        System.out.println(resultMap);
    }

}
