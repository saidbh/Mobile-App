package com.example.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.app.ApiClient.RequestToClient
import com.example.app.Models.LoginResponse
import com.example.app.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Log.d("login", "login start")
        binding.LoginBtn.setOnClickListener()
        {
            val username = binding.editTextTextPersonName.text.toString().trim()
            val password = binding.passwordToggle.text.toString().trim()

            if (username.isEmpty())
            {
                Log.d("username", "username is empty")
                binding.editTextTextPersonName.error = "Username or email required !"
                binding.editTextTextPersonName.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty())
            {
                Log.d("password", "password is empty")
                binding.passwordToggle.error = "Password required !"
                binding.passwordToggle.requestFocus()
                return@setOnClickListener
            }
            RequestToClient.instance.userLogin()
                .enqueue(object: Callback<LoginResponse>{
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        println(t.message)
                        println("on failure *********************************************************************")
//                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        if(response.body()?.header?.code == 200){
                            print(response.body())
                            println("on response *********************************************************************")
//                            SharedPrefManager.getInstance(applicationContext).saveUser(response.body()?.user!!)

                            val intent = Intent(applicationContext, ProfileActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                        }else{
                            Log.d("500", "error !!! ")
                            //Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
                        }

                    }
                })

        }
    }

//    override fun onStart() {
//        super.onStart()
//
//        if(SharedPrefManager.getInstance(this).isLoggedIn){
//            val intent = Intent(applicationContext, ProfileActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//
//            startActivity(intent)
//        }
//    }
}
