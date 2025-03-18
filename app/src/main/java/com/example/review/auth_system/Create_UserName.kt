package com.example.review.auth_system

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.review.R
import androidx.appcompat.app.AppCompatActivity
import com.example.review.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Create_UserName: AppCompatActivity() {

    private lateinit var db: FirebaseFirestore
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_username)

        db = FirebaseFirestore.getInstance()
        auth = FirebaseAuth.getInstance()

        val btn_continue = findViewById<Button>(R.id.btn_to_main)

        btn_continue.setOnClickListener {
            val username = findViewById<EditText>(R.id.input_username).text.toString()

            val updates = hashMapOf<String, Any>("username" to username)

            val user_id = auth.currentUser?.uid

            db.collection("users").document("${user_id}").update(updates).addOnFailureListener {
                    e -> Toast.makeText(this, "${e.message}", Toast.LENGTH_SHORT).show()
            }

            val intent = Intent(this, MainActivity::class.java)

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            finish()
        }
    }
}