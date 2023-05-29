package com.example.demo_.dao;

import com.example.demo_.models.Category;
import com.example.demo_.models.Press;
import com.example.demo_.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category, Long> {

}
