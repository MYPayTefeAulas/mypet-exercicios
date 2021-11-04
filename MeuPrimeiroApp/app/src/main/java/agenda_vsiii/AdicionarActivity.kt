package agenda_vsiii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.meuprimeiroapp.R
import com.example.meuprimeiroapp.databinding.ActivityAdicionarBinding

class AdicionarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdicionarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdicionarBinding.inflate(layoutInflater)
        setTitle(getString(R.string.adicionar))

        binding.btSalvarAdicionar.setOnClickListener() {
            val nome = binding.txtEntradaNomeAdicionar.text.toString()
            val telefone = binding.txtEntradaTelefoneAdicionar.text.toString()
            val pessoaAdicionar = ContatosIII(nome, telefone)

            if (checaNomeVazio(pessoaAdicionar) && (checaTelefoneVazio(pessoaAdicionar))) {
                Toast.makeText(this, getString(R.string.erro_nome_telefone_vazio), Toast.LENGTH_SHORT).show()
            } else if (checaNomeVazio(pessoaAdicionar)) {
                Toast.makeText(this, getString(R.string.erro_nome_vazio), Toast.LENGTH_SHORT).show()
            } else if (checaTelefoneVazio(pessoaAdicionar)) {
                Toast.makeText(this, getString(R.string.erro_telefone_vazio), Toast.LENGTH_SHORT).show()
            } else if (checaRepetido(pessoaAdicionar)){
                Toast.makeText(this, getString(R.string.contato_repetido), Toast.LENGTH_SHORT).show()
            } else {
                AgendaIII.listaContatos.add(pessoaAdicionar)
                Toast.makeText(this, R.string.contato_salvo_sucesso, Toast.LENGTH_SHORT).show()
                finish()
            }
        }
        setContentView(binding.root)
    }

    fun checaNomeVazio(contato: ContatosIII): Boolean {
        return contato.nome == ""
    }

    fun checaTelefoneVazio(contato: ContatosIII): Boolean {
        return contato.telefone == ""
    }

    fun checaRepetido(contato: ContatosIII): Boolean {
        var resultado = false

        for (lista in AgendaIII.listaContatos) {
            if (lista.telefone == contato.telefone) {
                resultado = true
                break
            }
        }
        return resultado
    }
}