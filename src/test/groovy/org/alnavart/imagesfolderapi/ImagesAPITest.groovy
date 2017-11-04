package org.alnavart.imagesfolderapi

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

import static org.hamcrest.Matchers.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@RunWith(SpringRunner.class)
@WebMvcTest(ImagesAPI.class)
class ImagesAPITest {
    @Autowired
    private MockMvc mvc

    @Test
    void listsImages() {
        this.mvc.perform(get("/images/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath('$[0].id', equalTo('1')))
                .andExpect(jsonPath('$[0].name', equalTo('Pedro')))
                .andExpect(jsonPath('$[0].url', equalTo('url')))
                .andExpect(jsonPath('$[1].id', equalTo('2')))
                .andExpect(jsonPath('$[1].name', equalTo('Paco')))
                .andExpect(jsonPath('$[1].url', equalTo('url2')))
    }
}
