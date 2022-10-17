package com.springboot.blogrestapi.service.impl;

import com.springboot.blogrestapi.entity.Post;
import com.springboot.blogrestapi.exception.ResourceNotFoundException;
import com.springboot.blogrestapi.playload.PostDto;
import com.springboot.blogrestapi.repository.PostRepository;
import com.springboot.blogrestapi.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Override
    public PostDto createPost(PostDto postDto) {
        /* Convert DTO to entity */
        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);
        /* Convert entity to DTO */
        PostDto postResponse = mapToDto(newPost);

        return postResponse;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();

        return posts.stream()
                .map(post -> mapToDto(post))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Post.class.getName(),"id", id));

        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Post.class.getName(),"id", id));

        BeanUtils.copyProperties(postDto, post, new String[] { "id" });
        Post updatedPost = postRepository.save(post);

        return mapToDto(updatedPost);
    }

    private PostDto mapToDto(Post post) {
        PostDto postDto = new PostDto();
        BeanUtils.copyProperties(post, postDto);
        return postDto;
    }

    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        BeanUtils.copyProperties(postDto, post, new String[] { "id" });
        return post;
    }
}
