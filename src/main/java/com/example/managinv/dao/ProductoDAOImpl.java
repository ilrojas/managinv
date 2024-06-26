package com.example.managinv.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.managinv.model.ProductoModel;
import com.example.managinv.repository.ProductoJPARepository;

@Component

public class ProductoDAOImpl implements IProductoDAO{

    @Autowired
    private ProductoJPARepository productoRepository;

    @Override
    public Optional<ProductoModel> devolverProducto(int id) {
        // TODO Auto-generated method stub
        return productoRepository.findById(id);
    }

    @Override
    public List<ProductoModel> devolverProductos() {
        // TODO Auto-generated method stub
        return productoRepository.findAll();
    }

    @Override
    public void eliminarProducto(int id) {
        // TODO Auto-generated method stub
        productoRepository.deleteById(id);
    }

    @Override
    public Boolean guardarProducto(ProductoModel producto) {
        // TODO Auto-generated method stub
        return productoRepository.save(producto) != null?true:false;
    
    }
    
}
