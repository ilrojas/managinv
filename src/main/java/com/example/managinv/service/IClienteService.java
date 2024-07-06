package com.example.managinv.service;

import java.util.List;


import com.example.managinv.model.ClienteModel;


public interface IClienteService {	
	List<ClienteModel> devolverClientes();
	Boolean guardarCliente(String cliente);
	ClienteModel devolverCliente(int id);
	void eliminarCliente(int id);
	Boolean actualizarCliente(String cliente);
}
