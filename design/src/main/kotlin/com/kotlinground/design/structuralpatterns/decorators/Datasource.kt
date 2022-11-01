package com.kotlinground.design.structuralpatterns.decorators

interface DataSource {
    fun write(data: String)
    fun read(): String
}

class DataSourceImpl : DataSource {
    override fun write(data: String) {
        TODO("Not yet implemented")
    }

    override fun read(): String {
        TODO("Not yet implemented")
    }
}

class FileDataSource(private val filename: String) : DataSource {

    override fun read(): String {
        return filename
    }

    override fun write(data: String) {
        filename.plus(data)
    }
}

class EncryptedDataSource(private val repo: DataSource) : DataSource by repo {
    override fun read(): String {
        TODO("Not yet implemented")
    }

    override fun write(data: String) {
        TODO("Not yet implemented")
    }
}

class CompressionDataSource(private val repo: DataSource) : DataSource by repo {
    override fun read(): String {
        TODO("Not yet implemented")
    }

    override fun write(data: String) {
        TODO("Not yet implemented")
    }
}

fun main() {
    val fileSource = FileDataSource("file.data")
    val withCompression = CompressionDataSource(fileSource)
    withCompression.write("records")

    val withEncryption = EncryptedDataSource(fileSource)
    withEncryption.write("records")
}
