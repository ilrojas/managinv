package com.example.managinv.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.managinv.dao.ICategoriaDAO;
import com.example.managinv.model.CategoriaModel;
import com.google.gson.Gson;

@Service
public class CategoriaServicesImpl implements ICategoriaService{

    @Autowired
    private ICategoriaDAO categoriaDAO;

    @Transactional(readOnly = true)
    @Override
    public CategoriaModel devolverCategoria(int id) {
        return categoriaDAO.devolverCategoria(id).orElseThrow(()->new RuntimeException("Categoría no encontrada"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<CategoriaModel> devolverCategorias() {
        return categoriaDAO.devolverCategorias();
    }

    @Transactional
    @Override
    public void eliminarCategoria(int id) {
        categoriaDAO.eliminarCategoria(id);
    }

    @Transactional
    @Override
    public Boolean guardarCategoria(String categoria) {
        try {
            CategoriaModel categorianew=new Gson().fromJson(categoria, CategoriaModel.class);
            CategoriaModel result= categoriaDAO.guardarCategoria(categorianew);
            return (result != null)?true:false;                
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }       
    }

    @Transactional
    public Boolean actualizarCategoria(String categoria) {
        try {
            CategoriaModel categorianew=new Gson().fromJson(categoria, CategoriaModel.class);
            CategoriaModel result= categoriaDAO.actualizarCategoria(categorianew);
            return (result != null)?true:false;                
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }  
    }

    

    
}
