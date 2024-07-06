package com.example.managinv.service;

import java.util.List;

import com.example.managinv.model.UsuarioModel;

public interface IUsuarioService {

    UsuarioModel devolverUsuario(int id);
    List<UsuarioModel> devolverUsuarios();
    Boolean guardarUsuario(String usuario);
    void eliminarUsuario (int id);
    Boolean actualizarUsuario(String usuario);
}
