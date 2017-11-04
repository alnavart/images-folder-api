package org.alnavart.imagesfolderapi

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class Image {
    String fileName
    String url

    Image(String fileName, String url) {
        this.fileName = fileName
        this.url = url
    }

    String getName() {
        fileName.take(fileName.lastIndexOf('.'))
    }
}
