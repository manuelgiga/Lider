package com.giga.lider.activities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.giga.lider.R
import com.giga.lider.activities.models.Asistencia

class DetalleAsistenciaAdapter(private val list: List<String>, private val listener: OnItemClickListener):RecyclerView.Adapter<DetalleAsistenciaAdapter.MyHolder>() {


    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val fecha = itemView.findViewById<TextView>(R.id.txtFecha)
        val boton = itemView.findViewById<LinearLayout>(R.id.idBoton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_detalle_asistencia, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.fecha.text = list[position]

        holder.boton.setOnClickListener {
            listener.onItemClick(position)
        }


    }

    override fun getItemCount(): Int = list.size


}