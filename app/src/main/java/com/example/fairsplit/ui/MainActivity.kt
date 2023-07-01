package com.example.fairsplit.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fairsplit.R
import com.example.fairsplit.databinding.ActivityMainBinding
import com.example.fairsplit.ui.login.LoginActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var googleClient: GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("77240101508-ovvgrmu6h93bujqies02s0lur7rl9210.apps.googleusercontent.com")
            .requestEmail().build()
        googleClient = GoogleSignIn.getClient(this, gso)
        binding.logoutButton.setOnClickListener {
            firebaseAuth.signOut()
            googleClient.signOut().addOnCompleteListener {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }

        binding.tvEmail.text = intent.getStringExtra("email_id")
        binding.tvName.text = intent.getStringExtra("name")
    }
}