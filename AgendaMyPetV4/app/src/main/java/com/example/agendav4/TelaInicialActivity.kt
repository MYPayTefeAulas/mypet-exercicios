package com.example.agendav4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendav4.databinding.ActivityTelaInicialBinding

class TelaInicialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTelaInicialBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaInicialBinding.inflate(layoutInflater)

        inicilizaLista()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer,ListaContatosFragment())
            .commit()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.ic_home ->{
                    loadFragments(ListaContatosFragment(), FRAGMENT_HOME)
                    true
                }
                R.id.ic_ajustes ->{
                    loadFragments(AjustesFragment(), FRAGMENT_AJUSTES)
                    true
                }
                else ->
                    false
            }
        }

        setContentView(binding.root)
    }
    private fun loadFragments(fragment: Fragment, tag: String){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer,fragment,tag)
            commit()
        }
    }
    companion object {
        private const val FRAGMENT_HOME = "FRAGMENT_HOME"
        private const val FRAGMENT_AJUSTES = "FRAGMENT_AJUSTES"
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