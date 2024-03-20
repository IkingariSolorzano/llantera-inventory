package com.llanteradeoccidente.llanterainventory.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {


    @GetMapping("/crear")
    public String crearUsuario() {
        return "Usuario creado";
    }



}
