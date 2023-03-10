package com.giga.lider.activities.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.giga.lider.databinding.ActivityJornadaBinding

class JornadaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJornadaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJornadaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fecha          = intent.getStringExtra("fecha")
        val inicioJornada  = intent.getStringExtra("inicioJornada")
        val inicioAlmuerzo = intent.getStringExtra("inicioAlmuerzo")
        val finAlmuerzo    = intent.getStringExtra("finAlmuerzo")
        val finJornada     = intent.getStringExtra("finJornada")

        binding.txtFecha.text = fecha
        binding.txtij.text = "inicio jornada: $inicioJornada"
        binding.txtia.text = "inicio almuerzo: $inicioAlmuerzo"
        binding.txtfa.text = "fin almuerzo: $finAlmuerzo"
        binding.txtfj.text = "fin jornada: $finJornada"

    }
}