package com.example.managinv.service;

import java.util.List;

import com.example.managinv.model.CategoriaModel;

public interface ICategoriaService {

    CategoriaModel devolverCategoria(int id);
    List<CategoriaModel> devolverCategorias();
    void eliminarCategoria(int id);
    Boolean guardarCategoria(String categoria);
    Boolean actualizarCategoria(String categoriaModel);
}
