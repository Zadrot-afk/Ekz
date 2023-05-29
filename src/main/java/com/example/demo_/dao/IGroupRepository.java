package com.example.demo_.dao;

import com.example.demo_.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IGroupRepository extends CrudRepository<Group, Long> {

}
