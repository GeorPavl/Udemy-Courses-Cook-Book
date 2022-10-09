package com.in28minutes.rest.webservices.restfulwebservices.post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.in28minutes.rest.webservices.restfulwebservices.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"user"})
public class Post {

    @Id
    @GeneratedValue
    private long id;

    @Size(min = 10)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
