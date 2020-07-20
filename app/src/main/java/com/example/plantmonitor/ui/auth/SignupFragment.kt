package com.example.plantmonitor.ui.auth


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.plantmonitor.R
import com.example.plantmonitor.databinding.FragmentSignupBinding

class SignupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSignupBinding>(
            inflater,
            R.layout.fragment_signup, container, false
        )

        binding.textViewLogin.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }

        return binding.root
    }

/*
    override fun onStarted() {
        //progressbar.visibility = View.VISIBLE
        Intent(this, DashboardActivity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }

    override fun onSuccess() {
        //progressbar.visibility = View.GONE
        startDashboardActivity()
    }

    override fun onFailure(message: String) {
        //progressbar.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
*/

}