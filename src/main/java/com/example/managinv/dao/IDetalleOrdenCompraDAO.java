package com.example.managinv.dao;

import java.util.Optional;
import java.util.List;

import com.example.managinv.model.DetalleOrdenCompraModel;

public interface IDetalleOrdenCompraDAO {

    Optional<DetalleOrdenCompraModel> devolverDetalleOrdenCompra(int id);
    List<DetalleOrdenCompraModel> devolverDetallesOrdenesCompras();
    Boolean guardarDetalleOrdenCompra(DetalleOrdenCompraModel detalle);
    void eliminarDetalleOrdenCompra(int id);
}
