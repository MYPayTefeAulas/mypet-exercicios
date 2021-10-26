package com.example.agendav3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agendav3.databinding.ActivityEditarContatoBinding

class EditarContatoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditarContatoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTitle("Editar Contato")

        binding = ActivityEditarContatoBinding.inflate(layoutInflater)

        val indiceContato = intent.getIntExtra("indiceContato",-1)
        val nome: String = Agenda.listaContatos[indiceContato].nome
        val telefone: String = Agenda.listaContatos[indiceContato].telefone

        binding.agendaTxtNome.setText(nome)
        binding.agendaTxtTelefone.setText(telefone)

        binding.agendaBtSalvar.setOnClickListener {
            Agenda.listaContatos[indiceContato].nome = binding.agendaTxtNome.text.toString()
            Agenda.listaContatos[indiceContato].telefone = binding.agendaTxtTelefone.text.toString()
            Toast.makeText(this,"Contato Salvo com Sucesso!",Toast.LENGTH_SHORT).show()
            finish()
        }
        binding.agendaBtDeletar.setOnClickListener{
            Agenda.listaContatos.removeAt(indiceContato)
            Toast.makeText(this,"Contato deletado!",Toast.LENGTH_SHORT).show()
            finish()
        }
        setContentView(binding.root)
    }
}