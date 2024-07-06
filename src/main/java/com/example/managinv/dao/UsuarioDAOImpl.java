package com.example.managinv.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.managinv.model.UsuarioModel;
import com.example.managinv.repository.UsuarioJPARepository;

@Component
public class UsuarioDAOImpl implements IUsuarioDAO{

    @Autowired
    private UsuarioJPARepository usuarioRepository;

    @Override
    public Optional<UsuarioModel> devolverUsuario(int id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<UsuarioModel> devolverUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(int id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioModel actualizarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

}
