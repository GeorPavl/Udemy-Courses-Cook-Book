package com.springboot.blogrestapi.service.impl;

import com.springboot.blogrestapi.entity.Post;
import com.springboot.blogrestapi.playload.PostDto;
import com.springboot.blogrestapi.repository.PostRepository;
import com.springboot.blogrestapi.service.PostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Override
    public PostDto createPost(PostDto postDto) {
        /* Convert DTO to entity */
        Post post = new Post();
        BeanUtils.copyProperties(postDto, post);

        Post newPost = postRepository.save(post);

        /* Convert entity to DTO */
        PostDto postResponse = new PostDto();
        BeanUtils.copyProperties(post, newPost);

        return postResponse;
    }
}
