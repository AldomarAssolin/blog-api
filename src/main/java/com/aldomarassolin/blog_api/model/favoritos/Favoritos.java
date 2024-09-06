package com.aldomarassolin.blog_api.model.favoritos;

import com.aldomarassolin.blog_api.model.artigos.Posts;
import com.aldomarassolin.blog_api.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tb_favoritos") // Define o nome da tabela no banco de dados
@Data // Lombok para gerar getters, setters e outros métodos
@NoArgsConstructor // Lombok para gerar o construtor sem argumentos
@AllArgsConstructor // Lombok para gerar o construtor com todos os argumentos
public class Favoritos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_favorito;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_post", nullable = false)
    private Posts posts;

    public Long getId_favorito() {
        return id_favorito;
    }

    public void setId_favorito(Long id_favorito) {
        this.id_favorito = id_favorito;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }
}
