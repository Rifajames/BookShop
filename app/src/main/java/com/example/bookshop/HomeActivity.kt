package com.example.bookshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bookshop.databinding.ActivityHomeBinding
import com.example.bookshop.databinding.ActivityLoginBinding
import com.example.bookshop.fragment.HomeFragment
import com.example.bookshop.fragment.ProfileFragment
import com.example.bookshop.fragment.ShopFragment
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val homeFragment = HomeFragment()
        val profileFragment = ProfileFragment()
        val shopFragment = ShopFragment()

        makeCurrentFragment(homeFragment)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> makeCurrentFragment(homeFragment)
                R.id.nav_shop -> makeCurrentFragment(shopFragment)
                R.id.nav_profile -> makeCurrentFragment(profileFragment)
            }
            true
        }

//        binding.btnLogout.setOnClickListener{
//            auth.signOut()
//            Intent(this@HomeActivity, LoginActivity::class.java).also {
//                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                startActivity(it)
//            }
//        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }
    }
}