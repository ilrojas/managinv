package com.example.managinv.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.managinv.model.CategoriaModel;
import com.example.managinv.repository.CategoriaJPARepository;

@Component
public class CategoriaDAOImpl implements ICategoriaDAO{

    @Autowired
    private CategoriaJPARepository categoriaRepository;

    @Override
    public Optional<CategoriaModel> devolverCategoria(int id) {
        // TODO Auto-generated method stub
        return categoriaRepository.findById(id);
        //throw new UnsupportedOperationException("Unimplemented method 'devolverCategoria'");
    }

    @Override
    public List<CategoriaModel> devolverCategorias() {
        // TODO Auto-generated method stub
        return (List<CategoriaModel>)categoriaRepository.findAll();
        // throw new UnsupportedOperationException("Unimplemented method 'devolverCategorias'");
    }

    @Override
    public Boolean guardarCategoria(CategoriaModel categoria) {
        // TODO Auto-generated method stub        
        categoriaRepository.save(categoria);
        return true;
        // throw new UnsupportedOperationException("Unimplemented method 'guardarCategoria'");
    }

    @Override
    public void eliminarCategoria(int id) {
        // TODO Auto-generated method stub
        categoriaRepository.deleteById(id);
        // throw new UnsupportedOperationException("Unimplemented method 'eliminarCategoria'");
    }

}
