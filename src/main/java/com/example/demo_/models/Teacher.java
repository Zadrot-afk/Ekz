package com.example.demo_.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Table(name = "teachers", indexes = {
        @Index(name = "first_name_index", columnList = "first_name"),
        @Index(name = "last_name_index", columnList = "last_name"),
        @Index(name = "full_name_index", columnList = "first_name, last_name"),
})
public class Teacher implements Serializable {

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

    @ManyToOne
    @Setter
    @JoinColumn(name = "department_id", nullable = true)
    private Department department;

    @OneToMany(mappedBy = "teacher")
    private Set<TCard> tCards;
}

