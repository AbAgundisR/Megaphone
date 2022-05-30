package com.example.megaphone

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.material.navigation.NavigationView
import java.util.*


class MainActivity : AppCompatActivity() {
    val sRed: String = ""
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView
    lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.my_drawer_layout)
        navigationView = findViewById(R.id.navigation)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            val id = menuItem.itemId
            drawerLayout.closeDrawer(GravityCompat.START)
            when (id) {
                R.id.btnMenuFacebook -> {
                    startActivity(Intent(this, FacebookActivity::class.java))
                    true
                }
                R.id.btnMenuTwitter -> {
                    startActivity(Intent(this, TwitterActivity::class.java))
                    true
                }
                R.id.btnMenuInstagram -> {
                    startActivity(Intent(this, InstagramActivity::class.java))
                    true
                }
                else -> {
                    false
                }
            }
        }

        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                print("Success")
                val accessToken = AccessToken.getCurrentAccessToken()
                val isLoggedIn = accessToken != null && !accessToken.isExpired
            }

            override fun onCancel() {
                print("Cancel")
            }

            override fun onError(exception: FacebookException) {
                print("Success")
            }
        })

        val loginbutton = findViewById<Button>(R.id.login_button)
        val context = this
        loginbutton.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                LoginManager.getInstance().logInWithReadPermissions(context, Arrays.asList("public_profile", "user_friends"))
            }
        })
        // start your next activity
        //startActivity(Intent(this, LoginActivity::class.java))
    }
}