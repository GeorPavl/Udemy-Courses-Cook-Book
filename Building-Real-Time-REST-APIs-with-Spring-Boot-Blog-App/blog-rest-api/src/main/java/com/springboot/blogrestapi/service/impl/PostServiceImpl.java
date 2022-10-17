package com.springboot.blogrestapi.service.impl;

import com.springboot.blogrestapi.entity.Post;
import com.springboot.blogrestapi.exception.ResourceNotFoundException;
import com.springboot.blogrestapi.playload.PostDto;
import com.springboot.blogrestapi.playload.PostResponse;
import com.springboot.blogrestapi.repository.PostRepository;
import com.springboot.blogrestapi.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public PostResponse getAllPosts(int pageSize, int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page posts = postRepository.findAll(pageable);
        List<Post> listOfPosts = posts.getContent();

        List<PostDto> content = listOfPosts.stream()
                .map(post -> mapToDto(post))
                .collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalElements(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());

        return postResponse;
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

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Post.class.getName(),"id", id));

        postRepository.delete(post);
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
