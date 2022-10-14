package com.pabloapk.acme.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.pabloapk.acme.IsucorpApplication
import com.pabloapk.acme.R
import com.pabloapk.acme.databinding.FragmentLoginBinding
import com.pabloapk.acme.utils.Status

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val TAG = "LoginFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginViewModel: LoginViewModel by viewModels {
            LoginViewModel.LoginViewModelFactory(
                (requireActivity().application as IsucorpApplication).repository)
        }

        binding.btnLogin.setOnClickListener {
            apply {
                setUpViewModel(loginViewModel)
            }
        }
    }

    private fun setUpViewModel(loginViewModel: LoginViewModel) {
        loginViewModel.getUserLoginDataStatus(
            binding.etUser.text.toString(),
            binding.etPass.text.toString()
        )

        loginViewModel.getUserLoginDataStatus.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    Log.d(TAG, "it.messageSuccess = ${it.message}")
                    Log.d(TAG, "it.data = ${it.data}")
                    if (it.data != null) {
                        requireView().findNavController()
                            .navigate(R.id.action_loginFragment_to_dashboardFragment)
                    } else {
                        Snackbar.make(
                            binding.root,
                            "User does not exist in database.",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                }
                Status.ERROR -> {
                    Log.d(TAG, "it.message = ${it.message}")
                    Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                }

                else -> {

                }
            }
        }

    }
}