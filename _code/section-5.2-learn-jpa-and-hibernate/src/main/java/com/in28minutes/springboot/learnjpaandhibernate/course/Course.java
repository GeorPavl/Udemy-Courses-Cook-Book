package com.in28minutes.springboot.learnjpaandhibernate.course;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course {

    private long id;
    private String name;
    private String author;
}
