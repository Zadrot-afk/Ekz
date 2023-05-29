package com.example.demo_.services;

import com.example.demo_.dao.identity.IRoleRepository;
import com.example.demo_.dao.identity.IUserRepository;
import com.example.demo_.models.Identity.AppRole;
import com.example.demo_.models.Identity.AppUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class AppUserService implements UserDetailsService {
@PersistenceContext
    private EntityManager entityManager;
@Autowired
IUserRepository userRepository;
@Autowired
IRoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder _passEncoder;

    public void UserService() {
        _passEncoder = new BCryptPasswordEncoder();
    }



    public boolean registerUser(AppUser user){
        try{
            user.setUsername(user.getUsername());

            user.setPassword(_passEncoder.encode(user.getPassword()));
            user.setRoles(Collections.singleton(roleRepository.findByName("USER")));
            user.setPasswordComfirm(user.getPassword());
            user.setRoles(Collections.singleton(roleRepository.findByName("USER")));
            userRepository.save(user);
            return true;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByName(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("User not found");

        }
        return user;
    }
    public AppUser findUserById(Long id)
    {
        Optional<AppUser> user = userRepository.findById(id);
        return user.orElse(new AppUser());
    }
    public Iterable<AppUser> allUsers()
    {
        return userRepository.findAll();
    }

    public boolean saveUser(AppUser user)
    {

        AppUser userFromDatabase = userRepository.findByName(user.getUsername());
        if(userFromDatabase != null)
        {
            return false;
        }
        user.setRoles(Collections.singleton(new AppRole(1L,"ROLE_USER")));
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long id)
    {
        if(userRepository.existsById(id))
        {
            userRepository.deleteById(id);
            return true;
        }

        return false;
    }
    public List<AppUser> getUsers_GT(Long minId)
    {
        return entityManager.createQuery("SELECT u FROM AppUser u WHERE u.id > :param", AppUser.class)
                .setParameter("param",minId).getResultList();
    }
}
