package com.example.managinv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.managinv.model.ProductoModel;

@Repository
public interface ProductoJPARepository extends JpaRepository<ProductoModel, Integer>{

}
