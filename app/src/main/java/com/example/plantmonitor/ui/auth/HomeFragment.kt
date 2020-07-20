package com.example.plantmonitor.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.plantmonitor.R
import com.example.plantmonitor.databinding.ActivityAuthBinding
import com.example.plantmonitor.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,
            R.layout.fragment_home, container, false)

        binding.btnLogin.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }

        binding.btnSignup.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_signupFragment)
        }

        return binding.root
    }

}