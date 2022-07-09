package com.anup.springbootsecuritymysqltutorial.controller;

import com.anup.springbootsecuritymysqltutorial.entity.User;
import com.anup.springbootsecuritymysqltutorial.models.MyUserDetails;
import com.anup.springbootsecuritymysqltutorial.models.MyUserDetailsJPA;
import com.anup.springbootsecuritymysqltutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

     //Below code is used for hard coded User Detais
    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MyUserDetails(username);
    }*/

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
         return new MyUserDetailsJPA(user);
    }


}
