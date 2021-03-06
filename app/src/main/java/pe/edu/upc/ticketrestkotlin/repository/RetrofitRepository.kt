package pe.edu.upc.ticketrestkotlin.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRepository{

    companion object {
        private var BASE_URL : String = "http://35.193.67.153:3000/api/"
        private lateinit var retrofit : Retrofit
    }

    fun getRetrofitInstance() : Retrofit{

            retrofit = retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit
    }
}