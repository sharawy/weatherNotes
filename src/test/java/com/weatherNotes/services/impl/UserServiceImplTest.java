/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weatherNotes.services.impl;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.weatherNotes.common.Defines;
import com.weatherNotes.conf.ApplicationConfig;
import com.weatherNotes.models.User;
import com.weatherNotes.models.UserRole;
import com.weatherNotes.services.UserService;
import com.weatherNotes.services.impl.UserServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abdo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {ApplicationConfig.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class})
@Transactional()
public class UserServiceImplTest {

    @Autowired
    UserService userServiceImpl;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of register method, of class UserServiceImpl.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        User user = new User();
        user.setEmail("user@weatherNotes.com");
        user.setMobile("12345678901");
        user.setPassword("123456");
        user.setUserName("user");
        UserRole userRole = new UserRole();
        userRole.setUserRoleName(Defines.UserRoles.USER);
        user.setUserRole(userRole);
        User result = userServiceImpl.register(user);
        assertNotNull(result);

    }

    /**
     * Test of getUserRoleByName method, of class UserServiceImpl.
     */
    @Test
    public void testGetUserRoleByName() {
        System.out.println("getUserRoleByName");
        String userRoleName = "User";

        UserRole result = userServiceImpl.getUserRoleByName(userRoleName);
        assertNotNull(result);
    }

    /**
     * Test of findUserByUserName method, of class UserServiceImpl.
     */
    @Test
    public void testFindUserByUserName() {
        System.out.println("findUserByUserName");

        User result = userServiceImpl.findUserByUserName("admin");

        assertNotNull(result);
    }

    /**
     * Test of findUserByEmail method, of class UserServiceImpl.
     */
    @Test
    public void testFindUserByEmail() {
        System.out.println("findUserByEmail");
        String email = "admin@weatherNotes.com";

        User result = userServiceImpl.findUserByEmail(email);
        assertNotNull(result);
    }

    /**
     * Test of findUserByEmailAndPassword method, of class UserServiceImpl.
     */
    @Test
    public void testFindUserByEmailAndPassword() {
        System.out.println("findUserByEmailAndPassword");
        String email = "admin@weatherNotes.com";
        String password = "123456";
        User result = userServiceImpl.findUserByEmailAndPassword(email, password);
        assertNotNull(result);
    }

}
