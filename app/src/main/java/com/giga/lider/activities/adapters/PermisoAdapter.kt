package com.giga.lider.activities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.giga.lider.R
import com.giga.lider.activities.models.Permiso

class PermisoAdapter(private val list: List<Permiso>, private var listener: OnItemClickListener):RecyclerView.Adapter<PermisoAdapter.MyHolder>() {

    interface OnItemClickListener{
        fun onItemClick(position: Int, opcion: Int)
    }

    class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val fecha = itemView.findViewById<TextView>(R.id.txtFecha)
        val nombre = itemView.findViewById<TextView>(R.id.txtNombre)
        val motivo = itemView.findViewById<TextView>(R.id.txtMotivo)
        val aprobado = itemView.findViewById<TextView>(R.id.txtAprobado)
        val bien = itemView.findViewById<ImageView>(R.id.bien)
        val mal = itemView.findViewById<ImageView>(R.id.mal)

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_permiso, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.fecha.text = list[position].fecha
        holder.nombre.text = list[position].empleado
        holder.motivo.text = list[position].motivo
        holder.aprobado.text = list[position].aprobado

        holder.bien.setOnClickListener {
            listener.onItemClick(position, 1)
        }

        holder.mal.setOnClickListener {
            listener.onItemClick(position, 2)
        }



    }

    override fun getItemCount(): Int {
        return list.size
    }
}