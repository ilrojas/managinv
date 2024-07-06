package com.example.managinv.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/api/managinv")
public class ClienteViewController {

    
    @GetMapping(path={"/","/index","/home","/inicio"})
    public String index(Model model) {
        model.addAttribute("titulo", "Manage Inventory");       
        return "index";
    }
    

    public String cargarContenidoDinamico(){
        return "";
    }
/*/
    @GetMapping(path = {"/vRegistrarCliente"})
    public String vRegistrarCliente(Model model){
        model.addAttribute("cabecera", "Registrar Cliente");
        return "agregarCliente";

    }
    
    @GetMapping(path = {"/vRegistrarCategoria"})
    public String vRegistrarCategoria(Model model){
        model.addAttribute("cabecera", "Registrar Categoria");
        return "agregarCategoria";

    }

    @GetMapping(path = {"/devolverCliente"})
    public String devolverCliente(Model model){
        model.addAttribute("cabecera", "Detalles de Cliente"+"id");
        return "";

    }

    */

}
