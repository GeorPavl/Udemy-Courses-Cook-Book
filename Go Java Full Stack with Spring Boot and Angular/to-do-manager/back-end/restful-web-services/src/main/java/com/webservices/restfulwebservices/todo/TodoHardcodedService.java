package com.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static final List<Todo> todos = new ArrayList<>();

    private static Long idCounter = 0L;
    
    private static final String USERNAME ="geor";

    static {
        todos.add(new Todo(++idCounter, USERNAME, "Learn to Dance", new Date(), false));
        todos.add(new Todo(++idCounter, USERNAME, "Learn about Microservices", new Date(), false));
        todos.add(new Todo(++idCounter, USERNAME, "Learn about Angular", new Date(), false));
    }

    public List<Todo> findAll(){
        return todos;
    }

    public Todo save(Todo todo) {
        if (todo.getId() == -1 || todo.getId() == 0) {
            todo.setId(++idCounter);
        } else {
            deleteById(todo.getId());
        }
        todos.add(todo);
        return todo;
    }

    public Todo deleteById(long id) {
        Todo todo = findById(id);

        if (todo==null) return null;

        if (todos.remove(todo)) {
            return todo;
        }

        return null;
    }

    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
}
