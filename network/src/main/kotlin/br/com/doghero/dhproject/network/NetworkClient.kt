package br.com.doghero.dhproject.network

import com.google.gson.Gson
import br.com.doghero.dhproject.network.ui.UiStateLiveDataCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {

    fun <T> getApi(service: Class<T>) =
        buildRetrofit(buildOkhttpClient())
            .create(service)

    private fun buildRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(UiStateLiveDataCallAdapterFactory())
            .build()

    private fun buildOkhttpClient() =
        OkHttpClient.Builder()
            .addInterceptor(getHttpLoggingInterceptor())
            .build()

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
}
