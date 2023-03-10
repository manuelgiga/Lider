package com.giga.lider.activities.activities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.giga.lider.activities.adapters.PermisoAdapter
import com.giga.lider.activities.models.Permiso
import com.giga.lider.activities.providers.AuthProvider
import com.giga.lider.activities.providers.PermisoProvider
import com.giga.lider.databinding.ActivityPermisosBinding


class PermisosActivity : AppCompatActivity(), PermisoAdapter.OnItemClickListener {
    private lateinit var binding : ActivityPermisosBinding
    private var permisoProvider = PermisoProvider()
    private var authProvider = AuthProvider()
    private val listaPermisos = mutableListOf<Permiso>()
    private val listaIdCreado = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPermisosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = authProvider.getId()
        permisoProvider.getPermisosParaJefe(id).addOnSuccessListener {
            for (document in it.documents){
                val data = document.data
                val fechaPermiso = data?.get("fecha")
                val aprobacion = data?.get("aprobado")
                val motivo = data?.get("motivo")
                val nombre = data?.get("empleado")
                val idUser = data?.get("idUser")
                val idJefe = data?.get("idJefe")

                val idCreado = "${data?.get("idUser")}${data?.get("idJefe")}${data?.get("fecha")}"
                listaPermisos.add(Permiso("$fechaPermiso", "$motivo", "$nombre", "$aprobacion", "$idJefe", "$idUser"))
                listaIdCreado.add(idCreado)

            }
            val recyclerView = binding.rvPermisos
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = PermisoAdapter(listaPermisos, this)
        }

    }

    override fun onItemClick(position: Int, opcion: Int) {
        when(opcion){
            1 -> {
                val fecha    = listaPermisos[position].fecha
                val motivo   = listaPermisos[position].motivo
                val empleado = listaPermisos[position].empleado
                val idJefe   = listaPermisos[position].idJefe
                val idUser   = listaPermisos[position].idUser

                val objetoNuevo = Permiso("$fecha","$motivo", "$empleado", "permiso otorgado", "$idJefe", "$idUser")
                permisoProvider.actualizarPermiso(listaIdCreado[position], objetoNuevo).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this, "Permiso otorgado", Toast.LENGTH_SHORT).show()
                        recreate()
                    }else{
                        Toast.makeText(this, "Error al otorgar permiso", Toast.LENGTH_SHORT).show()
                    }
            }

            }
            2 -> {
                val fecha    = listaPermisos[position].fecha
                val motivo   = listaPermisos[position].motivo
                val empleado = listaPermisos[position].empleado
                val idJefe   = listaPermisos[position].idJefe
                val idUser   = listaPermisos[position].idUser

                val objetoNuevo = Permiso("$fecha","$motivo", "$empleado", "permiso denegado", "$idJefe", "$idUser")
                permisoProvider.actualizarPermiso(listaIdCreado[position], objetoNuevo).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this, "Permiso denegado", Toast.LENGTH_SHORT).show()
                        recreate()
                    }else{
                        Toast.makeText(this, "Error al denegar permiso", Toast.LENGTH_SHORT).show()
                    }
                }





            }
        }
    }
}