package com.giga.lider.activities.providers

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AssistanceProvider {
    val db = Firebase.firestore
    val collectionReference = db.collection("Asistencias")

    fun obtenerAsistencias(id: String):Task<QuerySnapshot>{
        return collectionReference.whereEqualTo("id", id)
            .orderBy("timestamp", Query.Direction.DESCENDING)
            .get()
    }



}