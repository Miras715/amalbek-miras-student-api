package kz.iitu.studentapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentApiApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void createAndGetStudent() throws Exception {
        String json = "{\"firstName\":\"Miras\",\"lastName\":\"Amalbek\",\"email\":\"miras@iitu.kz\",\"groupName\":\"IT2-2313\"}";
        mvc.perform(post("/api/students").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.lastName").value("Amalbek"));
        mvc.perform(get("/api/students"))
                .andExpect(status().isOk());
    }

    @Test
    void unknownStudentReturns404() throws Exception {
        mvc.perform(get("/api/students/9999"))
                .andExpect(status().isNotFound());
    }
}
