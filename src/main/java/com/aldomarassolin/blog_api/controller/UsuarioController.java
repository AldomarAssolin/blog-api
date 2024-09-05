package com.aldomarassolin.blog_api.controller;


import com.aldomarassolin.blog_api.model.Usuario;
import com.aldomarassolin.blog_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        Usuario newUser = service.createUser(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuario(){
        return ResponseEntity.ok(service.listUser());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizacao){
        Optional<Usuario> usuario = service.updateUser(id);

        if(usuario.isPresent()){
            Usuario userExistent = usuario.get();
            userExistent.setNome(usuarioAtualizacao.getNome());
            userExistent.setEmail(usuarioAtualizacao.getEmail());
            userExistent.setSenha(usuarioAtualizacao.getSenha());
            userExistent.setUpdated_at(LocalDateTime.now());

            Usuario userSave = service.createUser(userExistent);
            return ResponseEntity.status(HttpStatus.CREATED).body(userSave);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    //criar atributo status para deletar usuario apenas alterando seu status
}
