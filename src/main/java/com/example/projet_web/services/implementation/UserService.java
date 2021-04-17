package com.example.projet_web.services.implementation;

import com.example.projet_web.Model.DTO.UserDTO;
import com.example.projet_web.Model.entities.Coach;
import com.example.projet_web.Model.entities.User;
import com.example.projet_web.repositories.interfaces.IUserRepository;
import com.example.projet_web.services.ICoachService;
import com.example.projet_web.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.ActionMapUIResource;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final ICoachService coachService;
    @Autowired
    public UserService(IUserRepository userRepository, ICoachService coachService) {
        this.coachService = coachService;
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user){
        return userRepository.save(user);
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

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void update(UserDTO userDTO) {
        Optional<User> storedOptional = readOne(userDTO.getUserId());
        if (storedOptional.isPresent()) {
            User stored = storedOptional.get();


            Coach coach = coachService.readOne(userDTO.getCoachId()).get();
            stored.setFirstName(userDTO.getFirstName());
            stored.setLastName(userDTO.getLastName());
            stored.setEmail(userDTO.getEmail());
            stored.setPassword(userDTO.getPassword());
            stored.setGender(userDTO.getGender());
            stored.setCoach(coach);
            userRepository.save(stored);
        }

    }

    @Override
    public User save(UserDTO userDTO) {

            Coach coach = coachService.readOne(userDTO.getCoachId()).get();
            User user = new User();
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setGender(userDTO.getGender());
            user.setCoach(coach);
            System.out.println(userDTO.getLastName());
        return userRepository.save(user);
    }


}
