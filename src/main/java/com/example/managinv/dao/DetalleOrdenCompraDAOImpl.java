package com.example.managinv.dao;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.managinv.model.DetalleOrdenCompraModel;
import com.example.managinv.repository.DetalleOrdenCompraJPARepository;

@Component
public class DetalleOrdenCompraDAOImpl implements IDetalleOrdenCompraDAO{

    @Autowired
    private DetalleOrdenCompraJPARepository detalleOrdenCompraRepository;

    @Override
    public Optional<DetalleOrdenCompraModel> devolverDetalleOrdenCompra(int id) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'devolverDetalleOrdenCompra'");
        return detalleOrdenCompraRepository.findById(id);
    }

    @Override
    public List<DetalleOrdenCompraModel> devolverDetallesOrdenesCompras(){
        return (List<DetalleOrdenCompraModel>)detalleOrdenCompraRepository.findAll();
    }

    @Override
    public Boolean guardarDetalleOrdenCompra(DetalleOrdenCompraModel detalle) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'guardarDetalleOrdenCompra'");
       detalleOrdenCompraRepository.save(detalle);
       return true;
    }

    @Override
    public void eliminarDetalleOrdenCompra(int id) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'eliminarDetalleOrdenCompra'");
        detalleOrdenCompraRepository.deleteById(id);
    }
    
}
