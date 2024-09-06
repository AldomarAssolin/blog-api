package com.aldomarassolin.blog_api.controller;


import com.aldomarassolin.blog_api.model.Usuario;
import com.aldomarassolin.blog_api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody @Valid Usuario usuario){
        try{
            service.createUser(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid Usuario usuario){
        try{
            String token = service.authenticateUser(usuario);
            return ResponseEntity.ok(token);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    //recuperar senha
    //atualizar senha
    //deletar usuario(criar atributo status na classe Usuarios

}
