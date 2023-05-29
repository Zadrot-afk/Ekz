package com.example.demo_.dao.identity;

import com.example.demo_.models.Identity.AppRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepository extends CrudRepository<AppRole, Long> {
    @Query("SELECT r FROM AppRole r where r.name = :name")
    AppRole findByName(String name);
}
