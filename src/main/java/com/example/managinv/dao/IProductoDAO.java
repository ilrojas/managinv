package com.example.managinv.dao;

import java.util.List;
import java.util.Optional;

import com.example.managinv.model.ProductoModel;

public interface IProductoDAO {

    List<ProductoModel> devolverProductos();
    Optional<ProductoModel> devolverProducto(int id);
    Boolean guardarProducto(ProductoModel producto);
	void eliminarProducto(int id);

}
