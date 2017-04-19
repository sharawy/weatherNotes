/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weatherNotes.services.impl;

import com.weatherNotes.models.User;
import com.weatherNotes.models.UserRole;
import com.weatherNotes.repositories.UserRepoistory;
import com.weatherNotes.repositories.UserRoleRepoistory;
import com.weatherNotes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdo
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userRepoistory")
    UserRepoistory userRepoistory;
   
    @Autowired
    UserRoleRepoistory userRoleRepoistory;

    @Override
    public User register(User user) {
       
        return userRepoistory.save(user);
    }

    @Override
    public UserRole getUserRoleByName(String userRoleName) {
        return userRoleRepoistory.findByUserRoleName(userRoleName);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepoistory.findByUserName(userName);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepoistory.findByEmail(email);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return userRepoistory.findByEmailAndPassword(email, password);
    }

}
