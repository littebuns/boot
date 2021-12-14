package com.example.jar.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Map;

/**
 * 利用jackson实现json的遍历
 */
public class JsonLeaf {

    private String str1 = "{\n" +
            "\"name\":\"xxb\"\n" +
            "}";

    public static JsonNode jsonLeaf(JsonNode node) {
        if (node.isValueNode()) {
            System.out.println(node);
        }

        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> it = node.fields();
            while (it.hasNext()) {
                Map.Entry<String, JsonNode> entry = it.next();
                jsonLeaf(entry.getValue());
            }
        }

        if (node.isArray()) {
            Iterator<JsonNode> it = node.iterator();
            while (it.hasNext()) {
                jsonLeaf(it.next());
            }
        }
        return node;
    }

    @Test
    public void t1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(str1);
        System.out.println(jsonLeaf(jsonNode));
    }




    private String str = "{\n" +
            "    \"bkOrder\":{\n" +
            "        \"arrivlDate\":\"2021-11-22 09:49:47\",\n" +
            "        \"bargeTerminalName\":\"\",\n" +
            "        \"blNo\":\"\",\n" +
            "        \"bookingNumber\":\"\",\n" +
            "        \"cargoDescription\":\"\",\n" +
            "        \"comments\":\"\",\n" +
            "        \"company\":\"\",\n" +
            "        \"cutPortTime\":\"2021-11-22 09:49:47\",\n" +
            "        \"cutVgmTime\":\"2021-11-22 09:49:47\",\n" +
            "        \"eta\":\"2021-11-22 09:49:47\",\n" +
            "        \"etd\":\"2021-11-22 09:49:47\",\n" +
            "        \"finalDestinationCode\":\"\",\n" +
            "        \"grossWeight\":0,\n" +
            "        \"hsCode\":\"\",\n" +
            "        \"netWeight\":0,\n" +
            "        \"notifierTwo\":\"\",\n" +
            "        \"orderNo\":\"\",\n" +
            "        \"paidAtLocation\":\"\",\n" +
            "        \"paymentType\":\"\",\n" +
            "        \"placeOfDeliveryCode\":\"\",\n" +
            "        \"placeOfReceiptCode\":\"\",\n" +
            "        \"portOfDischargeCode\":\"\",\n" +
            "        \"portOfLoadingCode\":\"\",\n" +
            "        \"sctNumber\":\"\",\n" +
            "        \"serviceCode\":\"\",\n" +
            "        \"shipperName\":\"\",\n" +
            "        \"specialCyinCode\":\"\",\n" +
            "        \"status\":\"\",\n" +
            "        \"terminalName\":\"\",\n" +
            "        \"terminalTime\":\"2021-11-22 09:49:47\",\n" +
            "        \"transPortCode\":\"\",\n" +
            "        \"transportTerm\":\"\",\n" +
            "        \"vessel\":\"\",\n" +
            "        \"voyage\":\"\"\n" +
            "    },\n" +
            "    \"bkCtn\":[\n" +
            "        {\n" +
            "            \"ctnSizeType\":\"20GP\",\n" +
            "            \"ctnQuantity\":1\n" +
            "        },\n" +
            "        {\n" +
            "            \"ctnSizeType\":\"40GP\",\n" +
            "            \"ctnQuantity\":1\n" +
            "        }\n" +
            "    ]\n" +
            "}\n";
}
