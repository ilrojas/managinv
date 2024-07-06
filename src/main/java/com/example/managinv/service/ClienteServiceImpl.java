package com.example.managinv.service;

import java.util.List;

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
	public ClienteModel devolverCliente(int id) {
		// TODO Auto-generated method stub
		return clienteDAO.devolverCliente(id).orElseThrow(()->new RuntimeException("Cliente no encontrado"));
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
			return (cli != null)?true:false;			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Transactional
	public void eliminarCliente(int id) {
		clienteDAO.eliminarCliente(id);
	}

	@Transactional
	public Boolean actualizarCliente(String cliente) {
		try {
			ClienteModel clientenew=new Gson().fromJson(cliente, ClienteModel.class);
			ClienteModel cli= clienteDAO.actualizarCliente(clientenew);
			return (cli != null)?true:false;			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	//AQUI PODEMOS CREAR METODOS PERSONALIZADOS EN LA CAPA DE SERVICIOS
}
