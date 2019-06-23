package com.knightmoves.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringController.class })
public class SpringControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new SpringController()).build();
    }

    @Test
    public void testWidthZero() throws Exception {
        this.mockMvc.perform(get("/knight/rest/count/")
                    .param("width", "0")
                    .param("height", "8")
                    .param("start", "A1")
                    .param("end", "B8"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Not valid width."));
    }

    @Test
    public void testWidthNegative() throws Exception {
        this.mockMvc.perform(get("/knight/rest/count/")
                    .param("width", "-1")
                    .param("height", "8")
                    .param("start", "A1")
                    .param("end", "B8"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Not valid width."));
    }

    @Test
    public void testHeightZero() throws Exception {
        this.mockMvc.perform(get("/knight/rest/count/")
                    .param("width", "8")
                    .param("height", "0")
                    .param("start", "A1")
                    .param("end", "B8"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Not valid height."));
    }

    @Test
    public void testHeightNegative() throws Exception {
        this.mockMvc.perform(get("/knight/rest/count/")
                    .param("width", "8")
                    .param("height", "-1")
                    .param("start", "A1")
                    .param("end", "B8"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Not valid height."));
    }

    @Test
    public void testStartZero() throws Exception {
        this.mockMvc.perform(get("/knight/rest/count/")
                    .param("width", "8")
                    .param("height", "8")
                    .param("start", "A0")
                    .param("end", "B8"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Not valid start."));
    }

    @Test
    public void testStartNegative() throws Exception {
        this.mockMvc.perform(get("/knight/rest/count/")
                    .param("width", "8")
                    .param("height", "8")
                    .param("start", "A-1")
                    .param("end", "B8"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Not valid start."));
    }

    @Test
    public void testStartWidthExceeded() throws Exception {
        this.mockMvc.perform(get("/knight/rest/count/")
                    .param("width", "8")
                    .param("height", "8")
                    .param("start", "I1")
                    .param("end", "B8"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Not valid start."));
    }

    @Test
    public void testStartHeightExceeded() throws Exception {
        this.mockMvc.perform(get("/knight/rest/count/")
                    .param("width", "8")
                    .param("height", "8")
                    .param("start", "A9")
                    .param("end", "B8"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Not valid start."));
    }

    @Test
    public void testEndZero() throws Exception {
        this.mockMvc.perform(get("/knight/rest/count/")
                    .param("width", "8")
                    .param("height", "8")
                    .param("start", "A1")
                    .param("end", "B0"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Not valid end."));
    }

    @Test
    public void testEndNegative() throws Exception {
        this.mockMvc.perform(get("/knight/rest/count/")
                    .param("width", "8")
                    .param("height", "8")
                    .param("start", "A1")
                    .param("end", "B-1"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Not valid end."));
    }

    @Test
    public void testEndWidthExceeded() throws Exception {
        this.mockMvc.perform(get("/knight/rest/count/")
                    .param("width", "8")
                    .param("height", "8")
                    .param("start", "A1")
                    .param("end", "M1"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Not valid end."));
    }

    @Test
    public void testEndHeightExceeded() throws Exception {
        this.mockMvc.perform(get("/knight/rest/count/")
                    .param("width", "8")
                    .param("height", "8")
                    .param("start", "A1")
                    .param("end", "B9"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Not valid end."));
    }

    @Test
    public void testMoveInputData_1() throws Exception {
        this.mockMvc.perform(get("/knight/rest/count/")
                    .param("width", "8")
                    .param("height", "8")
                    .param("start", "B1")
                    .param("end", "A3"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    public void testMoveInputData_2() throws Exception {
        this.mockMvc.perform(get("/knight/rest/count/")
                    .param("width", "30")
                    .param("height", "30")
                    .param("start", "A1")
                    .param("end", "AD30"))
                .andExpect(status().isOk())
                .andExpect(content().string("20"));
    }
}