package com.example.managinv.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.managinv.model.RolesModel;
import com.example.managinv.service.IRolesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/api/microservice/roles")
public class RolesController {

    @Autowired
    private IRolesService rolesService;

    @GetMapping(path={"/devolverRoles"})    
    public String devolverRoles(Model model){
        List<RolesModel> listado = rolesService.devolverRoles();
        model.addAttribute("cabecera", "Gestión de Roles");
        model.addAttribute("subtitulo", "Listado de Roles");
        if(listado == null || listado.isEmpty()){
            model.addAttribute("errorMessage", "No se encontraron datos de roles almacenados");
        } else{
            model.addAttribute("listado", listado);
        }
        return "listaRoles";
    }

}
