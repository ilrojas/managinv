package com.example.managinv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.managinv.model.OrdenCompraModel;

@Repository
public interface OrdenCompraJPARepository extends JpaRepository<OrdenCompraModel, Integer>{

}
