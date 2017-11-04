package org.alnavart.imagesfolderapi

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("images")
class ImagesAPI {

    @RequestMapping("/")
    List<Image> greeting() {
        return [new Image('1', 'Pedro', 'url'),
                new Image("2", "Paco", "url2")]
    }
}
