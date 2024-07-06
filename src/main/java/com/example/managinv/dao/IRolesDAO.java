package com.example.managinv.dao;

import java.util.List;
import java.util.Optional;

import com.example.managinv.model.RolesModel;

public interface IRolesDAO {

    Optional<RolesModel> devolverRol (int id);
    List<RolesModel> devolverRoles();
    RolesModel guardarRol(RolesModel rol);
    void eliminarRol(int id);
    RolesModel actualizarRol(RolesModel rol);

}
