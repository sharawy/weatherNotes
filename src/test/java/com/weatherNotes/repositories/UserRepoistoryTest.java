/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weatherNotes.repositories;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.weatherNotes.conf.ApplicationConfig;
import com.weatherNotes.models.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserRepoistoryTest {

    @Autowired
    UserRepoistory userRepoistory;

    public UserRepoistoryTest() {
    }

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
     * Test of findByUserName method, of class UserRepoistory.
     */
    @Test
    public void testFindByUserName() {
        System.out.println("findByUserName");
        String userName = "admin";
        
        User result = userRepoistory.findByUserName(userName);
      assertNotNull(result);
    }

    /**
     * Test of findByEmail method, of class UserRepoistory.
     */
    @Test
    public void testFindByEmail() {
        System.out.println("findByEmail");
        String email = "admin@weatherNotes.com";
       
        User result = userRepoistory.findByEmail(email);
     assertNotNull(result);
    }

    /**
     * Test of findByEmailAndPassword method, of class UserRepoistory.
     */
    @Test
    public void testFindByEmailAndPassword() {
        System.out.println("findByEmailAndPassword");
        String email = "admin@weatherNotes.com";
        String password = "123456";
        
        User result = userRepoistory.findByEmailAndPassword(email, password);
        assertNotNull(result);
    }

}
