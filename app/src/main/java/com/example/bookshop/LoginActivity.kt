package com.example.bookshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import com.example.bookshop.databinding.ActivityLoginBinding
import com.example.bookshop.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        with(binding){
            btnLogin.setOnClickListener {
                val email = binding.etEmail.text.toString().trim()
                val password = binding.etPassword.text.toString().trim()

                if(email.isEmpty()){
                    binding.etEmail.error = "Email harus diisi"
                    binding.etEmail.requestFocus()
                    return@setOnClickListener
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    binding.etEmail.error = "Email tidak valid"
                    binding.etEmail.requestFocus()
                    return@setOnClickListener
                }

                if(password.isEmpty() || password.length < 6){
                    binding.etEmail.error = "Password harus lebih dari 6 karakter"
                    binding.etEmail.requestFocus()
                    return@setOnClickListener
                }

                LoginUser(email, password)
            }

            btnRegister.setOnClickListener {
                Intent(this@LoginActivity, RegisterActivity::class.java).also {
                    startActivity(it)
                }
            }
        }

    }

    private fun LoginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
            if(it.isSuccessful){
                Intent(this@LoginActivity, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }else{
                Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if(auth.currentUser != null){
            Intent(this@LoginActivity, HomeActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}