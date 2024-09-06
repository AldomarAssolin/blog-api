package com.aldomarassolin.blog_api.service;

import com.aldomarassolin.blog_api.config.JwtTokenProvider;
import com.aldomarassolin.blog_api.model.Usuario;
import com.aldomarassolin.blog_api.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository repository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(Usuario usuario){
        if (repository.existsByEmail(usuario.getEmail())){
            throw new IllegalArgumentException("E-mail já está em uso.");
        }

        // criptografa a senha antes de salvar
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        //salva usuario no DB
        repository.save(usuario);
    }

    public String authenticateUser(Usuario usuario) {
        Usuario existentUser = repository.findByEmail(usuario.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("E-mail não encontrado!"));

        //verifica se a senha esta correta
        if(!passwordEncoder.matches(usuario.getSenha(), existentUser.getSenha())){
            throw new IllegalArgumentException("Senha incorreta!");
        }

        // Gera token
        return jwtTokenProvider.generateToken(existentUser);
    }
}
