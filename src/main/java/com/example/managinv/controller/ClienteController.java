package com.example.managinv.controller;

import com.example.managinv.model.ClienteModel;
import com.example.managinv.service.IClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/api/microservice/cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	//* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	//Función para registrar a un cliente
	//* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	@PostMapping(path={"/registrarCliente"})
	public String  guardarCliente(@ModelAttribute("cliente") ClienteModel cliente){	
		try {
			ObjectMapper objectMapper= new ObjectMapper();
			String clienteJSON = objectMapper.writeValueAsString(cliente);
			clienteService.guardarCliente(clienteJSON);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 	"redirect:/api/microservice/cliente/formRegistrarCliente";
	}
	
	@GetMapping(path={"/devolverCliente"})
	public Optional<ClienteModel> devolverCliente(@RequestParam int id){
		return clienteService.devolverCliente(id);		
	}

	@GetMapping(path={"/devolverClientes"})
	public String devolverClientes(Model model){		 
        List<ClienteModel> listadoClientes = clienteService.devolverClientes();
        model.addAttribute("cabecera", "Gestión de Clientes");		
		model.addAttribute("subtitulo", "Listado de clientes");
        model.addAttribute("listado", listadoClientes);
        return "listaClientes";
	}

	@DeleteMapping(path={"/eliminarCliente"})
	public void eliminarCliente(@RequestParam int id){
		clienteService.eliminarCliente(id);
	}


	//* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	//Función que devuelve el formulario de registro de clientes
	//* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	@GetMapping(path={"/formRegistrarCliente"})
	public String formRegistrarCliente(Model model) {
		ClienteModel cliente=new ClienteModel();
		model.addAttribute("cliente", cliente);
		model.addAttribute("cabecera", "Gestión de Clientes");
		model.addAttribute("subtitulo", "Formulario de Registro de Cliente");
		return "agregarCliente";
	}
	
   
	
}
