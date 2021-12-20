package com.example.jar.jackson;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * 将String 解析为json对象或javabean
 */
@Slf4j
public class ParseJson {

    ObjectMapper mapper = JacksonConfiguration.getMapper();

    String str = "{\n" +
            "\"name\":\"xxb\",\n" +
            "\"id\":1\n" +
            "}";

    /**
     * Stirng 转对象
     * @throws JsonProcessingException
     */
    @Test
    public void t1() throws JsonProcessingException {
        Car car = mapper.readValue(str, Car.class);
        System.out.println(car);
    }

    /**
     * String 转Map
     * @throws JsonProcessingException
     */
    @Test
    public void t2() throws JsonProcessingException {
        Map<String, Object> map = mapper.readValue(str, new TypeReference<Map<String, Object>>() {});
        log.info(String.valueOf(map));
    }

    /**
     * String 转 jsonNode
     * @throws JsonProcessingException
     */
    @Test
    public void t3() throws JsonProcessingException {
        JsonNode jsonNode = mapper.readValue(str, JsonNode.class);
        JsonNode name = jsonNode.get("name");
        JsonNode id = jsonNode.get("id");
        log.info(String.valueOf(id.asInt()));
        log.info(name.asText());
    }



}
