package com.example.agendav4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agendav4.databinding.ActivityEditarContatoBinding

class EditarContatoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditarContatoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditarContatoBinding.inflate(layoutInflater)

        val indiceContato = intent.getIntExtra("indiceContato",-1)
        val nome : String = Agenda.listaContatos[indiceContato].nome
        val telefone: String = Agenda.listaContatos[indiceContato].telefone

        binding.agendaTxtNome.setText(nome)
        binding.agendaTxtTelefone.setText(telefone)

        binding.btSalvarContato.setOnClickListener {
            Agenda.listaContatos[indiceContato].nome = binding.agendaTxtNome.text.toString()
            Agenda.listaContatos[indiceContato].telefone = binding.agendaTxtTelefone.text.toString()
            Toast.makeText(this,"Contato salvo com sucesso!",Toast.LENGTH_SHORT).show()
            finish()
        }
        binding.btDeletarContato.setOnClickListener {
            Agenda.listaContatos.removeAt(indiceContato)
            Toast.makeText(this,"Contato deletado!",Toast.LENGTH_SHORT).show()
            finish()
        }

        setContentView(binding.root)
    }
}