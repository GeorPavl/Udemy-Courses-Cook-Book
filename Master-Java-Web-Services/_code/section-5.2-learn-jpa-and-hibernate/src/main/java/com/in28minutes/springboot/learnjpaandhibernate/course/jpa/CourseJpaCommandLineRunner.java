package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CourseJpaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJpaRepository repository;

    private static final String AUTHOR= "in28minutes";

    @Override
    public void run(String... args) throws Exception {

        repository.insert(new Course(4, "HTML/CSS", AUTHOR));
        repository.insert(new Course(5, "Angular", AUTHOR));
        repository.insert(new Course(6, "Docker", AUTHOR));

        repository.deleteById(5);

        log.info(repository.findById(4L).toString());
        log.info(repository.findById(6L).toString());
    }
}
