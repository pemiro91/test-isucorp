package com.pabloapk.acme.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pabloapk.acme.data.model.TicketEntity
import com.pabloapk.acme.databinding.ItemTicketBinding


class DashboardAdapter(
    private val onClickListener: OnClickListener,
    private var ticketsList: MutableList<TicketEntity>) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemTicketBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTicketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(ticketsList[position]){
                binding.tvTitleTicket.text = this.service
                binding.tvAddressStreetTicket.text = this.street
                binding.tvAddressCityTicket.text = this.city
                binding.tvAddressCodeTicket.text = this.code
                binding.tvHour.text = this.hour
                binding.tvDate.text = this.date
                val strTicket = "Ticket #${this.number}"
                binding.tvTicketNumber.text = strTicket
                binding.btnViewTicket.setOnClickListener {
                    onClickListener.onClick(this)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return ticketsList.size
    }

    class OnClickListener(val clickListener: (ticket: TicketEntity) -> Unit) {
        fun onClick(ticket: TicketEntity) = clickListener(ticket)
    }
}