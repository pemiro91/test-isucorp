package com.pabloapk.acme.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pabloapk.acme.data.model.TicketEntity
import com.pabloapk.acme.data.repository.IsucorpRepository
import com.pabloapk.acme.ui.login.LoginViewModel

class DashboardViewModel (private val isucorpRepository: IsucorpRepository) : ViewModel() {

    private var mObservableTickets: LiveData<MutableList<TicketEntity>>? = null

    // LiveData => all users
    private fun getTicketByLiveData() {
        mObservableTickets = isucorpRepository.getAllByTicketsData()
    }

    // LiveData => users
    fun getObservableTickets(): LiveData<MutableList<TicketEntity>>? {
        if (mObservableTickets != null) {
            Log.v("","observableTickets: ${mObservableTickets.toString()}")
        } else {
            getTicketByLiveData()
        }
        return mObservableTickets
    }

    class DashboardViewModelFactory(private val dashboardRepository: IsucorpRepository)
        : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DashboardViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return DashboardViewModel(dashboardRepository) as T
            }
            throw IllegalArgumentException("Unknown VieModel Class")
        }
    }
}