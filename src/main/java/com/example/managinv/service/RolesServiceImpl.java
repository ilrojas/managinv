package com.example.managinv.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.managinv.dao.IRolesDAO;
import com.example.managinv.model.RolesModel;
import com.google.gson.Gson;

@Service
public class RolesServiceImpl implements IRolesService{

    @Autowired
    private IRolesDAO rolesDAO;
    
    @Override
    @Transactional(readOnly = true)
    public RolesModel devolverRol(int id) {
        return rolesDAO.devolverRol(id).orElseThrow(()->new RuntimeException("No se encontro el rol"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RolesModel> devolverRoles() {
        return rolesDAO.devolverRoles();
    }

    @Override
    @Transactional()
    public Boolean guardarRol(String rol) {
        try {
            RolesModel newRol = new Gson().fromJson(rol, RolesModel.class);
            RolesModel result =  rolesDAO.guardarRol(newRol);
            return (result != null) ? true : false;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional()
    public void eliminarRol(int id) {
        rolesDAO.eliminarRol(id);
    }

    @Override
    @Transactional()
    public Boolean actualizarRol(String rol) {
        try {
            RolesModel newRol = new Gson().fromJson(rol, RolesModel.class);
            RolesModel result =  rolesDAO.actualizarRol(newRol);
            return (result != null) ? true : false;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
