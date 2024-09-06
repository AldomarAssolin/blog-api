package com.aldomarassolin.blog_api.model.artigos;


import com.aldomarassolin.blog_api.model.categorias.Categorias;
import com.aldomarassolin.blog_api.model.tags.Tags;
import com.aldomarassolin.blog_api.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "tb_artigo") // Define o nome da tabela no banco de dados
@Data // Lombok para gerar getters, setters e outros métodos
@NoArgsConstructor // Lombok para gerar o construtor sem argumentos
@AllArgsConstructor // Lombok para gerar o construtor com todos os argumentos
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_post;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String subtitulo;

    @Column(columnDefinition = "TEXT") // Para textos longos
    private String conteudo;

    @CreationTimestamp
    private LocalDateTime created_at;

    @CreationTimestamp
    private LocalDateTime updated_at;

    // Relação Many-to-One com o autor do artigo (Usuário)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario author; // Referência ao autor do artigo (chave estrangeira)

    // Relação Many-to-One com a categoria do artigo
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categorias categoria; // Referência à categoria do artigo (chave estrangeira)

    @ManyToMany
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name="id_posts"),
            inverseJoinColumns = @JoinColumn(name = "id_tag")
    )
    private List<Tags> tags;

    @ManyToMany
    @JoinTable(
            name = "post_like",
            joinColumns = @JoinColumn(name = "Id_post"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    private List<Usuario> likes;


    public Long getId_post() {
        return id_post;
    }

    public void setId_post(Long id_post) {
        this.id_post = id_post;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public Usuario getAuthor() {
        return author;
    }

    public void setAuthor(Usuario author) {
        this.author = author;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public List<Usuario> getLikes() {
        return likes;
    }

    public void setLikes(List<Usuario> likes) {
        this.likes = likes;
    }
}
