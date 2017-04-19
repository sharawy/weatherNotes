/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weatherNotes.conf.security;


import com.weatherNotes.models.User;
import com.weatherNotes.models.UserRole;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 *
 * @author abdalrahman.sharawy
 */
public abstract class CustomAuthentication implements AuthenticationProvider {

    /**
     * authenticate user
     * @param user
     * @param auth
     * @return UsernamePasswordAuthenticationToken
     */
    protected UsernamePasswordAuthenticationToken authenticate(User user, AbstractAuthenticationToken auth) {
        Collection<? extends GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
        UsernamePasswordAuthenticationToken authenticted = new UsernamePasswordAuthenticationToken(user.getUserName(), auth.getCredentials(), authorities);
       
        
        authenticted.setDetails(user);
        
        return authenticted;
    }

//
    private List<GrantedAuthority> buildUserAuthority(UserRole userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<>();
       
        setAuths.add(new SimpleGrantedAuthority(userRoles.getUserRoleName()));
   
        List<GrantedAuthority> Result = new ArrayList<>(setAuths);

        return Result;
    }
}
