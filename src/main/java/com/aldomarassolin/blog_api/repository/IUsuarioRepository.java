package com.aldomarassolin.blog_api.repository;

import com.aldomarassolin.blog_api.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findById(Long id);

    //Usuario findByUsername(String username);
}
