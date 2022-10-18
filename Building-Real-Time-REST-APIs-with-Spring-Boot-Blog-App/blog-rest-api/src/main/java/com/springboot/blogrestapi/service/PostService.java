package com.springboot.blogrestapi.service;

import com.springboot.blogrestapi.payload.PostDto;
import com.springboot.blogrestapi.payload.PostResponse;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageSize, int pageNo, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
