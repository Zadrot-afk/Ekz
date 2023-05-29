package com.example.demo_.dao;

import com.example.demo_.models.Book;
import com.example.demo_.models.Department;
import com.example.demo_.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepository extends CrudRepository<Student, Long> {

}


