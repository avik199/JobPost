package com.avik.spring_boot_rest_jobPost.service;

import com.avik.spring_boot_rest_jobPost.model.PrincipalUser;
import com.avik.spring_boot_rest_jobPost.model.User;
import com.avik.spring_boot_rest_jobPost.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("Error 404 no such user exist!!!");
        }

        return new PrincipalUser(user);
    }


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
