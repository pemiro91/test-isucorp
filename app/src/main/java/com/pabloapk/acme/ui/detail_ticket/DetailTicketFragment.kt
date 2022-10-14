package com.pabloapk.acme.ui.detail_ticket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.pabloapk.acme.R
import com.pabloapk.acme.data.model.TicketEntity
import com.pabloapk.acme.databinding.FragmentDetailTicketBinding
import com.pabloapk.acme.ui.dashboard.DashboardFragmentDirections

class DetailTicketFragment : Fragment() {
    private var _binding: FragmentDetailTicketBinding? = null
    private val binding get() = _binding!!

    private val detailTicket: DetailTicketFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = FragmentDetailTicketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ticket: TicketEntity = detailTicket.ticketDataArgs

        binding.tvCustomerInfo!!.text = ticket.customerInfo
        binding.tvPhone!!.text = ticket.phone
        binding.tvAddressStreetTicket!!.text = ticket.street
        binding.tvAddressCityTicket!!.text = ticket.city
        binding.tvAddressCodeTicket!!.text = ticket.code
        val strApproxTicket = getString(R.string.approx) + " " + ticket.distance
        binding.tvTimeDistance!!.text = strApproxTicket
        val strMilesTicket = ticket.miles + " " + getString(R.string.miles)
        binding.tvMiles!!.text = strMilesTicket
        binding.tvScheduledFor!!.text = ticket.scheduled
        binding.tvNote!!.text = ticket.dispatch_note1
        binding.tvNote2!!.text = ticket.dispatch_note2
        binding.tvDeptClass!!.text = ticket.dept_class
        binding.tvServiceCall!!.text = ticket.service_type

        val strNumberTicket = getString(R.string.ticket) + ticket.number
        binding.tvTicket!!.text = strNumberTicket

        binding.btnGetDirection?.setOnClickListener {

            findNavController().navigate(
                DetailTicketFragmentDirections.actionDetailFragmentToMapFragment(ticket)
            )
        }

        binding.backDashboard?.setOnClickListener {
            requireView().findNavController()
                .navigate(R.id.action_detailFragment_to_dashboardFragment)
        }
    }
}