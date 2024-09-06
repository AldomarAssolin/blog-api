package com.aldomarassolin.blog_api.model.categorias;


import com.aldomarassolin.blog_api.model.artigos.Posts;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "tb_categorias") // Define o nome da tabela no banco de dados
@Data // Lombok para gerar getters, setters e outros métodos
@NoArgsConstructor // Lombok para gerar o construtor sem argumentos
@AllArgsConstructor // Lombok para gerar o construtor com todos os argumentos
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Posts> posts;

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }
}
