package com.example.jar.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Map;

/**
 * jsonNode  的各种用法
 */
@Slf4j
public class JsonNodeDemon {

    ObjectMapper mapper = JacksonConfiguration.getMapper();

    String str = "{\n" +
            "    \"sourceExSysCode\":\"BMWEB\",\n" +
            "    \"sourceList\":[\n" +
            "        {\n" +
            "            \"exCodes\":[\n" +
            "                \"DEAAC\",\n" +
            "                \"AACH\"\n" +
            "            ],\n" +
            "            \"typeCode\":\"port\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"exCodes\":[\n" +
            "                \"40RF\"\n" +
            "            ],\n" +
            "            \"typeCode\":\"cntrType\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"targetExSysCode\":\"ILP\",\n" +
            "    \"targetList\":[\n" +
            "\n" +
            "    ]\n" +
            "}";

    /**
     * 遍历当前结构的所有键值对
     * @throws JsonProcessingException
     */
    @Test
    public void t1() throws JsonProcessingException {
        JsonNode jsonNode = mapper.readValue(str, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
        while (fields.hasNext()){
            Map.Entry<String, JsonNode> next = fields.next();
            log.info(next.getKey());
            log.info(next.getValue().toString());
        }
    }



}
