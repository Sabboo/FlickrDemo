package com.example.flickrdemo.utilities

class Constants {
    companion object {
        const val API_KEY = "5112719369700f441b306c1800a21524"
        const val API_METHOD_NAME = "flickr.photos.getRecent"
        const val LIST_OF_PHOTOS_SERVICE_END_POINT = "https://api.flickr.com/services/rest/"
        const val PHOTO_SERVICE_END_POINT =
            "https://farm{farmId}.staticflickr.com/{serverId}/{secretId}_{photoId}.jpg"
        const val PHOTOS_PAGE_LIMIT = 10
        const val SERVICE_RESPONSE_TYPE = "json"
    }
}