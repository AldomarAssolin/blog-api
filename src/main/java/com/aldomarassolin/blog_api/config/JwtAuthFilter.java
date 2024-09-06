package com.aldomarassolin.blog_api.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //extrai o token JWT da requisacao
        String token = getTokenFromRequest(request);

        //valida o token jwt
        if(token != null && jwtTokenProvider.validateToken(token)){
            //extrai email do token
            String email = jwtTokenProvider.getEmailOfToken(token);

            //cria uma autemticacao com base no email extraido do token
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(email, null,new ArrayList<>());
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            //defini autenticacao
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }

        //continua o filtro
        filterChain.doFilter(request, response);
    }

    // Método para extrair o token JWT do cabeçalho Authorization
    private String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        // Verificar se o token está presente e começa com "Bearer"
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // Retorna o token sem o prefixo "Bearer "
        }
        return null;
    }

}
