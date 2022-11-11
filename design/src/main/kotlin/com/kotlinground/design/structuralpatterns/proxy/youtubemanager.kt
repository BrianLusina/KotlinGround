package com.kotlinground.design.structuralpatterns.proxy

// The interface of a remote service.
interface YouTubeLib {
    fun listVideos(): Collection<String>
    fun getVideoInfo(id: String): String
    fun downloadVideoInfo(id: String): String
}

// The concrete implementation of a service connector. Methods
// of this class can request information from YouTube. The speed
// of the request depends on a user's internet connection as
// well as YouTube's. The application will slow down if a lot of
// requests are fired at the same time, even if they all request
// the same information.
class YoutubeImpl : YouTubeLib {

    override fun listVideos(): Collection<String> {
        println("Listing videos from Youtube")
        return listOf("video1", "video2")
    }

    override fun getVideoInfo(id: String): String {
        println("Getting Video Info for $id from Youtube")
        return "$id-info"
    }

    override fun downloadVideoInfo(id: String): String {
        println("Downloading Video Info for $id from Youtube")
        return "video-$id-download"
    }
}

// To save some bandwidth, we can cache request results and keep
// them for some time. But it may be impossible to put such code
// directly into the service class. For example, it could have
// been provided as part of a third party library and/or defined
// as `final`. That's why we put the caching code into a new
// proxy class which implements the same interface as the
// service class. It delegates to the service object only when
// the real requests have to be sent.
class YouTubeCacheProxy(private val youtubeSvc: YouTubeLib) : YouTubeLib {
    private val listCache by lazy {
        println("[ProxyCache]: Listing Videos from Youtube")
        youtubeSvc.listVideos()
    }

    override fun listVideos(): Collection<String> {
        println("[Proxy]: Listing Videos from Youtube")
        return listCache
    }

    override fun getVideoInfo(id: String): String {
        val videoCache by lazy {
            println("[ProxyCache]: Getting Video $id from Youtube")
            youtubeSvc.getVideoInfo(id)
        }
        println("[Proxy]: Getting Video $id from Youtube")
        return videoCache
    }

    override fun downloadVideoInfo(id: String): String {
        val downloadedVid by lazy {
            println("[ProxyCache]: Downloading Video $id from Youtube")
            youtubeSvc.downloadVideoInfo(id)
        }
        println("[Proxy]: Downloading Video $id from Youtube")
        return downloadedVid
    }
}

// The GUI class, which used to work directly with a service
// object, stays unchanged as long as it works with the service
// object through an interface. We can safely pass a proxy
// object instead of a real service object since they both
// implement the same interface.
class YouTubeManager(private val service: YouTubeLib) {
    private fun renderVideoPage(id: String) {
        service.getVideoInfo(id)
    }

    private fun renderListPanel() {
        service.listVideos()
    }

    // Render the list of video thumbnails.
    fun reactOnUserInput(id: String) {
        renderVideoPage(id)
        renderListPanel()
    }
}

fun main() {
    val youtubeSvc = YoutubeImpl()
    val youtubeProxy = YouTubeCacheProxy(youtubeSvc)
    val manager = YouTubeManager(youtubeProxy)

    for (i in 0..10) {
        manager.reactOnUserInput("$i")
    }
}
