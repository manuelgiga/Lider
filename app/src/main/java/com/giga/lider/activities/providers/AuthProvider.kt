package com.giga.lider.activities.providers

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class AuthProvider {

    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun login(email:String, contraseña:String):Task<AuthResult>{
        return auth.signInWithEmailAndPassword(email, contraseña)
    }

    fun existSession():Boolean{
        var exist = false
        if (auth.currentUser!=null){
            exist=true
        }
        return exist
    }

}