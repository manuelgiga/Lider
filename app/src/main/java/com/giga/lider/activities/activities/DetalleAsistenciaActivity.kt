package com.giga.lider.activities.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.giga.lider.activities.adapters.DetalleAsistenciaAdapter
import com.giga.lider.activities.providers.AssistanceProvider
import com.giga.lider.databinding.ActivityAsistenciasBinding

class DetalleAsistenciaActivity : AppCompatActivity(), DetalleAsistenciaAdapter.OnItemClickListener {

    private lateinit var binding : ActivityAsistenciasBinding
    private var assistanceProvider = AssistanceProvider()
    private val listaFechas = mutableListOf<String>()
    private val listaInicioJornada = mutableListOf<String>()
    private val listaInicioAlmuerzo = mutableListOf<String>()
    private val listaFinAlmuerzo = mutableListOf<String>()
    private val listaFinJornada = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAsistenciasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idUser = intent.getStringExtra("idUser")?:""
        Log.d("pruebatui", "el id del user es: $idUser")

        assistanceProvider.obtenerAsistencias(idUser).addOnSuccessListener {
            for (document in it.documents){
                val data = document.data


                val fecha          = data?.get("fecha")
                val inicioJornada  = data?.get("inicioJornada")
                val inicioAlmuerzo = data?.get("inicioAlmuerzo")
                val finAlmuerzo    = data?.get("finAlmuerzo")
                val finJornada     = data?.get("finJornada")

                listaFechas.add(fecha as String)

                listaInicioJornada.add(inicioJornada as String)
                listaInicioAlmuerzo.add(inicioAlmuerzo as String)
                listaFinAlmuerzo.add(finAlmuerzo as String)
                listaFinJornada.add(finJornada as String)

                Log.d("tuitui", "$data")
            }
            val recyclerview = binding.rvAsistencias
            recyclerview.layoutManager = LinearLayoutManager( this)
            recyclerview.adapter = DetalleAsistenciaAdapter(listaFechas, this)
        }
    }

    override fun onItemClick(position: Int) {
        val i = Intent(this@DetalleAsistenciaActivity, JornadaActivity::class.java)
        i.putExtra("fecha", listaFechas[position])
        i.putExtra("inicioJornada", listaInicioJornada[position])
        i.putExtra("inicioAlmuerzo", listaInicioAlmuerzo[position])
        i.putExtra("finAlmuerzo", listaFinAlmuerzo[position])
        i.putExtra("finJornada", listaFinJornada[position])
        startActivity(i)
    }





}