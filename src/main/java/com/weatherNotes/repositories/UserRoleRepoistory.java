/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.weatherNotes.repositories;

import com.weatherNotes.models.UserRole;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abdo
 */
@Repository
public interface UserRoleRepoistory extends HibernateRepository<UserRole, Integer>{
    /**
   * This method is used to get a user role by it's name
   * 
   * @param userRoleName This is the name of role name
   * @return UserRole object.
   */
    public UserRole findByUserRoleName(String userRoleName);
}
