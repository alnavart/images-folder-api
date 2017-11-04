package org.alnavart.imagesfolderapi

import groovy.io.FileType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.support.ResourcePatternResolver
import org.springframework.stereotype.Component

@Component
class ImagesRepository {

    @Autowired
    ResourcePatternResolver resourcePatternResolver
    @Value('${folder.path}')
    private String folder

    List<Image> findAll() {
        String currentPath = System.getProperty("user.dir")
        List<Image> images = []
        def dir = new File("${currentPath}/${folder}")
        dir.eachFileRecurse(FileType.FILES) { File file ->
            images << convertFrom(file)
        }
        images
    }

    private Image convertFrom(File file) {
        String filename = file.name
        String path = file.path
        new Image(filename, path)
    }
}
