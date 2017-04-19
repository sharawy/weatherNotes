/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weatherNotes.services;

import com.weatherNotes.models.User;
import com.weatherNotes.models.UserRole;

/**
 *
 * @author abdo
 */
public interface UserService {

    /**
     * this method is used to register new user
     *
     * @param user
     * @return User
     */
    User register(User user);

    /**
     * this method is used to get user by it's username value
     *
     * @param userName
     * @return User
     */
    User findUserByUserName(String userName);

    /**
     * this method is used to user by email
     *
     * @param email
     * @return User
     */
    User findUserByEmail(String email);

    /**
     *this method is used to user by email and password
     * @param email
     * @param password
     * @return User
     */
    User findUserByEmailAndPassword(String email, String password);

    /**
     * this method is used to UserRole by it's name
     * @param userRoleName
     * @return UserRole
     */
    UserRole getUserRoleByName(String userRoleName);
}
