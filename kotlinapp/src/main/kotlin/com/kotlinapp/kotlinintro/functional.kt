package com.kotlinapp.kotlinintro

import java.security.Provider
import java.security.Security

/**
 * @author lusinabrian on 28/05/17.
 * Functional programming in Kotlin
 */

fun main(args: Array<String>) {
    val providers = Providers()
    val details = providers.getAllProviders()
    val filteredData = providers.getFilteredProviders("random")
    val filteredDataFlatMap = providers.getFilteredProvidersEx("Random")

    filteredData.forEach(::println)
    filteredDataFlatMap.forEach(::println)

    // 3 ways to do this
    // 1
//    details.forEach{
//        entry -> println("ProviderName: ${entry.providerName}, name: ${entry.name}")
//    }
//
//    // using it
//    details.forEach{
//        println("ProviderName: ${it.providerName}, name: ${it.name}")
//    }
//
    // using a function reference
//    details.forEach(::println)

    // passing in println function
    //  getAllProviders { key -> println("Provider: $key") }
}

/**
 * Parameter is a function
 * */
fun getAllProviders(fn: (String) -> Unit) {
    val allProviders = Providers.getProviders()

    allProviders.forEach { key -> fn(key.toString()) }
}

/**
 * Data class of provider details
 * */
data class ProviderDetails(val providerName: String, val name: String)

class Providers {
    fun getProviders(): List<Provider> {
        val providers = Security.getProviders()
        val listOfProviders: List<Provider> = providers.asList()
        return listOfProviders
    }

    /**
     * Returns a list of provider details
     * */
    fun getAllProviders(): List<ProviderDetails> {
        val providers = Security.getProviders()
        val listOfProviders = mutableListOf<ProviderDetails>()

        // iterate over providers and create provider details from it
        providers.forEach {
            provider ->
            val providerDetails = provider.entries.map {
                ProviderDetails(provider.name, it.key.toString())
            }
            listOfProviders += providerDetails
        }

        return listOfProviders
    }

    /**
     * Returns a list of filtered provider details
     * @param filter what to filter
     * */
    fun getFilteredProviders(filter: String): List<ProviderDetails> {
        val providers = Security.getProviders()
        val listOfProviders = mutableListOf<ProviderDetails>()

        // iterate over providers and create provider details from it
        providers.forEach {
            provider ->
            val providerDetails = provider.entries.filter {
                // check if the ke has the filter and ignore case
                it ->
                it.key.toString().contains(filter, true)
            }.map {
                ProviderDetails(provider.name, it.key.toString())
            }
            listOfProviders += providerDetails
        }

        return listOfProviders
    }

    /**
     * Returns a list of filtered provider details using flatMap
     * @param filter what to filter
     * */
    fun getFilteredProvidersEx(filter: String): List<ProviderDetails> {
        val providers = Security.getProviders()

        // iterate over providers and create provider details from it
        return providers.flatMap {
            provider ->
            provider.entries.filter {
                // check if the ke has the filter and ignore case
                it ->
                it.key.toString().contains(filter, true)
            }.map {
                ProviderDetails(provider.name, it.key.toString())
            }
        }

    }

    // this allows calling this function without creating an instance of Providers class
    companion object {
        fun getProviders(): List<Provider> {
            val providers = Security.getProviders()
            val listOfProviders: List<Provider> = providers.asList()
            return listOfProviders
        }
    }
}
