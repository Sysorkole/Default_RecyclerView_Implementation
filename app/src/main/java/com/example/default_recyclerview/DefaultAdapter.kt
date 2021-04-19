package com.example.default_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Responsavel pelo gerenciamento da lista em si(RecyclerView).
class DefaultAdapter : RecyclerView.Adapter<DefaultAdapterViewHolder>() {

    private val list: MutableList<Default> = mutableListOf()

    // Cria cada item visual na tela.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefaultAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.default_item,parent,false)
        return DefaultAdapterViewHolder(view)
    }

    // Tratamento dado a cada elemento do RecyclerView.
    override fun onBindViewHolder(holder: DefaultAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size  // Retorna o número de itens da lista

    fun updateList(list: List<Default>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun addItem(default: Default){
        this.list.add(default)
        notifyDataSetChanged()
    }
}

// É responsavel pelo gerenciamento de cada item.
class DefaultAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    private val tvName: TextView = itemView.findViewById(R.id.tv_dado1)
    private val tvPhone: TextView = itemView.findViewById(R.id.tv_dado2)
    private val ivPhoto: ImageView = itemView.findViewById(R.id.iv_dado3)

    fun bind(default: Default){
        tvName.text = default.dado1
        tvPhone.text = default.dado2
    }
}