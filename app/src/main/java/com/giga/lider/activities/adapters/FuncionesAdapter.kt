package com.giga.lider.activities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.giga.lider.R
import com.giga.lider.activities.models.Funcion



class FuncionesAdapter(var list: List<Funcion>, private val listener:OnItemClickListener):RecyclerView.Adapter<FuncionesAdapter.MyHolder>() {

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imagen = itemView.findViewById<ImageView>(R.id.imgFuncion)
        val funcion = itemView.findViewById<TextView>(R.id.txtFuncion)
        val boton = itemView.findViewById<LinearLayout>(R.id.boton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_funcion, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val item = list[position]
        holder.imagen.setImageResource(item.imagen)
        holder.funcion.text = item.titulo

        holder.boton.setOnClickListener {
            listener.onItemClick(position)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

}