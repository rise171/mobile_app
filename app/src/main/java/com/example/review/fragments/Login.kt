package com.example.review.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.review.R
import com.example.review.utils.AuthUtils

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login_fragment, container, false)

        val emailInput = view.findViewById<EditText>(R.id.email_login)
        val passwordInput = view.findViewById<EditText>(R.id.password_login)
        val loginButton = view.findViewById<Button>(R.id.btn_login)
        val registerText = view.findViewById<TextView>(R.id.transitionText)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            AuthUtils.loginUser(email, password, requireContext()) { success, error ->
                if (success) {
                    Toast.makeText(requireContext(), "Вход выполнен", Toast.LENGTH_LONG).show()
                    //findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                } else {
                    Toast.makeText(requireContext(), error ?: "Ошибка входа", Toast.LENGTH_LONG).show()
                }
            }
        }

        registerText.setOnClickListener {
            //findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        return view
    }
}