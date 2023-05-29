package com.example.demo_.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Table(name = "authors", indexes = {
        @Index(name = "first_name_index", columnList = "first_name"),
        @Index(name = "last_name_index", columnList = "last_name"),
        @Index(name = "full_name_index", columnList = "first_name, last_name"),
})
public class Author implements Serializable {
    @Id
    @Column(name = "id")
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Setter
    @Column(name = "first_name", length = 64, nullable = false)
    private String FirstName;

    @Setter
    @Column(name = "last_name", length = 64, nullable = false)
    private String LastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;


}
