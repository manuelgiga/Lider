package com.giga.lider.activities.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.giga.lider.activities.adapters.EmpleadosAdapter
import com.giga.lider.activities.models.Empleado
import com.giga.lider.activities.providers.AuthProvider
import com.giga.lider.activities.providers.UserProvider
import com.giga.lider.databinding.ActivityAsistenciasBinding


class AsistenciasActivity : AppCompatActivity(), EmpleadosAdapter.OnItemClickListener {
    private lateinit var binding : ActivityAsistenciasBinding
    private var listaUsers = mutableListOf<Empleado>()
    private var listaIdUsers = mutableListOf<String>()
    private var userProvider = UserProvider()
    private val auth = AuthProvider()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAsistenciasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idPropio = auth.getId()

        userProvider.obtenerEmpleados(idPropio).addOnSuccessListener {
            for (document in it.documents){
                val data = document.data
                val nombre = data?.get("nombre")
                val apellido = data?.get("apellido")
                val idUser = data?.get("id")
                val nombreCompleto = "$nombre $apellido"

                Log.d("pruebatui", "la data es: $data")

                listaUsers.add(Empleado("", nombreCompleto))
                listaIdUsers.add(idUser as String)
            }
            val recyclerView = binding.rvAsistencias
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = EmpleadosAdapter(listaUsers, this)
        }
    }

    override fun onItemClick(position: Int) {
        val idUser = listaIdUsers[position]
        Log.d("pruebatui", "el id del user seria: $idUser")
        val i = Intent(this@AsistenciasActivity, DetalleAsistenciaActivity::class.java)
        i.putExtra("idUser", idUser)
        this.startActivity(i)
    }


}