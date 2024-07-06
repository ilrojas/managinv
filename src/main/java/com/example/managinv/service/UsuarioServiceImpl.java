package com.example.managinv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.managinv.dao.IUsuarioDAO;
import com.example.managinv.model.UsuarioModel;
import com.google.gson.Gson;

import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Override
    @Transactional(readOnly = true)
    public UsuarioModel devolverUsuario(int id) {
        return usuarioDAO.devolverUsuario(id).orElseThrow(()->new RuntimeException("Usuario no encontrado"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioModel> devolverUsuarios() {
        return usuarioDAO.devolverUsuarios();
    }

    @Override
    @Transactional
    public Boolean guardarUsuario(String usuario) {
        try {
            UsuarioModel newUsuario = new Gson().fromJson(usuario, UsuarioModel.class);
            UsuarioModel usu = usuarioDAO.guardarUsuario(newUsuario);
            return (usu != null) ? true : false;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void eliminarUsuario(int id) {
        usuarioDAO.eliminarUsuario(id);
    }

    @Override
    @Transactional
    public Boolean actualizarUsuario(String usuario) {
        try {
            UsuarioModel newUsuario = new Gson().fromJson(usuario, UsuarioModel.class);
            UsuarioModel usu = usuarioDAO.actualizarUsuario(newUsuario);
            return (usu != null) ? true : false;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
