package com.example.marvelclient.network

import com.example.marvelclient.utils.Utils
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*


class NetworkInterceptor : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val PRIVATE_KEY = "f3d32a46490f42e7e5f716edd7a06bc5fcb45ef1"
        val API_KEY = "9b8c1987a0633ffd00b9b10f84daaf5c"
        val timeStamp = Date().time.toString()
        val hash = Utils().md5(timeStamp + PRIVATE_KEY + API_KEY)
        val request= chain.request()
        val _url = request.url.newBuilder()
            .addQueryParameter("ts",timeStamp)
            .addQueryParameter("apikey",API_KEY)
            .addQueryParameter("hash", hash).build()
        return chain.proceed(request.newBuilder().url(_url).build())


    }
}