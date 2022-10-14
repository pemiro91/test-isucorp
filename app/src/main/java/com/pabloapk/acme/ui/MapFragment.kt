package com.pabloapk.acme.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.pabloapk.acme.R
import com.pabloapk.acme.data.model.TicketEntity
import com.pabloapk.acme.databinding.FragmentMapBinding
import com.pabloapk.acme.ui.detail_ticket.DetailTicketFragmentArgs

class MapFragment : Fragment() {
    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    private val detailTicket: MapFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backTicket.setOnClickListener {
            requireView().findNavController()
                .navigate(R.id.action_mapFragment_to_detailFragment)
        }

        val ticket: TicketEntity = detailTicket.ticketDataArgs

        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl(ticket.url_google)
    }
}