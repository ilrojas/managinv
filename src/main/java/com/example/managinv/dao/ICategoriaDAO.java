package com.example.managinv.dao;

import java.util.List;
import java.util.Optional;

import com.example.managinv.model.CategoriaModel;

public interface ICategoriaDAO {

    Optional<CategoriaModel> devolverCategoria(int id);
    List<CategoriaModel> devolverCategorias();
    CategoriaModel guardarCategoria(CategoriaModel categoria);
    void eliminarCategoria(int id);
    CategoriaModel actualizarCategoria(CategoriaModel categoria);
}
