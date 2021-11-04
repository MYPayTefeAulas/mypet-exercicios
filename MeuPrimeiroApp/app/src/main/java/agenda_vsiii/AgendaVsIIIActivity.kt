package agenda_vsiii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.meuprimeiroapp.R
import com.example.meuprimeiroapp.databinding.ActivityAdicionarBinding
import com.example.meuprimeiroapp.databinding.ActivityAgendaVsIiiactivityBinding

class AgendaVsIIIActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgendaVsIiiactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendaVsIiiactivityBinding.inflate(layoutInflater)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.btAdicionarAgendaIII, ListaContatosMelhoradaFragment())
            .commit()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> {
                    loadFragments(ListaContatosMelhoradaFragment(), FRAGMENT_HOME)
                    true
                }
                R.id.ic_ajustes ->{
                    loadFragments(AjustesFragment(), FRAGMENT_AJUSTES)
                    true
                }
                else -> false
            }
        }

        binding.btAdicionar.setOnClickListener(){
            val intent = Intent(this, AdicionarActivity::class.java)
            startActivity(intent)
        }
        setContentView(binding.root)
    }

    private fun loadFragments(fragment: Fragment, tag: String){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.btAdicionarAgendaIII, fragment, tag)
            commit()
        }
    }

    companion object {
        private const val FRAGMENT_HOME = "FRAGMENT_HOME"
        private const val FRAGMENT_AJUSTES = "FRAGMENT_AJUSTES"
    }
}