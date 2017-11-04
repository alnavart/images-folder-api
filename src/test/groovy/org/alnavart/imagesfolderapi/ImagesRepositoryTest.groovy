package org.alnavart.imagesfolderapi

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

@RunWith(SpringRunner)
@SpringBootTest
class ImagesRepositoryTest {

    @Autowired
    ImagesRepository repository

    @Test
    void findsAll() {
        String currentPath = System.getProperty("user.dir")
        List expectedImages = ['dancing_jesus.gif', 'enjuto.jpeg', 'gato arcoiris.png', 'maicol-con-et.jpg']

        assertThat(repository.findAll(),
                containsInAnyOrder(
                        new Image(expectedImages.get(0), "${currentPath}/test-images/${expectedImages.get(0)}"),
                        new Image(expectedImages.get(1), "${currentPath}/test-images/${expectedImages.get(1)}"),
                        new Image(expectedImages.get(2), "${currentPath}/test-images/${expectedImages.get(2)}"),
                        new Image(expectedImages.get(3), "${currentPath}/test-images/${expectedImages.get(3)}")
                ))
    }
}