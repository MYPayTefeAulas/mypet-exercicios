package com.example.agendav4

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendav4.databinding.FragmentListaContatosBinding

class ListaContatosFragment(): Fragment() {
    private var _binding: FragmentListaContatosBinding? = null

    private val binding get () = _binding!!

    private lateinit var adapter: ContatosAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListaContatosBinding.inflate(inflater,container,false)

        inicilizaLista()

        adapter = ContatosAdapter(mutableListOf(),::onBtEditorClick)

        binding.rvContatos.layoutManager = LinearLayoutManager(context)
        binding.rvContatos.adapter = adapter
        binding.rvContatos.addItemDecoration(
            DividerItemDecoration(context,
                LinearLayoutManager.VERTICAL)
        )

        adapter.swapData(Agenda.listaContatos)

        return binding.root
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

    fun onBtEditorClick(indiceLista : Int){
        val intent = Intent(context,EditarContatoActivity::class.java)
        intent.putExtra("indiceContato", indiceLista)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        adapter.swapData(Agenda.listaContatos)
    }
}