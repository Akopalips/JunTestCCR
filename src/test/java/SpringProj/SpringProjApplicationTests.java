package SpringProj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringProjApplicationTests {

    @Autowired
    private MockMvc mockMvc;


    //@Test
    public void getAllShouldReturnOK() throws Exception {
        mockMvc.perform(get("/newsType/"))
                .andExpect(status().isOk());
    }

    public void testingNewsController(Long NewsTypeId) throws Exception {

        String testEntityString =
                mockMvc.perform(post("/news/new")
                        .content("{\"name\":\"testNews\", \"typeId\":"+NewsTypeId+", \"aboutShort\":\"short\", \"aboutFull\":\"full\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated())
                        .andExpect(content().string(containsString("created")))
                        .andReturn().getResponse().getContentAsString().split("}", 2)[0];
        Long id = Long.parseLong(testEntityString.split(",", 2)[0].split(":", 2)[1]);

        mockMvc.perform(get("/news/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(testEntityString)));

        mockMvc.perform(get("/news/get/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(testEntityString)));

        mockMvc.perform(put("/news/update/{id}", id)
                .content("{\"aboutShort\":\"shortModified\"}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(testEntityString)));

        testEntityString =
        mockMvc.perform(get("/news/get/{id}", id))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString().split("}", 2)[0];

        mockMvc.perform(get("/news/typeFilter/{NewsTypeId}", NewsTypeId))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(testEntityString)));

        mockMvc.perform(delete("/news/delete/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("has been removed")));

        mockMvc.perform(get("/news/get/{id}", id))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testingAllControllers() throws Exception {
        String testEntityString =
                mockMvc.perform(post("/newsType/new")
                        .content("{\"name\":\"testType\",\"color\":\"red\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated())
                        .andExpect(content().string(containsString("created")))
                        .andReturn().getResponse().getContentAsString().split("}", 2)[0];
        Long id = Long.parseLong(testEntityString.split(",", 2)[0].split(":", 2)[1]);

        mockMvc.perform(get("/newsType/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(testEntityString)));

        mockMvc.perform(get("/newsType/get/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(testEntityString)));

        mockMvc.perform(put("/newsType/update/{id}", id)
                .content("{\"color\":\"grey\"}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(testEntityString)));

        testingNewsController(id);

        mockMvc.perform(delete("/newsType/delete/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("has been removed")));

        mockMvc.perform(get("/newsType/get/{id}", id))
                .andExpect(status().isNotFound());
    }




//	@Test
//	public void createNews() throws Exception {
//		this.mockMvc.perform(post("/news/new/")
//				.param("{\"name\":\"test\",\"about_short\":\"test entity\",\"about_full\": \"should be deleted automatically.\", \"typeId\":2}"))
//	}


}
