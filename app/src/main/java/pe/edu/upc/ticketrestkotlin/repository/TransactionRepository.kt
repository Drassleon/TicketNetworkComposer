package pe.edu.upc.ticketrestkotlin.repository

import pe.edu.upc.ticketrestkotlin.models.BuyTicket
import pe.edu.upc.ticketrestkotlin.models.RedeemTicket
import pe.edu.upc.ticketrestkotlin.models.ReturnTicket
import retrofit2.http.POST

interface TransactionRepository{

    @POST("BuyTicket")
    fun postBuyTicket(buyTicket: BuyTicket)

    @POST("RedeemTicket")
    fun postRedeemTicket(redeemTicket: RedeemTicket)

    @POST("ReturnTicket")
    fun postReturnTicket(returnTicket: ReturnTicket)
}