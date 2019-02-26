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
import kotlinx.android.synthetic.main.fragment_client.view.*
import pe.edu.upc.ticketrestkotlin.R
import pe.edu.upc.ticketrestkotlin.adapter.ClientAdapter
import pe.edu.upc.ticketrestkotlin.models.Client
import pe.edu.upc.ticketrestkotlin.repository.ClientRepository
import pe.edu.upc.ticketrestkotlin.repository.RetrofitRepository
import pe.edu.upc.ticketrestkotlin.viewholders.activities.ClientFormActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ClientFragment : Fragment() {
    var clients = ArrayList<Client>()
    private lateinit var clientRecyclerView: RecyclerView
    lateinit var clientAdapter: ClientAdapter
    private lateinit var clientLayoutManager: RecyclerView.LayoutManager
    private lateinit var tvNoClients : TextView
    private lateinit var btnCreateClient : Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_client, container, false)
        var retrofit : Retrofit = RetrofitRepository().getRetrofitInstance()

        var clientRepo : ClientRepository = retrofit.create(ClientRepository::class.java)

        tvNoClients = view.tvNoClients
        clientRecyclerView = view.rvClients
        btnCreateClient = view.btnCreateClient
        clientAdapter = ClientAdapter(clients)
        clientLayoutManager = GridLayoutManager(view.context, 2)
        clientRecyclerView.adapter = clientAdapter
        clientRecyclerView.layoutManager = clientLayoutManager

        val clientListCall : Call<List<Client>> = clientRepo.getClientList()

        clientListCall.enqueue(object : Callback<List<Client>> {
            override fun onResponse(call: Call<List<Client>>, response: Response<List<Client>>) {
                clients=response.body() as ArrayList<Client>
                clientAdapter.list = clients
                clientAdapter.notifyDataSetChanged()
                if(clients.isEmpty())
                {
                    tvNoClients.visibility = View.VISIBLE
                }
            }

            override fun onFailure(call: Call<List<Client>>, t: Throwable) {
                Toast.makeText(view.context, "Unable to load Client Data", Toast.LENGTH_SHORT).show()
            }
        })
        btnCreateClient.setOnClickListener {
            val context = it.context
            context.startActivity(Intent(context,ClientFormActivity::class.java))
        }
        return view
    }
}
