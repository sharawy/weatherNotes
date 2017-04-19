/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weatherNotes.conf.security;

import com.weatherNotes.models.User;
import com.weatherNotes.services.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Component
public class NormalAuthenticationProvider extends CustomAuthentication {

    @Autowired
    UserService userServiceImpl;


    @Autowired
    ApplicationContext messageContext;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        NormalAuthorizationToken auth = (NormalAuthorizationToken) authentication;
        HttpSession session = session();
        User user = userServiceImpl.findUserByEmail(auth.getEmail());
        if (user == null || !user.getPassword().equals(auth.getPassword())) {
            session.setAttribute("msg", messageContext.getMessage("login.invalidEmailOrPassword", null,null
            ));
            throw new BadCredentialsException("Invalid email or password");
        }
        
       
        return authenticate(user, auth);
    }


    public static HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true); // true == allow create
    }

    @Override
    public boolean supports(Class<?> authentication) {
        if (authentication.isAssignableFrom(NormalAuthorizationToken.class)) {
            return true;
        }
        return false;
    }

}
