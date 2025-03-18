package com.example.review.auth_system

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.review.R
import com.example.review.utils.AuthUtils

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        val emailInput = view.findViewById<EditText>(R.id.email_signup)
        val passwordInput = view.findViewById<EditText>(R.id.password_signup)
        val registerButton = view.findViewById<Button>(R.id.btn_autorization)

        registerButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            AuthUtils.registerUser(email, password) { success, error ->
                if (success) {
                    Toast.makeText(requireContext(), "Регистрация успешна", Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
                } else {
                    Toast.makeText(requireContext(), error ?: "Ошибка регистрации", Toast.LENGTH_LONG).show()
                }
            }
        }

        return view
    }
}
