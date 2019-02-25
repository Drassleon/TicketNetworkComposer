package pe.edu.upc.ticketrestkotlin.repository

import pe.edu.upc.ticketrestkotlin.models.Client
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ClientRepository{
    @GET("Client/{id}")
    fun getClientData(@Path("id") clientId: String): Call<Client>

    @GET("Client")
    fun getClientList(): Call<List<Client>>

    @POST("Client")
    fun postClient(@Body client : Client) : Call<Client>
}