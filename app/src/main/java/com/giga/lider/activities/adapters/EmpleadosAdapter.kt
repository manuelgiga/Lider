package com.giga.lider.activities.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.giga.lider.R
import com.giga.lider.activities.models.Empleado


class EmpleadosAdapter(private val list: List<Empleado>, private val listener:OnItemClickListener):RecyclerView.Adapter<EmpleadosAdapter.ViewHolder>(){

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val nombreEmpleado = itemView.findViewById<TextView>(R.id.txtPrueba)
        val boton = itemView.findViewById<LinearLayout>(R.id.botonUser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_asistencias, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val nombre = list[position].nombreEmpleado

        holder.nombreEmpleado.text = nombre

        holder.boton.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}