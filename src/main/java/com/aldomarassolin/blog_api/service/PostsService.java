package com.aldomarassolin.blog_api.service;

import com.aldomarassolin.blog_api.repository.IPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {

    @Autowired
    private IPostsRepository repository;


}
