package com.springboot.blogrestapi.service;

import com.springboot.blogrestapi.playload.PostDto;
import com.springboot.blogrestapi.playload.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageSize, int pageNo);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
