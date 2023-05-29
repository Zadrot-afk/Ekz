package com.example.demo_.models.Identity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name = "t_user", indexes = {
        @Index(name = "first_name_index", columnList = "username")
})
public class AppUser implements UserDetails {
    @Id
    @Column(name = "id")
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Setter
    @Getter
    @Column(name = "username", length = 64, nullable = false)
    private String username;
    @Setter
    @Getter
    @Column(name = "password", length = 64, nullable = false)
    private String password;

    public void setRoles(Set<AppRole> roles) {
        this.roles = roles;
    }

    @Transient
    String passwordComfirm;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="users_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    Set<AppRole> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
