package com.example.managinv.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.managinv.service.IRolesService;
import com.example.managinv.service.IUsuarioService;
import com.example.managinv.model.RolesModel;
import com.example.managinv.model.UsuarioModel;


@Controller
@RequestMapping("/api/microservice/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IRolesService rolService;

    @GetMapping( path={ "/devolverUsuarios" } )
    public String devolverUsuarios(Model model){
        List<UsuarioModel> listadoUsuarios = usuarioService.devolverUsuarios();
        model.addAttribute("subtitulo", "Listado de Usuarios");
        model.addAttribute("cabecera", "Gestión de Usuarios");
        if(listadoUsuarios == null || listadoUsuarios.isEmpty()){
            model.addAttribute("errorMessage", "No se encontraron datos de usuarios almacenados");
        } else{
            model.addAttribute("listado", listadoUsuarios);
        }
        return "listaUsuarios";
    }

    @GetMapping(path={"formRegistrarUsuario"})
    public String formRegistrarUsuario(Model model) {
        UsuarioModel usuario = new UsuarioModel();
		model.addAttribute("usuario", usuario);
        model.addAttribute("subtitulo", "Agregar Usuarios");
        model.addAttribute("cabecera", "Gestión de Usuarios");
        List<RolesModel> roles = rolService.devolverRoles();
        model.addAttribute("roles", roles);
        return "agregarUsuario";
    }
    
}
