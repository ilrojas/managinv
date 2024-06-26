package com.example.managinv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.managinv.model.ProveedorModel;

@Repository
public interface ProveedorJPARepository extends JpaRepository<ProveedorModel, Integer>{

}
