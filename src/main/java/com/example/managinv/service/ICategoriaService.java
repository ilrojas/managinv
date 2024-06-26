package com.example.managinv.service;

import java.util.List;
import java.util.Optional;

import com.example.managinv.model.CategoriaModel;

public interface ICategoriaService {

    Optional<CategoriaModel> devolverCategoria(int id);
    List<CategoriaModel> devolverCategorias();
    void eliminarCategoria(int id);
    Boolean guardarCategoria(String categoria);
}
