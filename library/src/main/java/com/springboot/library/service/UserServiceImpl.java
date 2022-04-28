package com.springboot.library.service;

import com.springboot.library.entity.User;
import com.springboot.library.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(){}

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> result = userRepository.findById(id);
        User user=null;
        if(result.isPresent()) { user=result.get(); }
        else{ throw new RuntimeException("Did not find User of id - "+id); }
        return user;
    }

    @Override
    public void save(User user) {
        System.out.println("User Service ==> "+user.toString());
        userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
