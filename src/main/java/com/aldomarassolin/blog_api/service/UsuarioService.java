package com.aldomarassolin.blog_api.service;

import com.aldomarassolin.blog_api.model.Usuario;
import com.aldomarassolin.blog_api.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository repository;

    public Usuario createUser(Usuario usuario){
        return repository.save(usuario);
    }

    public List<Usuario> listUser(){
        return repository.findAll();
    }

    public Optional<Usuario> updateUser(Long id){
        return repository.findById(id);
    }
}
