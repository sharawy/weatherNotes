/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.weatherNotes.repositories;

import com.weatherNotes.models.User;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abdo
 */
@Repository
public interface UserRepoistory extends HibernateRepository<User,Integer>{
    /**
     * This method is used to get a user by userName
     *
     * @param userName This is the username of user
     * @return User object.
     */
    User findByUserName(String userName);
     /**
   * This method is used to get a user  by email
   * 
   * @param email This is the email of user
   * @return User object.
   */
    User findByEmail(String email);
      /**
   * This method is used to get a user  by email
   *  and password
   * @param email This is the email of user
   * @param password This is the password of user
   * @return User object.
   */
    User findByEmailAndPassword(String email,String password);
}
