package com.example.demo.controllers;


import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

//indica que es un controlador
@RestController
//Indica la direccion del controlador
@RequestMapping("/metodos")
public class UsuarioController {

    @Autowired
    UsuarioService servicio;

    //se ejcuta con una peticion de tipo get
    @GetMapping
    public ArrayList<UsuarioModel>obtenerUsuarios(){
        return servicio.obtenerUsuarios();
    }


    @PostMapping
    public UsuarioModel nuevoUsuario(@RequestBody UsuarioModel modelo){
        return servicio.guardarUsuario(modelo);
    }


    @GetMapping(path = "/{ID}")
    public Optional<UsuarioModel>buscarPorId(@PathVariable("ID") Long id){
        return servicio.buscarPorId(id);
    }





}
