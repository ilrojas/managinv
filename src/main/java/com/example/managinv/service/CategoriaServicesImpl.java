package com.example.managinv.service;

import java.util.List;
import java.util.Optional;


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
    public Optional<CategoriaModel> devolverCategoria(int id) {
        // TODO Auto-generated method stub
        return categoriaDAO.devolverCategoria(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CategoriaModel> devolverCategorias() {
        // TODO Auto-generated method stub
        return categoriaDAO.devolverCategorias();
    }

    @Transactional
    @Override
    public void eliminarCategoria(int id) {
        // TODO Auto-generated method stub
        categoriaDAO.eliminarCategoria(id);
    }

    @Transactional
    @Override
    public Boolean guardarCategoria(String categoria) {
        
            CategoriaModel categorianew=new Gson().fromJson(categoria, CategoriaModel.class);
            CategoriaModel result= categoriaDAO.guardarCategoria(categorianew);
            if(result != null)
                return true;  
            else
                return false;        
        
        
    }

    @Transactional
    public Boolean actualizarCategoria(CategoriaModel categoria) {
        CategoriaModel result = categoriaDAO.actualizarCategoria(categoria);
        if(result != null)
                return true;  
            else
                return false; 
    }

    

    
}
