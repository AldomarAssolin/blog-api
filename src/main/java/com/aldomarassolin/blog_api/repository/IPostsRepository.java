package com.aldomarassolin.blog_api.repository;

import com.aldomarassolin.blog_api.model.artigos.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostsRepository extends JpaRepository<Posts, Long> {
}
