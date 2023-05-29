package com.example.demo_.models.Identity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Getter
@Table(name = "t_role")
public class AppRole implements GrantedAuthority {
    @Id
    @Column(name = "id")
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Setter
    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "roles")
    Set<AppUser> users;

    @Override
    public String getAuthority() {
        return getName();
    }
    public AppRole() {

    }
    public AppRole(Long id) {
        this.id = id;
    }
    public AppRole(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
