/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weatherNotes.conf.security;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;


public class LoginAuthorizationFilter extends AbstractAuthenticationProcessingFilter {

    public LoginAuthorizationFilter() {
        super("/Performlogin"); // allow any request to contain an authorization header
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        HttpServletRequest request = (HttpServletRequest) req;
        //provide our custom token
       return new NormalAuthorizationToken(request.getParameter("email"),request.getParameter("password"));
        
    } 
}
