package com.example.managinv.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.managinv.model.ClienteModel;
import com.example.managinv.repository.ClienteJPARepository;


@Component
public class ClienteDAOImpl implements IClienteDAO{
	
	@Autowired
	private ClienteJPARepository clienteRepository;

	@Override
	public Optional<ClienteModel> devolverCliente(int id) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Override
	public List<ClienteModel> devolverClientes() {
		// TODO Auto-generated method stub
		return (List<ClienteModel>)clienteRepository.findAll();
	}

	@Override
	public ClienteModel guardarCliente(ClienteModel cliente) {
		// TODO Auto-generated method stub
		return clienteRepository.save(cliente);		
	}

	@Override
	public void eliminarCliente(int id) {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}

	@Override
	public ClienteModel actualizarCliente(ClienteModel cliente) {
		// TODO Auto-generated method stub
		return clienteRepository.save(cliente);
	}

	

}
