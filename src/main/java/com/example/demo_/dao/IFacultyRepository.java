package com.example.demo_.dao;

import com.example.demo_.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IFacultyRepository extends CrudRepository<Faculty, Long> {

}

