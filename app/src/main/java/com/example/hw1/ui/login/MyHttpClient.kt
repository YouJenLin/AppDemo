package com.example.hw1.ui.login
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response

class MyHttpClient1{
    private val mediaType = "application/json".toMediaType()
    private val httpClient by lazy {
        OkHttpClient.Builder().build()
    }

    fun httpGet(url: String): Response {
        val request = Request.Builder().url(url).get().build()
        return httpClient.newCall(request).execute()
    }

    fun httpPost(url: String, requestBody: String): Response {
        val request = Request.Builder()
            .url(url)
            .post(requestBody.toRequestBody(mediaType))
            .build()

        return httpClient.newCall(request).execute()
    }

    fun httpPut(url: String, requestBody: String): Response {
        val request = Request.Builder()
            .url(url)
            .put(requestBody.toRequestBody(mediaType))
            .build()

        return httpClient.newCall(request).execute()
    }

    fun httpPatch(url: String, requestBody: String): Response {
        val request = Request.Builder()
            .url(url)
            .patch(requestBody.toRequestBody(mediaType))
            .build()

        return httpClient.newCall(request).execute()
    }
}