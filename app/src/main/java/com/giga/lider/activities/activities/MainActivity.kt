package com.giga.lider.activities.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.giga.lider.activities.providers.AuthProvider
import com.giga.lider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    val authProvider = AuthProvider()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.btLogin.setOnClickListener {
            login()
        }



    }

    private fun login() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        if (validar(email, password)){

            authProvider.login(email, password).addOnCompleteListener {
                if (it.isSuccessful){
                   try {
                       Log.d("prueba", "esta parte se hace correctamente")
                       goToHome()
                   }catch (e:Exception){
                       Log.d("prueba", "el error es: $e")
                       Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
                   }
                }
            }


        }else{
            Toast.makeText(this, "Por favor rellene todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToHome() {
        val i = Intent(this@MainActivity, HomeActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(i)
    }

    private fun validar(email: String, password: String): Boolean {
         if (email.isEmpty() || password.isEmpty()){
             return false
         }
        return true
    }

    override fun onStart() {
        super.onStart()
        if (authProvider.existSession()){
            goToHome()
        }

    }
}