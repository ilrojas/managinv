package com.example.managinv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.managinv.model.ClienteModel;

@Repository
public interface ClienteJPARepository extends JpaRepository<ClienteModel, Integer> {
	
	//AQUI PODEMOS CREAR METODOS PERSONALIZADOS DE CONSULTAS
}
