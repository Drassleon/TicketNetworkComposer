package pe.edu.upc.ticketrestkotlin

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import pe.edu.upc.ticketrestkotlin.fragments.ClientFragment
import pe.edu.upc.ticketrestkotlin.fragments.TicketFragment
import pe.edu.upc.ticketrestkotlin.fragments.TicketShopFragment
import pe.edu.upc.ticketrestkotlin.fragments.TransactionFragment


class MainActivity : AppCompatActivity() {


    private val bnvFragmentsItemSelectedListener : BottomNavigationView.OnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
            item ->
        return@OnNavigationItemSelectedListener navigateTo(item)
    }

    private fun navigateTo(item: MenuItem): Boolean {
        item.isChecked = true
        return supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContent, fragmentFor(item))
            .commit() > 0
    }
    private fun fragmentFor(item: MenuItem): Fragment {
        when(item.itemId) {
            R.id.navigation_clients -> {
                return ClientFragment()
            }
            R.id.navigation_shops -> {
                return TicketShopFragment()
            }
            R.id.navigation_tickets -> {
                return TicketFragment()
            }
            R.id.navigation_transactions -> {
                return TransactionFragment()
            }
        }
        return ClientFragment()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bnvFragments.setOnNavigationItemSelectedListener(bnvFragmentsItemSelectedListener)
        bnvFragments.selectedItemId = R.id.navigation_clients
    }
}
