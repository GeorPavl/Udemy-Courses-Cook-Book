package com.springboot.blogrestapi.service;

import com.springboot.blogrestapi.playload.PostDto;

public interface PostService {

    PostDto createPost(PostDto postDto);
}
