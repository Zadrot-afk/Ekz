package com.example.demo_.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Table(name = "departments", indexes = {
        @Index(name = "name_index", columnList = "name", unique = true)
})
public class Department implements Serializable {

    @Id
    @Column(name = "id")
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Column(name = "name", length = 64, nullable = false)
    private String name;
    @Setter
    @OneToMany(mappedBy = "department")
    private Set<Teacher> teachers;


}
