package com.example.projet_web.services.implementation;

import com.example.projet_web.Model.entities.User;
import com.example.projet_web.repositories.interfaces.IUserRepository;
import com.example.projet_web.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.ActionMapUIResource;
import java.util.List;
@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> findUserBySubstr(String subStr) {
        return userRepository.findUserBySubstr(subStr) ;
    }
}
