package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

//@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OracleApplicationTests {

    @Test
    void contextLoads() {
    }

    /*@Autowired
    private MockMvc mockMvc;

    @Test
    public void getsAllRides() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ride")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getsSingleRide() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ride/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void returnsNotFoundForInvalidSingleRide() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ride/4")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void addsNewRide() throws Exception {
        String newRide = "{\"name\":\"Monorail\",\"description\":\"Sedate travelling ride.\",\"thrillFactor\":2,\"vomitFactor\":1}";
        mockMvc.perform(MockMvcRequestBuilders.post("/ride")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newRide)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }*/
}
