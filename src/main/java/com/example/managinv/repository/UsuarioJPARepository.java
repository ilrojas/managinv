package com.example.managinv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.managinv.model.UsuarioModel;

public interface UsuarioJPARepository extends JpaRepository<UsuarioModel, Integer>{

}
