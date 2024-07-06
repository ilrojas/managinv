package com.example.managinv.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.managinv.model.RolesModel;
import com.example.managinv.repository.RolesJPARepository;

@Component
public class RolesDAOImpl implements IRolesDAO{

    @Autowired
    private RolesJPARepository rolesRepository;

    @Override
    public Optional<RolesModel> devolverRol(int id) {
        return rolesRepository.findById(id);
    }

    @Override
    public List<RolesModel> devolverRoles() {
        return rolesRepository.findAll();
    }

    @Override
    public RolesModel guardarRol(RolesModel rol) {
        return rolesRepository.save(rol);
    }

    @Override
    public void eliminarRol(int id) {
        rolesRepository.deleteById(id);
    }

    @Override
    public RolesModel actualizarRol(RolesModel rol) {
        return rolesRepository.save(rol);
    }

}
