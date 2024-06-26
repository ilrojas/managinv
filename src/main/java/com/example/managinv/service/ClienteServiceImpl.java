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
		// TODO Auto-generated method stub
		try {
			ClienteModel clientenew=new Gson().fromJson(cliente, ClienteModel.class);
			clienteDAO.guardarCliente(clientenew);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Transactional
	public void eliminarCliente(int id) {
		// TODO Auto-generated method stub
		clienteDAO.eliminarCliente(id);
	}
	
	//AQUI PODEMOS CREAR METODOS PERSONALIZADOS EN LA CAPA DE SERVICIOS
}
