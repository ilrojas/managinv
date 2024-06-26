package com.example.managinv.dao;

import java.util.List;
import java.util.Optional;

import com.example.managinv.model.ClienteModel;

public interface IClienteDAO {
	
	Optional<ClienteModel> devolverCliente(int id);
	List<ClienteModel> devolverClientes();
	Boolean guardarCliente(ClienteModel cliente);
	void eliminarCliente(int id);
	
}
