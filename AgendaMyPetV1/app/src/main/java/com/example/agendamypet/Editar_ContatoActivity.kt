package com.example.agendamypet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agendamypet.databinding.ActivityEditarContatoBinding
import layout.Agenda

class Editar_ContatoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditarContatoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditarContatoBinding.inflate(layoutInflater)

        setTitle("Editar Contatos")

        val indiceContato = intent.getIntExtra("indiceContato",-1)
        val nome: String = Agenda.listaContatos[indiceContato].nome
        val telefone: String = Agenda.listaContatos[indiceContato].telefone
        binding.agendaTxtNome.setText(nome)
        binding.agendaTxtTelefone.setText(telefone)

        binding.btSalvarAgenda.setOnClickListener {
            Agenda.listaContatos[indiceContato].nome = binding.agendaTxtNome.text.toString()
            Agenda.listaContatos[indiceContato].telefone = binding.agendaTxtTelefone.text.toString()
            Toast.makeText(this, "Contato Salvo!",Toast.LENGTH_SHORT).show()
            finish()

        }
        setContentView(binding.root)
    }
}