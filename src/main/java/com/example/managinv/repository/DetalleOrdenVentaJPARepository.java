package com.example.managinv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.managinv.model.DetalleOrdenVentaModel;

@Repository
public interface DetalleOrdenVentaJPARepository extends JpaRepository<DetalleOrdenVentaModel,Integer>{

}
