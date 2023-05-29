package com.example.demo_.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "s_cards")
public class SCard implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_out")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOut;

    @Column(name = "date_in")
    private Date dateIn;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "lib_id", nullable = false)
    private Librarian librarian;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

}


