package com.example.agendamypet

import android.content.AbstractThreadedSyncAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.agendamypet.databinding.ActivityMainBinding
import layout.Agenda
import layout.Contatos

class TelaInicialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ArrayAdapter<Contatos>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        Agenda.listaContatos.add(Contatos("Sabrina", "2021"))
        Agenda.listaContatos.add(Contatos("Genival", "2022"))
        Agenda.listaContatos.add(Contatos("Alex", "2023"))
        Agenda.listaContatos.add(Contatos("Jaqueline", "2024"))

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,Agenda.listaContatos)
        binding.lvContatos.adapter = adapter
        binding.lvContatos.setOnItemClickListener{parent,view,position,id ->
            val intent = Intent(this,Editar_ContatoActivity::class.java)
            intent.putExtra("indiceContato",position)
            startActivity(intent)

        }

        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}