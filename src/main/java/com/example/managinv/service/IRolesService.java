package com.example.managinv.service;

import java.util.List;

import com.example.managinv.model.RolesModel;

public interface IRolesService {

    RolesModel devolverRol (int id);
    List<RolesModel> devolverRoles();
    Boolean guardarRol(String rol);
    void eliminarRol(int id);
    Boolean actualizarRol(String rol);
}
