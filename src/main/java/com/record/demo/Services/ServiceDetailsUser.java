package com.record.demo.Services;

import com.record.demo.Repository.UserRepository;
import com.record.demo.model.Usercars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class ServiceDetailsUser implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usercars useraux=userRepository.findByUsername(username);
        System.out.println(useraux);
        if(useraux==null){
            System.out.println("error no encontrado");
            throw new UsernameNotFoundException("no se encontro");
        }
        return new User(useraux.getUsername(),useraux.getPassword(), Collections.emptyList());
    }


    public void RegisterUser(Usercars registeruser){
        try{
            userRepository.save(registeruser);
        }catch (Exception e){
            e.getMessage();
        }

    }
}
