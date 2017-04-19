/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weatherNotes.services.impl;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.weatherNotes.conf.ApplicationConfig;
import com.weatherNotes.models.PreDefinedNote;
import com.weatherNotes.models.SystemNote;
import com.weatherNotes.services.NotesService;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.database.search.TablesDependencyHelper;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
public class NotesServiceImplTest {
  

    @Autowired
    NotesService notesServiceImpl;
   
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
     * Test of getPreDefinedNoteByTemp method, of class NotesServiceImpl.
     */
    @Test
    public void testGetPreDefinedNoteByTemp() {
        System.out.println("getPreDefinedNoteByTemp");
        Double temp = 20.0;

        PreDefinedNote result = notesServiceImpl.getPreDefinedNoteByTemp(temp);
        assertNotNull(result);

    }

    /**
     * Test of getPreDefinedNote method, of class NotesServiceImpl.
     */
    @Test
    public void testGetPreDefinedNote() {
        System.out.println("getPreDefinedNote");
        Integer id = 1;

        PreDefinedNote result = notesServiceImpl.getPreDefinedNote(id);
        assertNotNull(result);
    }

    /**
     * Test of updateIfnotExistCreatePredefinedNote method, of class
     * NotesServiceImpl.
     */
    @Test
    public void testUpdateIfnotExistCreatePredefinedNote() {
        System.out.println("updateIfnotExistCreatePredefinedNote");
        PreDefinedNote preDefinedNote = new PreDefinedNote();
        preDefinedNote.setMaxTemp(10.0);
        preDefinedNote.setMinTemp(-5.0);
        preDefinedNote.setValue("test value");
        PreDefinedNote result = notesServiceImpl.updateIfnotExistCreatePredefinedNote(preDefinedNote);
        assertNotNull(result);
        assertEquals(result.getMaxTemp(), preDefinedNote.getMaxTemp());
    }

    /**
     * Test of deletePreDefinedNote method, of class NotesServiceImpl.
     */
    @Test
    public void testDeletePreDefinedNote() {
        System.out.println("deletePreDefinedNote");
        PreDefinedNote preDefinedNote = new PreDefinedNote();
        preDefinedNote.setId(1);
        notesServiceImpl.deletePreDefinedNote(preDefinedNote);

    }

    /**
     * Test of getAllSystemNotes method, of class NotesServiceImpl.
     */
    @Test
    public void testGetAllSystemNotes() {
        System.out.println("getAllSystemNotes");
        
        List<SystemNote> result = notesServiceImpl.getAllSystemNotes();
        assertNotNull( result);
        
    }

    /**
     * Test of updateIfnotExistCreateSystemNote method, of class
     * NotesServiceImpl.
     */
    @Test
    public void testUpdateIfnotExistCreateSystemNote() {
        System.out.println("updateIfnotExistCreateSystemNote");
        SystemNote sysNote = new SystemNote();
        
        sysNote.setId(1);
        sysNote.setValue(null);
        SystemNote result = notesServiceImpl.updateIfnotExistCreateSystemNote(sysNote);
      assertNotNull( result);
    }

    /**
     * Test of getSystemNote method, of class NotesServiceImpl.
     */
    @Test
    public void testGetSystemNote() {
        System.out.println("getSystemNote");
        Integer id = 1;
      
        SystemNote result = notesServiceImpl.getSystemNote(id);
        assertNotNull(result);
    }

    /**
     * Test of deleteSysdNote method, of class NotesServiceImpl.
     */
    @Test
    public void testDeleteSysdNote() {
        System.out.println("deleteSysdNote");
        SystemNote sysNote = new SystemNote();
        sysNote.setId(1);
        notesServiceImpl.deleteSysdNote(sysNote);

    }

    /**
     * Test of getSysNoteByDate method, of class NotesServiceImpl.
     */
    @Test
    public void testGetSysNoteByDate() {
        System.out.println("getSysNoteByDate");
        String date = "2017-04-19";
       
        SystemNote result = notesServiceImpl.getSysNoteByDate(date);
        assertNotNull(result);
    }

    /**
     * Test of getAllPredefinedNotes method, of class NotesServiceImpl.
     */
    @Test
    public void testGetAllPredefinedNotes() {
        System.out.println("getAllPredefinedNotes");
       
        List<PreDefinedNote> result = notesServiceImpl.getAllPredefinedNotes();
        assertNotNull( result);

    }

}
