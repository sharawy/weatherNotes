/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weatherNotes.conf.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class NormalAuthorizationToken extends UsernamePasswordAuthenticationToken {
 
    private String email;
    private String password;
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    
    public NormalAuthorizationToken( String email, String password ) {
     
        super( null, password );
        this.email = email;
        this.password = password;
    }


   

  
}
