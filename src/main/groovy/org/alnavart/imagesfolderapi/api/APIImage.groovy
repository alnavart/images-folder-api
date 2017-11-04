package org.alnavart.imagesfolderapi.api

import org.alnavart.imagesfolderapi.Image;

class APIImage {

    String fileName
    String name
    String extension

    APIImage(Image image) {
        this.fileName = image.fileName
        this.name = image.getName()
        this.extension = image.getExtension()
    }
}
