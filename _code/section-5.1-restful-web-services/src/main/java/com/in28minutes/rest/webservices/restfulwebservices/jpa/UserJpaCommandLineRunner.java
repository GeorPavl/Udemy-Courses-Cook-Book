package com.in28minutes.rest.webservices.restfulwebservices.jpa;

import com.in28minutes.rest.webservices.restfulwebservices.post.Post;
import com.in28minutes.rest.webservices.restfulwebservices.post.PostRepository;
import com.in28minutes.rest.webservices.restfulwebservices.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserJpaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = userRepository.save(new User("Giorgos", LocalDate.now().minusYears(28)));
        User user1 = userRepository.save(new User("Giannis", LocalDate.now().minusYears(28)));

        Post post = new Post("My custom description for first post");
        post.setUser(user);
        postRepository.save(post);

        Post post1 = new Post("My second custom description");
        post1.setUser(user1);
        postRepository.save(post1);
    }
}
