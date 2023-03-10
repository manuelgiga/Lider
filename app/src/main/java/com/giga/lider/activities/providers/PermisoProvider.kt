package com.giga.lider.activities.providers

import com.giga.lider.activities.models.Permiso
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class PermisoProvider {

    val db = Firebase.firestore
    val collectionReference = db.collection("Permisos")

    fun getPermisosParaJefe(idJefe: String): Task<QuerySnapshot>{
        return collectionReference.whereEqualTo("idJefe", idJefe).get()
    }

    fun actualizarPermiso(idCreado: String, permiso: Permiso): Task<Void>{
        return collectionReference.document(idCreado).set(permiso)
    }




}