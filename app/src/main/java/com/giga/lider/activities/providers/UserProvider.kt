package com.giga.lider.activities.providers

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class UserProvider {
    val db = Firebase.firestore
    val collectionReference = db.collection("Clients")


    fun obtenerEmpleados(idJefe:String): Task<QuerySnapshot> {
        return collectionReference.whereEqualTo("jefeDirecto", idJefe).get()
    }





}