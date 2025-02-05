package com.ecom.orderservice.service;

import com.ecom.orderservice.model.Users;
import com.ecom.orderservice.repository.UserRepo;
import com.ecom.orderservice.security.UserPrinciple;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUserName(username);
        if(user == null){
            log.error("user not found");
            throw new UsernameNotFoundException("user not found");
        }
        return  new UserPrinciple(user);
    }
}
