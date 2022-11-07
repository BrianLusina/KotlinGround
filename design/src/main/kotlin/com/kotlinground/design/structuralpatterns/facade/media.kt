package com.kotlinground.design.structuralpatterns.facade

import java.io.File

interface Codec {
    val type: String
}

data class VideoFile(val name: String, val codecType: String = name.substring(name.indexOf(".") + 1))

class Mpeg4CompressionCodec : Codec {
    override val type: String
        get() = "mp4"
}

class OggCompressionCodec : Codec {
    override val type: String
        get() = "ogg"
}

class CodecFactory {
    companion object {
        fun extract(file: VideoFile): Codec = when (file.codecType) {
            "mp4" -> Mpeg4CompressionCodec()
            "ogg" -> Mpeg4CompressionCodec()
            else -> throw Exception("Unknown codec")
        }
    }
}

class BitRateReader {
    companion object {
        fun read(videoFile: VideoFile, codec: Codec): VideoFile {
            return videoFile
        }

        fun convert(buffer: VideoFile, codec: Codec): VideoFile {
            return buffer
        }
    }
}

class AudioMixer {
    fun fix(videoFile: VideoFile): File = File("tmp")
}

// Facade for video conversion
class VideoConversion {
    fun convertVideo(fileName: String, format: String): File {
        val videoFile = VideoFile(fileName)
        val sourceCodec = CodecFactory.extract(videoFile)
        val destinationCodec = if (format == "mp4") {
            Mpeg4CompressionCodec()
        } else {
            OggCompressionCodec()
        }

        val buffer = BitRateReader.read(videoFile, sourceCodec)
        val intermediateResult = BitRateReader.convert(buffer, destinationCodec)
        return AudioMixer().fix(intermediateResult)
    }
}

fun main() {
    val vc = VideoConversion()
    val mp4Video = vc.convertVideo("video.ogg", "mp4")
}
