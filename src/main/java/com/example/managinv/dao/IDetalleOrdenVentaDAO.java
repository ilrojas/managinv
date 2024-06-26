package com.example.managinv.dao;

import java.util.List;
import java.util.Optional;

import com.example.managinv.model.DetalleOrdenVentaModel;

public interface IDetalleOrdenVentaDAO {

    Optional<DetalleOrdenVentaModel> devolverDetalleOrdenVenta(int id);
    List<DetalleOrdenVentaModel> devolverDetallesOrdenesVentas();
    Boolean guardarDetalleOrdenVenta(DetalleOrdenVentaModel detalle);
    void eliminarDetalleOrdenVenta(int id);

}
