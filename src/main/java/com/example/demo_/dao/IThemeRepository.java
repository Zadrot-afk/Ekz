package com.example.demo_.dao;

import com.example.demo_.models.Category;
import com.example.demo_.models.Student;
import com.example.demo_.models.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IThemeRepository extends CrudRepository<Theme, Long> {

}
