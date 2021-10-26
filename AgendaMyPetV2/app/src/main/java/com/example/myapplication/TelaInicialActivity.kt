package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityTelaInicialBinding

class TelaInicialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTelaInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTitle("Agenda V2")

        binding = ActivityTelaInicialBinding.inflate(layoutInflater)

        binding.rvContatos.layoutManager = LinearLayoutManager(this)
        binding.rvContatos.adapter = ContatosAdapter(Agenda.listaContatos)
        binding.rvContatos.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))

        inicilizaLista()

        setContentView(binding.root)
    }

    private fun inicilizaLista(){
        Agenda.listaContatos.addAll(
            listOf(
                Contato("1 Sabrina","123"),
                Contato("2 Alex","456"),
                Contato("3 Jaqueline","789"),
                Contato("4 Genival","321"),
                Contato("5 Sabrina","123"),
                Contato("6 Alex","456"),
                Contato("7 Jaqueline","789"),
                Contato("8 Genival","321"),
                Contato("9 Sabrina","123"),
                Contato("10 Alex","456"),
                Contato("11 Jaqueline","789"),
                Contato("12 Genival","321"),
                Contato("13 Sabrina","123"),
                Contato("14 Alex","456"),
                Contato("15 Jaqueline","789"),
                Contato("16 Genival","321")

            )
        )
    }
}