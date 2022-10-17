package com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SpringDataJpaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseSpringDataJpaRepository repository;

    private static final String AUTHOR= "in28minutes";

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(7, "Bootstrap", AUTHOR));
        repository.save(new Course(8, "NodeJS", AUTHOR));
        repository.save(new Course(9, "Maven", AUTHOR));

        repository.deleteById(9L);

        log.info(repository.findById(7L).toString());
        log.info(repository.findById(8L).toString());

        log.info(repository.findAll().toString());
        log.info(String.valueOf(repository.count()));

        log.info(repository.findByAuthor("in28minutes").toString());
        log.info(repository.findByName("Bootstrap").toString());
    }
}
