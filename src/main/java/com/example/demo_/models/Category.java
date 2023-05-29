package com.example.demo_.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Table(name = "categories", indexes = {
        @Index(name = "name_index", columnList = "name", unique = true)
})
public class Category implements Serializable {
    @Id
    @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Book> books;


}


