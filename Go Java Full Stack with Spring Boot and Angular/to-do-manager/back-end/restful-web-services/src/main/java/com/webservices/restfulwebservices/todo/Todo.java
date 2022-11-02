package com.webservices.restfulwebservices.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String description;

    private Date targetDate;

    private boolean isDone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo todo)) return false;
        return getId() == todo.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
