package layout

data class Contatos (var nome: String, var telefone: String){

    override fun toString(): String{
        return "$nome ($telefone)"
    }
}