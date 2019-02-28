package pe.edu.upc.ticketrestkotlin.repository

import pe.edu.upc.ticketrestkotlin.models.TicketShop
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TicketShopRepository{

    @GET("TicketShop")
    fun getAllTicketShops() : Call<List<TicketShop>>

    @GET("TicketShop/{id}")
    fun getTicketShop(@Path("id") ticketShopId : String) : Call<TicketShop>

    @POST("TicketShop")
    fun postShop(@Body shop : TicketShop) : Call<TicketShop>
}