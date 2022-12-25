package com.someshium.springsecuritylearning.service;

import com.someshium.springsecuritylearning.entity.User;
import com.someshium.springsecuritylearning.repository.UserRepository;
import com.someshium.springsecuritylearning.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JPAUserDetailsService implements UserDetailsService {


    private final UserRepository userRepository;

    public JPAUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)  {
           Optional<User>  u =  userRepository.findUserByUsername(username);
        return u.map(SecurityUser::new)
                .orElseThrow(() ->  new UsernameNotFoundException("Username not found"));
    }
}
