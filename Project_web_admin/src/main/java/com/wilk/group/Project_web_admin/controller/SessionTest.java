package com.wilk.group.Project_web_admin.controller;
import  org.aspectj.lang.annotation.Before;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.http.ResponseEntity;
import  java.util.Set;
import org.springframework.http.HttpStatus;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;

public class SessionTest {

    private Jedis jedis;
    private TestRestTemplate testRestTemplate;
    private TestRestTemplate testRestTemplateWithAuth;
    private String testUrl = "http://localhost:8080/";

    @Before
    public void clearRedisData() {
        testRestTemplate = new TestRestTemplate();
        testRestTemplateWithAuth = new TestRestTemplate("user", "password", null);

        jedis = new Jedis("localhost", 6379);
        jedis.flushAll();
    }


    @Test
    public void testRedisIsEmpty() {
        Set<String> result = jedis.keys("*");
        assertEquals(0, result.size());
    }


    @Test
    public void testUnauthenticatedCantAccess() {
        ResponseEntity<String> result = testRestTemplate.getForEntity(testUrl, String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
    }


    @Test
    public void testRedisControlsSession() {
        ResponseEntity<String> result = testRestTemplateWithAuth.getForEntity(testUrl, String.class);
        assertEquals("hello admin", result.getBody()); //login worked

        Set<String> redisResult = jedis.keys("*");
        assertTrue(redisResult.size() > 0); //redis is populated with session data

        String sessionCookie = result.getHeaders().get("Set-Cookie").get(0).split(";")[0];
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.add("Cookie", sessionCookie);
        org.springframework.http.HttpEntity<String> httpEntity = new org.springframework.http.HttpEntity<>(headers);

        result = testRestTemplate.exchange(testUrl, org.springframework.http.HttpMethod.GET, httpEntity, String.class);
        assertEquals("hello admin", result.getBody()); //access with session works worked

        jedis.flushAll(); //clear all keys in redis

        result = testRestTemplate.exchange(testUrl, org.springframework.http.HttpMethod.GET, httpEntity, String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
        //access denied after sessions are removed in redis
    }

}