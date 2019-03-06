package pe.edu.upc.ticketrestkotlin.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_ticket.view.*
import pe.edu.upc.ticketrestkotlin.R
import pe.edu.upc.ticketrestkotlin.adapter.TicketAdapter
import pe.edu.upc.ticketrestkotlin.models.Ticket
import pe.edu.upc.ticketrestkotlin.repository.RetrofitRepository
import pe.edu.upc.ticketrestkotlin.repository.TicketRepository
import pe.edu.upc.ticketrestkotlin.viewholders.activities.TicketFormActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

/**
 * A simple [Fragment] subclass.
 *
 */
class TicketFragment : Fragment() {

    var tickets = ArrayList<Ticket>()
    private lateinit var ticketRecyclerView: RecyclerView
    private lateinit var ticketAdapter: TicketAdapter
    private lateinit var ticketLayoutManager: RecyclerView.LayoutManager
    private lateinit var lblNoTickets : TextView
    private lateinit var btnCreateTicket : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ticket, container, false)
        var retrofit : Retrofit = RetrofitRepository().getRetrofitInstance()
        var ticketRepo : TicketRepository = retrofit.create(TicketRepository::class.java)

        ticketRecyclerView = view.rvTicket
        ticketAdapter = TicketAdapter(tickets)
        ticketLayoutManager = GridLayoutManager(view.context, 2)
        ticketRecyclerView.adapter = ticketAdapter
        ticketRecyclerView.layoutManager = ticketLayoutManager
        lblNoTickets = view.lblNoTickets
        btnCreateTicket = view.btnCreateTicket

        val clientListCall : Call<List<Ticket>> = ticketRepo.getAllTickets()

        clientListCall.enqueue(object : Callback<List<Ticket>> {
            override fun onResponse(call: Call<List<Ticket>>, response: Response<List<Ticket>>) {
                lblNoTickets.visibility = View.GONE
                tickets=response.body() as ArrayList<Ticket>
                ticketAdapter.list = tickets
                ticketAdapter.notifyDataSetChanged()
                if(tickets.isEmpty())
                {
                    lblNoTickets.visibility = View.VISIBLE
                }
            }

            override fun onFailure(call: Call<List<Ticket>>, t: Throwable) {
                lblNoTickets.visibility = View.VISIBLE
                Toast.makeText(view.context, "Unable to load Client Data", Toast.LENGTH_SHORT).show()
            }
        })
        btnCreateTicket.setOnClickListener {
            val context = it.context
            context.startActivity(Intent(context, TicketFormActivity::class.java))
        }
        return view
    }
}
