package com.example.managinv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.managinv.dao.IClienteDAO;
import com.example.managinv.model.ClienteModel;
import com.google.gson.Gson;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private IClienteDAO clienteDAO;
	
	@Transactional(readOnly = true)
	public Optional<ClienteModel> devolverCliente(int id) {
		// TODO Auto-generated method stub
		return clienteDAO.devolverCliente(id);
	}

	@Transactional(readOnly = true)
	public List<ClienteModel> devolverClientes() {
		// TODO Auto-generated method stub
		return clienteDAO.devolverClientes();
	}

	@Transactional
	public Boolean guardarCliente(String cliente) {
		try {
			ClienteModel clientenew=new Gson().fromJson(cliente, ClienteModel.class);
			ClienteModel cli= clienteDAO.guardarCliente(clientenew);
			if (cli != null) {
				return true;
			}
			else
				return false;
			
		} catch (Exception e) {
			throw new RuntimeException("No se pudo insertar en la BD");
		}
		
	}

	@Transactional
	public void eliminarCliente(int id) {
		// TODO Auto-generated method stub
		clienteDAO.eliminarCliente(id);
	}

	@Transactional
	public Boolean actualizarCliente(ClienteModel cliente) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actualizarCliente'");
	}
	
	
	//AQUI PODEMOS CREAR METODOS PERSONALIZADOS EN LA CAPA DE SERVICIOS
}
