package com.example.managinv.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.managinv.model.ProveedorModel;
import com.example.managinv.repository.ProveedorJPARepository;

@Component
public class ProveedorDAOImpl implements IProveedorDAO{

    @Autowired
    private ProveedorJPARepository proveedorRepository;

    @Override
    public Optional<ProveedorModel> devolverProveedor(int id) {
        // TODO Auto-generated method stub
        return proveedorRepository.findById(id);
    }

    @Override
    public List<ProveedorModel> devolverProveedores() {
        // TODO Auto-generated method stub
        return proveedorRepository.findAll();
    }

    @Override
    public void eliminarProveedor(int id) {
        // TODO Auto-generated method stub
         proveedorRepository.deleteById(id);
    }

    @Override
    public Boolean guardarProveedor(ProveedorModel proveedor) {
        // TODO Auto-generated method stub
        return proveedorRepository.save(proveedor)!=null?true:false;
    }
    

}
