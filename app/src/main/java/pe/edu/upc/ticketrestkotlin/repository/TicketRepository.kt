package pe.edu.upc.ticketrestkotlin.repository

import pe.edu.upc.ticketrestkotlin.models.Ticket
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TicketRepository{
    @GET("Ticket")
    fun getAllTickets() : Call<List<Ticket>>
    @GET("Ticket/{id}")
    fun getTicket(@Path("id") ticketId : String) : Call<Ticket>
    @POST("Ticket")
    fun postTicket(@Body ticket : Ticket) : Call<Ticket>
}