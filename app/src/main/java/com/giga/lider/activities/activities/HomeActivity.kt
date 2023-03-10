package com.giga.lider.activities.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.giga.lider.R
import com.giga.lider.activities.adapters.FuncionesAdapter
import com.giga.lider.activities.models.Funcion
import com.giga.lider.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), FuncionesAdapter.OnItemClickListener {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val funciones = listOf(
            Funcion(R.drawable.employees, "Asistencias empleados"),
            Funcion(R.drawable.permiso, "Permisos empleados")
        )

        val recyclerView = binding.rvOpciones
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FuncionesAdapter(funciones, this)
    }

    override fun onItemClick(position: Int) {
        when(position){
            0 ->{
                   val intent = Intent(this@HomeActivity, AsistenciasActivity::class.java)
                   startActivity(intent)
                }
            1 ->{
                  val intent = Intent(this@HomeActivity, PermisosActivity::class.java)
                   startActivity(intent)

                }

        }

    }
}