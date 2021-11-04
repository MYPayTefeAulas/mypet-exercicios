package agenda_vsiii

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meuprimeiroapp.databinding.ItemContatoBinding

class ContatosAdapter(
    val listaContatos: MutableList<ContatosIII>,
    val onBtEditarClick: (Int) -> Unit

    ) : RecyclerView.Adapter<ContatosAdapter.ViewHolder>() {

        inner class ViewHolder(val binding: ItemContatoBinding): RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                ItemContatoBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ))
        }

        override fun getItemCount(): Int {
            return listaContatos.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.binding.txtNomeAgendaIII.text = listaContatos[position].nome
            holder.binding.txtTelefoneAgendaIII.text = listaContatos[position].telefone
            holder.binding.btEditarAgenda.setOnClickListener(){
                onBtEditarClick(position)
            }
        }

    fun swapData(novaListaContatos: List<ContatosIII>){
        listaContatos.clear()
        listaContatos.addAll(novaListaContatos)
        notifyDataSetChanged()
    }

}