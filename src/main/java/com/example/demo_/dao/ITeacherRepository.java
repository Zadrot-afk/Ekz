package com.example.demo_.dao;

import com.example.demo_.models.Librarian;
import com.example.demo_.models.Student;
import com.example.demo_.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ITeacherRepository extends CrudRepository<Teacher, Long> {

}



