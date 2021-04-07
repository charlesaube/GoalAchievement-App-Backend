package com.example.projet_web.services.implementation;

import com.example.projet_web.Model.entities.User;
import com.example.projet_web.repositories.interfaces.IUserRepository;
import com.example.projet_web.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.ActionMapUIResource;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<User> readOne(long Id) {
        return userRepository.findById(Id);
    }

    @Override
    public List<User> findUserBySubstr(String subStr) {
        return userRepository.findUserBySubstr(subStr) ;
    }

    @Override
    public List<User> findUserByCoachId(Long coachId) {
        return userRepository.findUserByCoachId(coachId);
    }


}
