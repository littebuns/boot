package com.example.boot.jar.prometheus;


import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryDemon {

    private static String ProQueryUrl = "/api/v1/query";
    private static String IP = "http://192.168.100.5:9090";


    public static String buildUrl(Map<String, String> map){
        String url = IP + ProQueryUrl + "?";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            url += entry.getKey() + "=" + entry.getValue();
        }
        return url;
    }

//    public static String sendRequest(String url) throws Exception{
//        try(CloseableHttpClient httpclient = HttpClients.createDefault()) {
//            HttpGet httpGet = new HttpGet(url);
//            try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
//                HttpEntity entity1 = response1.getEntity();
//                InputStream content = entity1.getContent();
//                String result = IOUtils.toString(content);
//                //关闭 httpEntity 这个流
//                EntityUtils.consume(entity1);
//                return result;
//            }
//        }
//    }




    @Test
    public void test1() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        map.put("query", "openstack_nova_agent_state");
        String url = buildUrl(map);
//        String result = sendRequest(url);
//        System.out.println(result);
    }



//    /**
//     * 测试 httpClient
//     */
//    @Test
//    public void test() throws Exception{
//        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
//            HttpGet httpGet = new HttpGet("http://httpbin.org/get");
//            try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
////                System.out.println(response1.getCode() + " " + response1.getReasonPhrase());
//                HttpEntity entity1 = response1.getEntity();
//                InputStream content = entity1.getContent();
//                String s = IOUtils.toString(content);
//                System.out.println("================" + s);
//                //关闭 httpEntity 这个流
//                EntityUtils.consume(entity1);
//                System.out.println("===========" + entity1);
//            }
//
//            HttpPost httpPost = new HttpPost("http://httpbin.org/post");
//            List<NameValuePair> nvps = new ArrayList<>();
//            nvps.add(new BasicNameValuePair("username", "vip"));
//            nvps.add(new BasicNameValuePair("password", "secret"));
//            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
//
//            try (CloseableHttpResponse response2 = httpclient.execute(httpPost)) {
//                HttpEntity entity2 = response2.getEntity();
//                EntityUtils.consume(entity2);
//            }
//        }
    }




