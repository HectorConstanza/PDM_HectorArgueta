package com.example.mvvm.data.repository

import com.example.mvvm.data.local.UsuarioDao
import com.example.mvvm.data.model.UsuarioEntity
import kotlinx.coroutines.flow.Flow

class UsuarioRepository(private val usuarioDao: UsuarioDao) {

    val todosLosUsuarios: Flow<List<UsuarioEntity>> = usuarioDao.obtenerUsuarios()

    suspend fun guardar(usuario: UsuarioEntity) {
        usuarioDao.insertarUsuario(usuario)
    }
}