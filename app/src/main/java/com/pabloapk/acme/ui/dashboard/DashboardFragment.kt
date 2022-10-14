package com.pabloapk.acme.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pabloapk.acme.IsucorpApplication
import com.pabloapk.acme.databinding.FragmentDashboardBinding
import java.util.*


class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private lateinit var dashboardAdapter: DashboardAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val dashboardViewModel: DashboardViewModel by viewModels {
            DashboardViewModel.DashboardViewModelFactory(
                (requireActivity().application as IsucorpApplication).repository)
        }
        dashboardViewModel.getObservableTickets()!!.observe(viewLifecycleOwner) { tickets ->
            if (tickets != null) {
                dashboardAdapter = DashboardAdapter(listener, tickets)
                binding.rvTickets.adapter = dashboardAdapter
            }
        }

        binding.tvSync!!.setOnClickListener {
            val cal: Calendar = Calendar.getInstance()
            val intent = Intent(Intent.ACTION_EDIT)
            intent.type = "vnd.android.cursor.item/event"
            intent.putExtra("beginTime", cal.timeInMillis)
            intent.putExtra("allDay", true)
            intent.putExtra("rrule", "FREQ=YEARLY")
            intent.putExtra("endTime", cal.timeInMillis + 60 * 60 * 1000)
            intent.putExtra("title", "Sync calendar in my app")
            startActivity(intent)
        }
    }

    private val listener = DashboardAdapter.OnClickListener { ticket ->
        findNavController().navigate(
            DashboardFragmentDirections.actionDashboardFragmentToDetailFragment(ticket)
        )
    }


}