package org.alnavart.imagesfolderapi.api

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

import static org.hamcrest.Matchers.equalTo
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ImagesAPITest {

    @Autowired
    private MockMvc mockMvc

    @Test
    void listsImages() {
        this.mockMvc.perform(get("/images/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())

                .andExpect(jsonPath('$[0].fileName', equalTo('dancing_jesus.gif')))
                .andExpect(jsonPath('$[0].name', equalTo('dancing_jesus')))
                .andExpect(jsonPath('$[0].extension', equalTo('gif')))

                .andExpect(jsonPath('$[1].fileName', equalTo('enjuto.jpeg')))
                .andExpect(jsonPath('$[1].name', equalTo('enjuto')))
                .andExpect(jsonPath('$[1].extension', equalTo('jpeg')))

                .andExpect(jsonPath('$[2].fileName', equalTo('gato arcoiris.png')))
                .andExpect(jsonPath('$[2].name', equalTo('gato arcoiris')))
                .andExpect(jsonPath('$[2].extension', equalTo('png')))

                .andExpect(jsonPath('$[3].fileName', equalTo('maicol-con-et.jpg')))
                .andExpect(jsonPath('$[3].name', equalTo('maicol-con-et')))
                .andExpect(jsonPath('$[3].extension', equalTo('jpg')))
    }
}
