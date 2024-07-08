package com.example.managinv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.managinv.model.CategoriaModel;
import com.example.managinv.service.ICategoriaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/api/microservice/categoria")

public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    /**
     * @param categoria
     * @return
     */
    @PostMapping(path = { "/registrarCategoria" })
    public String registrarCategoria(@ModelAttribute("categoria") CategoriaModel categoria,
            RedirectAttributes redirectAttributes) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String categoriaJSON = objectMapper.writeValueAsString(categoria);
            redirectAttributes.addFlashAttribute("contenido",
             "/api/microservice/categoria/formRegistrarCategoria");
            boolean result = categoriaService.guardarCategoria(categoriaJSON);
            if (result)
                redirectAttributes.addFlashAttribute("successMessage",
                 "El elemento fue creado con éxito!");
            else
                redirectAttributes.addFlashAttribute("errorMessage",
                        "Ocurrió un error, trataremos de solucionarlo lo antes posible!");
            return "redirect:/api/managinv/index";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/api/managinv/index";
        }

    }

    @GetMapping(path = { "/eliminarCategoria/{id}" })
    public String eliminarCategoria(@PathVariable int id,
    RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("contenido",
             "/api/microservice/categoria/devolverCategorias");
        redirectAttributes.addFlashAttribute("successMessage",
         "Categoria con identificador ("+ id+ ") eliminada");
        categoriaService.eliminarCategoria(id);
        return "redirect:/api/managinv/index";
    }


    @GetMapping(path = { "/devolverCategoria" })
    public CategoriaModel devolverCategoria(@RequestParam int id) {
        return categoriaService.devolverCategoria(id);

    }

    @GetMapping(path = { "/devolverCategorias" })
    public String devolverCategorias(Model model) {
        List<CategoriaModel> listadoCategorias = categoriaService.devolverCategorias();        
        model.addAttribute("subtitulo", "Listado de Categorías");
        model.addAttribute("cabecera", "Gestión de Categorias");
        if (listadoCategorias == null || listadoCategorias.isEmpty()) {
            model.addAttribute("errorMessage",
             "No se encontraron datos de Categorías almacenadas");
        } else {
            model.addAttribute("listado", listadoCategorias);            
        }
        return "listaCategorias";
    }

    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    // Función que devuelve el formulario de registro de categoria
    // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    @GetMapping(path = { "/formRegistrarCategoria" })
    public String formRegistrarCliente(Model model) {
        CategoriaModel categoria = new CategoriaModel();
        model.addAttribute("categoria", categoria);
        model.addAttribute("cabecera",
         "Gestión de Categorias");
        model.addAttribute("subtitulo",
         "Formulario de Registro de Categoria");
        return "agregarCategoria";
    }
}
