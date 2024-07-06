package com.example.managinv.service;

import java.util.List;

import com.example.managinv.model.ProveedorModel;

public interface IProveedorService {
    ProveedorModel devolverProveedor(int id);
    List<ProveedorModel> devolverProveedores();    
    Boolean guardarProveedor(String proveedor);
	void eliminarProveedor(int id);
    Boolean actualizarProveedor( String proveedor);

}
