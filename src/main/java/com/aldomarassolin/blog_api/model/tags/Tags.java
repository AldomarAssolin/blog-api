package com.aldomarassolin.blog_api.model.tags;

import com.aldomarassolin.blog_api.model.artigos.Posts;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "tb_tags") // Define o nome da tabela no banco de dados
@Data // Lombok para gerar getters, setters e outros métodos
@NoArgsConstructor // Lombok para gerar o construtor sem argumentos
@AllArgsConstructor // Lombok para gerar o construtor com todos os argumentos
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tag;

    @Column(nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "tags")
    private List<Posts> posts;

    public Long getId_tag() {
        return id_tag;
    }

    public void setId_tag(Long id_tag) {
        this.id_tag = id_tag;
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
