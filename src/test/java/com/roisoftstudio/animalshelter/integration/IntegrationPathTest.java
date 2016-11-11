package com.roisoftstudio.animalshelter.integration;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.body.Body;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationPathTest {

    private static final String CONTAINER_URL = "http://localhost:18080/";

    @Test
    public void testPath() throws Exception {
        String response = Unirest.get(CONTAINER_URL).asString().getBody();
        assertThat(response).isEqualTo("Hello Docker World");
    }

}
