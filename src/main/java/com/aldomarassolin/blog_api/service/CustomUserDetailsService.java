package com.aldomarassolin.blog_api.service;

import com.aldomarassolin.blog_api.model.usuario.Usuario;
import com.aldomarassolin.blog_api.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = repository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//                AuthorityUtils.createAuthorityList(user.getAuthorities()));
        return null;
    }
}
