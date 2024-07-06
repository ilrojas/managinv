package com.example.managinv.dao;

import java.util.Optional;
import java.util.List;

import com.example.managinv.model.UsuarioModel;

public interface IUsuarioDAO {
    Optional<UsuarioModel> devolverUsuario(int id);
    List<UsuarioModel> devolverUsuarios();
    UsuarioModel guardarUsuario(UsuarioModel usuario);
    void eliminarUsuario (int id);
    UsuarioModel actualizarUsuario(UsuarioModel usuario);

}
