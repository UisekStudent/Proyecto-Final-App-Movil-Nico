package com.example.turnosmedicosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.turnosmedicosapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        val turnosList = mutableListOf<Turno>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAgregar.setOnClickListener {
            val paciente = binding.etPaciente.text.toString()
            val medico = binding.etMedico.text.toString()
            val horario = binding.etHorario.text.toString()

            if (paciente.isNotEmpty() && medico.isNotEmpty() && horario.isNotEmpty()) {
                turnosList.add(Turno(paciente, medico, horario))
                limpiarCampos()
            }
        }

        binding.btnVerLista.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
    }

    private fun limpiarCampos() {
        binding.etPaciente.text.clear()
        binding.etMedico.text.clear()
        binding.etHorario.text.clear()
    }
}