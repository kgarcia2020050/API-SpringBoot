package com.example.demo.services;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;


    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>)  repository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel modelo){
        return repository.save(modelo);
    }


    //si el id no existe, se debe poner como tipo opcional
    public Optional<UsuarioModel> buscarPorId(Long id){
        return repository.findById(id);
    }


    public ArrayList<UsuarioModel> buscarPorNombre(String nombre){
        return repository.findByNombre(nombre);
    }


    public boolean eliminarUsuario(Long id){
        try{
            repository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace(System.out);
            return false;
        }
    }


}
