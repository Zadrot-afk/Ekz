package com.example.demo_.dao;

import com.example.demo_.models.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ILibrarianRepository extends CrudRepository<Librarian, Long> {

}
