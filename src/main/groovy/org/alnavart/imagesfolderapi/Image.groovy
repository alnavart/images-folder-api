package org.alnavart.imagesfolderapi

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class Image {
    String fileName
    String path

    Image(String fileName, String path) {
        this.fileName = fileName
        this.path = path
    }

    String getName() {
        fileName.take(fileName.lastIndexOf('.'))
    }

    String getExtension() {
        fileName.split("\\.")[1]
    }
}
