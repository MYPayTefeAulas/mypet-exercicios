package com.example.agendav3

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendav3.databinding.ActivityTelaInicialBinding

class TelaInicialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTelaInicialBinding
    private lateinit var adapter: ContatoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTitle("Agenda V3")

        binding = ActivityTelaInicialBinding.inflate(layoutInflater)

        adapter = ContatoAdapter(mutableListOf(),::onBtEditarClick)

        binding.rvContatos.layoutManager = LinearLayoutManager(this)
        binding.rvContatos.adapter = adapter
        binding.rvContatos.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))

        inicilizaLista()

        adapter.swapData(Agenda.listaContatos)

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

    fun onBtEditarClick(indiceLista: Int){
        val intent = Intent(this,EditarContatoActivity::class.java)
        intent.putExtra("indiceContato",indiceLista)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        adapter.swapData(Agenda.listaContatos)
    }


}