package com.example.managinv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.managinv.model.CategoriaModel;
import com.example.managinv.service.ICategoriaService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.ui.Model;



@Controller
@RequestMapping("/api/microservice/categoria")

public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    /**
     * @param categoria
     * @return
     */
    @PostMapping(path={"/registrarCategoria"})    
    public String guardarCategoria(@ModelAttribute("categoria") CategoriaModel categoria){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String categoriaJSON = objectMapper.writeValueAsString(categoria);
            categoriaService.guardarCategoria(categoriaJSON);   
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return "redirect:/";   
    }

    @DeleteMapping(path={"/eliminarCategoria"})
    public void eliminarCategoria(@RequestParam int id){
        categoriaService.eliminarCategoria(id);
    }

    @GetMapping(path={"/devolverCategoria"})    
    public Optional<CategoriaModel> devolverCategoria(@RequestParam int id){
        return categoriaService.devolverCategoria(id);
        
    } 

    @GetMapping(path={"/devolverCategorias"})  
    public String devolverCategorias(Model model){
        List<CategoriaModel> listadoCategorias = categoriaService.devolverCategorias();
        model.addAttribute("cabecera", "Gestión de Categorias");
        model.addAttribute("listado", listadoCategorias);
        return "listaCategorias";
    }

    //* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	//Función que devuelve el formulario de registro de categoria
	//* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	@GetMapping(path={"/formRegistrarCategoria"})
	public String formRegistrarCliente(Model model) {
		CategoriaModel categoria=new CategoriaModel();
		model.addAttribute("categoria", categoria);
		model.addAttribute("cabecera", "Gestión de Categorias");
		model.addAttribute("subtitulo", "Formulario de Registro de Categoria");
		return "agregarCategoria";
	}
}
