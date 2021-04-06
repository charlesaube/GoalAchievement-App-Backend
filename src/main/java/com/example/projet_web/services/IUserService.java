package com.example.projet_web.services;

import com.example.projet_web.Model.entities.User;

import java.util.List;

public interface IUserService {
    List<User> findUserBySubstr(String subStr);

}
