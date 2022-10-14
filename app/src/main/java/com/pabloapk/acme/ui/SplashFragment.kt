package com.pabloapk.acme.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.pabloapk.acme.data.local.ActionsInsertUtils
import com.pabloapk.acme.data.local.IsucorpDatabase
import com.pabloapk.acme.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            val actionsInsertUtils = ActionsInsertUtils()
            IsucorpDatabase.getInstance(context = requireContext())
                .userDatabaseDao.insertAll(actionsInsertUtils.getUserItems())
            IsucorpDatabase.getInstance(context = requireContext())
                .ticketDatabaseDao.insertAll(actionsInsertUtils.getTicketItems())
            delay(2500)
            findNavController().navigate(
                SplashFragmentDirections.actionSplashFragmentToLoginFragment()
            )
        }
    }
}