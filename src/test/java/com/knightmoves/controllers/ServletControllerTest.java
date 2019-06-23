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

    @Test
    public void testWidthNegative() {
        ResponseEntity<String> entity = this.restTemplate
                .getForEntity("/knight/servlet/count?width=-1&height=8&start=A1&end=B8", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(entity.getBody()).isEqualTo("Not valid width.");
    }

    @Test
    public void testHeightZero() {
        ResponseEntity<String> entity = this.restTemplate
                .getForEntity("/knight/servlet/count?width=8&height=0&start=A1&end=B8", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(entity.getBody()).isEqualTo("Not valid height.");
    }

    @Test
    public void testHeightNegative() {
        ResponseEntity<String> entity = this.restTemplate
                .getForEntity("/knight/servlet/count?width=8&height=-1&start=A1&end=B8", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(entity.getBody()).isEqualTo("Not valid height.");
    }

    @Test
    public void testStartZero() {
        ResponseEntity<String> entity = this.restTemplate
                .getForEntity("/knight/servlet/count?width=8&height=8&start=A0&end=B8", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(entity.getBody()).isEqualTo("Not valid start.");
    }

    @Test
    public void testStartNegative() {
        ResponseEntity<String> entity = this.restTemplate
                .getForEntity("/knight/servlet/count?width=8&height=8&start=A-1&end=B8", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(entity.getBody()).isEqualTo("Not valid start.");
    }

    @Test
    public void testStartWidthExceeded() {
        ResponseEntity<String> entity = this.restTemplate
                .getForEntity("/knight/servlet/count?width=8&height=8&start=I1&end=B8", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(entity.getBody()).isEqualTo("Not valid start.");
    }

    @Test
    public void testStartHeightExceeded() {
        ResponseEntity<String> entity = this.restTemplate
                .getForEntity("/knight/servlet/count?width=8&height=8&start=A9&end=B8", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(entity.getBody()).isEqualTo("Not valid start.");
    }

    @Test
    public void testEndZero() {
        ResponseEntity<String> entity = this.restTemplate
                .getForEntity("/knight/servlet/count?width=8&height=8&start=A1&end=B0", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(entity.getBody()).isEqualTo("Not valid end.");
    }

    @Test
    public void testEndNegative() {
        ResponseEntity<String> entity = this.restTemplate
                .getForEntity("/knight/servlet/count?width=8&height=8&start=A1&end=B-1", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(entity.getBody()).isEqualTo("Not valid end.");
    }

    @Test
    public void testEndWidthExceeded() {
        ResponseEntity<String> entity = this.restTemplate
                .getForEntity("/knight/servlet/count?width=8&height=8&start=A1&end=M1", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(entity.getBody()).isEqualTo("Not valid end.");
    }

    @Test
    public void testEndHeightExceeded() {
        ResponseEntity<String> entity = this.restTemplate
                .getForEntity("/knight/servlet/count?width=8&height=8&start=A1&end=B9", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(entity.getBody()).isEqualTo("Not valid end.");
    }

    @Test
    public void testMoveInputData_1() {
        ResponseEntity<String> entity = this.restTemplate
                .getForEntity("/knight/servlet/count?width=8&height=8&start=B1&end=A3", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isEqualTo("1");
    }

    @Test
    public void testMoveInputData_2() {
        ResponseEntity<String> entity = this.restTemplate
                .getForEntity("/knight/servlet/count?width=30&height=30&start=A1&end=AD30", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isEqualTo("20");
    }
}