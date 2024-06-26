package com.example.managinv.service;

import java.util.List;
import java.util.Optional;


import com.example.managinv.model.ClienteModel;


public interface IClienteService {

	Optional<ClienteModel> devolverCliente(int id);
	List<ClienteModel> devolverClientes();
	Boolean guardarCliente(String cliente);
	void eliminarCliente(int id);
}
