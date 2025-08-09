package com.example.turnosmedicosapp

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.turnosmedicosapp.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datos = MainActivity.turnosList.map {
            "Paciente: ${it.paciente}\nMédico: ${it.medico}\nHorario: ${it.horario}"
        }

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            datos
        )
        binding.listViewTurnos.adapter = adapter
    }
}