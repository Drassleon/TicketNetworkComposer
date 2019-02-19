package pe.edu.upc.ticketrestkotlin.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_ticket_shop.view.*

import pe.edu.upc.ticketrestkotlin.R
import pe.edu.upc.ticketrestkotlin.adapter.TicketShopAdapter
import pe.edu.upc.ticketrestkotlin.models.TicketShop
import pe.edu.upc.ticketrestkotlin.repository.RetrofitRepository
import pe.edu.upc.ticketrestkotlin.repository.TicketShopRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class TicketShopFragment : Fragment() {
    var shops = ArrayList<TicketShop>()
    lateinit var ticketShopRecyclerView: RecyclerView
    lateinit var ticketShopAdapter: TicketShopAdapter
    lateinit var ticketShopLayoutManager: RecyclerView.LayoutManager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ticket_shop, container, false)
        var retrofit : Retrofit = RetrofitRepository().getRetrofitInstance()

        var ticketShopRepo : TicketShopRepository = retrofit.create(TicketShopRepository::class.java)

        ticketShopRecyclerView = view.rvShops
        ticketShopAdapter = TicketShopAdapter(shops)
        ticketShopLayoutManager = GridLayoutManager(view.context, 2)
        ticketShopRecyclerView.adapter = ticketShopAdapter
        ticketShopRecyclerView.layoutManager = ticketShopLayoutManager

        val ticketShopCall : Call<List<TicketShop>> = ticketShopRepo.getAllTicketShops()

        ticketShopCall.enqueue(object: Callback<List<TicketShop>> {
            override fun onResponse(call: Call<List<TicketShop>>, response: Response<List<TicketShop>>) {
                shops=response.body() as ArrayList<TicketShop>
                ticketShopAdapter.list=shops
                ticketShopAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<TicketShop>>, t: Throwable) {
                Toast.makeText(view.context, "Unable to load Ticket Shop Data", Toast.LENGTH_SHORT).show()
            }
        })
        return view
    }
}
