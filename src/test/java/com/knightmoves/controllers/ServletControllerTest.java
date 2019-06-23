package com.knightmoves.controllers;

import com.knightmoves.app.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ Application.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ServletControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testWidthZero() {
        ResponseEntity<String> entity = this.restTemplate
                .getForEntity("/knight/servlet/count?width=0&height=8&start=A1&end=B8", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(entity.getBody()).isEqualTo("Not valid width.");
    }

}
