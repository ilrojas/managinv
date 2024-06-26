package com.example.managinv.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.managinv.model.DetalleOrdenVentaModel;
import com.example.managinv.repository.DetalleOrdenVentaJPARepository;

@Component
public class DetalleOrdenVentaDAOImpl implements IDetalleOrdenVentaDAO{

    @Autowired
    private DetalleOrdenVentaJPARepository detalleOrdenVentaRepository;

    @Override
    public Optional<DetalleOrdenVentaModel> devolverDetalleOrdenVenta(int id) {
        // TODO Auto-generated method stub
        return detalleOrdenVentaRepository.findById(id);
    }

    @Override
    public List<DetalleOrdenVentaModel> devolverDetallesOrdenesVentas() {
        // TODO Auto-generated method stub
        return (List<DetalleOrdenVentaModel>) detalleOrdenVentaRepository.findAll();
    }

    @Override
    public void eliminarDetalleOrdenVenta(int id) {
        // TODO Auto-generated method stub
        detalleOrdenVentaRepository.deleteById(id);
    }

    @Override
    public Boolean guardarDetalleOrdenVenta(DetalleOrdenVentaModel detalle) {
        // TODO Auto-generated method stub
        detalleOrdenVentaRepository.save(detalle);
        return true;
    }

    
}
