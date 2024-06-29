package com.example.managinv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.managinv.dao.IProveedorDAO;
import com.example.managinv.model.ProveedorModel;
import com.google.gson.Gson;

@Service
public class ProveedorServiceImpl implements IProveedorService{

    @Autowired
    private IProveedorDAO proveedorDAO;

    @Override
    @Transactional(readOnly = true)
    public Optional<ProveedorModel> devolverProveedor(int id) {
        return proveedorDAO.devolverProveedor(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProveedorModel> devolverProveedores() {
        return proveedorDAO.devolverProveedores();
    }

    @Override
    @Transactional()
    public Boolean guardarProveedor(String proveedor) {
        ProveedorModel proveedorNew= new Gson().fromJson(proveedor, ProveedorModel.class);
        ProveedorModel result = proveedorDAO.guardarProveedor(proveedorNew);
        if(result != null)
            return true;
        else
         return false;
    }

    @Override
    @Transactional()
    public void eliminarProveedor(int id) {
        proveedorDAO.eliminarProveedor(id);
    }

    @Override
    @Transactional()
    public Boolean actualizarProveedor(ProveedorModel proveedor) {
        ProveedorModel result = proveedorDAO.actualizarProveedor(proveedor);
        if(result != null)
                return true;  
            else
                return false; 
    }

}