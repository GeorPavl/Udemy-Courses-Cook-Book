package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    private static final String AUTHOR= "in28minutes";

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS", AUTHOR));
        repository.insert(new Course(2, "Learn Azure Now!", AUTHOR));
        repository.insert(new Course(3, "Learn Spring Boot", AUTHOR));

        repository.deleteById(1);
        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
    }
}
