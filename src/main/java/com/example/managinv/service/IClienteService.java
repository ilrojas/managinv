package com.example.managinv.service;

import java.util.List;
import java.util.Optional;


import com.example.managinv.model.ClienteModel;


public interface IClienteService {	
	List<ClienteModel> devolverClientes();
	Boolean guardarCliente(String cliente);
	Optional<ClienteModel> devolverCliente(int id);
	void eliminarCliente(int id);
	Boolean actualizarCliente(ClienteModel cliente);
}
