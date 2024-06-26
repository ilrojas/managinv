package com.example.managinv.dao;

import java.util.List;
import java.util.Optional;  

import com.example.managinv.model.ProveedorModel;

public interface IProveedorDAO {

    Optional<ProveedorModel> devolverProveedor(int id);
    List<ProveedorModel> devolverProveedores();    
    Boolean guardarProveedor(ProveedorModel proveedor);
	void eliminarProveedor(int id);
}
