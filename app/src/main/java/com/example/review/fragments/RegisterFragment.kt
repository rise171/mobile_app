package com.example.review.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.ViewFlipper
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.example.review.R
import com.example.review.utils.AuthUtils

class RegisterFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    private lateinit var viewFlipper: ViewFlipper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.register_fragment, container, false)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()
        viewFlipper = view.findViewById(R.id.view_flipper)

        val emailInput = view.findViewById<EditText>(R.id.reg_email)
        val passwordInput = view.findViewById<EditText>(R.id.reg_password)
        val registerButton = view.findViewById<Button>(R.id.btn_reg)

        registerButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            AuthUtils.registerUser(email, password) { success, error ->
                if (success) {
                    Toast.makeText(requireContext(), "Регистрация успешна", Toast.LENGTH_LONG).show()
                    viewFlipper.showNext()  // Переключение на ввод имени пользователя
                } else {
                    Toast.makeText(requireContext(), error ?: "Ошибка регистрации", Toast.LENGTH_LONG).show()
                }
            }
        }

        val usernameInput = view.findViewById<EditText>(R.id.input_username)
        val continueButton = view.findViewById<Button>(R.id.btn_to_main)

        /*continueButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val userId = auth.currentUser?.uid

            if (userId != null) {
                val updates = hashMapOf("username" to username)

                db.collection("users").document(userId).update(updates)
                    .addOnSuccessListener {
                        findNavController().navigate()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(requireContext(), e.message ?: "Ошибка сохранения имени", Toast.LENGTH_SHORT).show()
                    }
            }
        }*/

        return view
    }
}
