package org.alnavart.imagesfolderapi.api

import org.alnavart.imagesfolderapi.Image
import org.alnavart.imagesfolderapi.ImagesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("images")
class ImagesAPI {

    @Autowired
    ImagesRepository repository

    @RequestMapping("/")
    List<APIImage> greeting() {
        return convertsFrom(repository.findAll())
    }

    static List<APIImage> convertsFrom(List<Image> images) {
        List apiImages = []
        images.each { Image image ->
            apiImages << new APIImage(image)
        }
        apiImages
    }
}
