package com.example.managinv.service;

import java.util.List;
import java.util.Optional;

import com.example.managinv.model.ProveedorModel;

public interface IProveedorService {
    Optional<ProveedorModel> devolverProveedor(int id);
    List<ProveedorModel> devolverProveedores();    
    Boolean guardarProveedor(String proveedor);
	void eliminarProveedor(int id);
    Boolean actualizarProveedor( ProveedorModel proveedor);

}
