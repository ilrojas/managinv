package com.example.managinv.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.managinv.model.ProveedorModel;
import com.example.managinv.service.IProveedorService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;






@Controller
@RequestMapping("/api/microservice/proveedor")
public class ProveedorController {

    @Autowired
    private IProveedorService proveedorServices;

    @GetMapping(path={"/devolverProveedores"})    
    public String devolverProveedores (Model model){
        List<ProveedorModel> listadoProveedores = proveedorServices.devolverProveedores();        
        model.addAttribute("subtitulo", "Listado de Proveedores");
        model.addAttribute("cabecera", "Gestión de Proveedores");
        if(listadoProveedores == null || listadoProveedores.isEmpty()){
            model.addAttribute("errorMessage", "No se encontraron datos de Proveedores almacenados");
        }
        else{
            model.addAttribute("listado", listadoProveedores);
        }        
        return "listaProveedores";
    }

    @GetMapping(path={"/eliminarProveedor/{id}/{nombre}"})    
    public String eliminarProveedor(@PathVariable int id,@PathVariable String nombre,
    RedirectAttributes redirectAttributes){
        proveedorServices.eliminarProveedor(id);
        redirectAttributes.addFlashAttribute("successMessage",
         "Proveedor "+ nombre+ " eliminado");
         redirectAttributes.addFlashAttribute("contenido",
          "/api/microservice/proveedor/devolverProveedores");
        return "redirect:/api/managinv/";

    }

    //* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	//Función que devuelve el formulario de registro de proveedor
	//* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    @GetMapping(path={"/formRegistrarProveedor"})    
    public String formRegistrarProveedor(Model model){
        ProveedorModel proveedor = new ProveedorModel();
        model.addAttribute("proveedor", proveedor);
        model.addAttribute("cabecera", "Gestión de Proveedores");
		model.addAttribute("subtitulo", "Formulario de Registro de Proveedor");
        return "agregarProveedor";
    }

    @PostMapping(path="/registrarProveedor") 
    public String registrarProveedor(@ModelAttribute("proveedor") ProveedorModel proveedor,
    RedirectAttributes redirectAttributes){
        try {
            ObjectMapper object = new ObjectMapper();
            String proveedorJSON= object.writeValueAsString(proveedor);
            boolean result = proveedorServices.guardarProveedor(proveedorJSON);
            redirectAttributes.addFlashAttribute("contenido",
             "/api/microservice/proveedor/formRegistrarProveedor");
            if (result) {
                redirectAttributes.addFlashAttribute("successMessage",
                 "El elemento fue creado con éxito!");
            } else {    
                redirectAttributes.addFlashAttribute("errorMessage",
                 "Ocurrió un error, trataremos de solucionarlo lo antes posible!");
            }
            
            return "redirect:/api/managinv/";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/api/managinv/";
        }
    }


}
