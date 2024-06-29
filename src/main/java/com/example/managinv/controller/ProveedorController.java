package com.example.managinv.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.managinv.model.ProveedorModel;
import com.example.managinv.service.IProveedorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;





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

    @GetMapping(path={"/eliminarProveedor/{id}"})    
    public String eliminarProveedor(@PathVariable int id,
    RedirectAttributes redirectAttributes){
        proveedorServices.eliminarProveedor(id);
        redirectAttributes.addFlashAttribute("successMessage", "Proveedor con identificador ("+ id+ ") eliminado");
        return "redirect:/api/managinv/index";

    }


}
