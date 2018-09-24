/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wmhr.conferences;

import java.time.LocalTime;
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author wm_herrera
 */
public class ConferenceTest {

    @BeforeClass
    public static void init() {
        System.out.println("Start conference test");
    }

    @Test
    public void constructTest1() {
        System.out.println("Construct conference");
        System.out.println("1.- check count tracks and events");
        Conference obj = new Conference(LocalTime.of(9, 0), LocalTime.of(12, 0), LocalTime.of(13, 0), LocalTime.of(17, 0));
        assertThat(obj.getTracks().size(), equalTo(0));
        assertThat(obj.getAllEvents().size(), equalTo(0));
    }

    @Test
    public void loadEventsTest1() {
        System.out.println("2.- Load events fron file, path 'C:\\Users\\wm_herrera\\Documents\\NetBeansProjects\\conferences\\src\\main\\resources\\conference1.txt' ");
        Conference obj = new Conference(LocalTime.of(9, 0), LocalTime.of(12, 0), LocalTime.of(13, 0), LocalTime.of(17, 0));
        obj.loadEventsFromFile("C:\\Users\\wm_herrera\\Documents\\NetBeansProjects\\conferences\\src\\main\\resources\\conference1.txt");
        assertThat(obj.getTracks().size(), equalTo(0));
        assertThat(obj.getAllEvents().size(), equalTo(19));        
        assertThat(obj.getAllEvents().get(0).getTitle(), equalTo("Writing Fast Tests Against Enterprise Rails 60min"));
        assertThat(obj.getAllEvents().get(0).getMinutes(), equalTo(60));
        obj.buildSchedule();
        assertThat(obj.getTracks().size(), equalTo(2));
        Track t1= obj.getTracks().get(0);
        assertThat(t1.getEvents().size(), equalTo(10));
        assertThat(t1.getEvents().get(0).consoleFormat(), equalTo("09:00AM Writing Fast Tests Against Enterprise Rails 60min"));     
        assertThat(t1.getEvents().get(1).consoleFormat(), equalTo("10:00AM Communicating Over Distance 60min"));     
        assertThat(t1.getEvents().get(2).consoleFormat(), equalTo("11:00AM Rails Magic 60min"));    
        assertThat(t1.getEvents().get(3).consoleFormat(), equalTo("12:00PM Lunch"));    
        assertThat(t1.getEvents().get(9).consoleFormat(), equalTo("05:00PM Networking Event")); 
        Track t2= obj.getTracks().get(1);
        assertThat(t2.getEvents().size(), equalTo(13));
        assertThat(t2.getEvents().get(0).consoleFormat(), equalTo("09:00AM Common Ruby Errors 45min"));     
        assertThat(t2.getEvents().get(1).consoleFormat(), equalTo("09:45AM Accounting-Driven Development 45min"));     
        assertThat(t2.getEvents().get(2).consoleFormat(), equalTo("10:30AM Pair Programming vs Noise 45min"));    
        assertThat(t2.getEvents().get(4).consoleFormat(), equalTo("12:00PM Lunch"));    
        assertThat(t2.getEvents().get(12).consoleFormat(), equalTo("05:00PM Networking Event"));   
        

 
    }
    
    @Test
    public void loadEventsTest2() {
        System.out.println("3.- Load events fron file, path 'C:\\Users\\wm_herrera\\Documents\\NetBeansProjects\\conferences\\src\\main\\resources\\conference2.txt' ");
        Conference obj = new Conference(LocalTime.of(9, 0), LocalTime.of(12, 0), LocalTime.of(13, 0), LocalTime.of(17, 0));
        obj.loadEventsFromFile("C:\\Users\\wm_herrera\\Documents\\NetBeansProjects\\conferences\\src\\main\\resources\\conference2.txt");
        assertThat(obj.getTracks().size(), equalTo(0));
        assertThat(obj.getAllEvents().size(), equalTo(19));
        assertThat(obj.getAllEvents().get(0).getTitle(), equalTo("Writing Fast Tests Against Enterprise Rails 55min"));
        assertThat(obj.getAllEvents().get(0).getMinutes(), equalTo(55));
        obj.buildSchedule();
        
        assertThat(obj.getTracks().size(), equalTo(2));
        Track t1= obj.getTracks().get(0);
        assertThat(t1.getEvents().size(), equalTo(11));
        assertThat(t1.getEvents().get(0).consoleFormat(), equalTo("09:00AM Communicating Over Distance 60min"));     
        assertThat(t1.getEvents().get(1).consoleFormat(), equalTo("10:00AM Rails Magic 60min"));     
        assertThat(t1.getEvents().get(2).consoleFormat(), equalTo("11:00AM Ruby on Rails: Why We Should Move On 60min"));    
        assertThat(t1.getEvents().get(3).consoleFormat(), equalTo("12:00PM Lunch"));    
        assertThat(t1.getEvents().get(10).consoleFormat(), equalTo("05:00PM Networking Event")); 
        Track t2= obj.getTracks().get(1);
        assertThat(t2.getEvents().size(), equalTo(12));
        assertThat(t2.getEvents().get(0).consoleFormat(), equalTo("09:00AM Common Ruby Errors 45min"));     
        assertThat(t2.getEvents().get(1).consoleFormat(), equalTo("09:45AM Accounting-Driven Development 45min"));     
        assertThat(t2.getEvents().get(2).consoleFormat(), equalTo("10:30AM Pair Programming vs Noise 45min"));    
        assertThat(t2.getEvents().get(4).consoleFormat(), equalTo("12:00PM Lunch"));    
        assertThat(t2.getEvents().get(11).consoleFormat(), equalTo("05:00PM Networking Event"));  
         
    }
    
    @Test
    public void loadEventsTest3() {
        System.out.println("4.- Load events fron file, path 'C:\\Users\\wm_herrera\\Documents\\NetBeansProjects\\conferences\\src\\main\\resources\\conference3.txt' ");
        Conference obj = new Conference(LocalTime.of(9, 0), LocalTime.of(12, 0), LocalTime.of(13, 0), LocalTime.of(17, 0));
        obj.loadEventsFromFile("C:\\Users\\wm_herrera\\Documents\\NetBeansProjects\\conferences\\src\\main\\resources\\conference3.txt");
        assertThat(obj.getTracks().size(), equalTo(0));
        assertThat(obj.getAllEvents().size(), equalTo(5));
        assertThat(obj.getAllEvents().get(1).getTitle(), equalTo("Overdoing it in Python 5min"));
        assertThat(obj.getAllEvents().get(1).getMinutes(), equalTo(5));  
        obj.buildSchedule();
        
        assertThat(obj.getTracks().size(), equalTo(1));
        Track t1= obj.getTracks().get(0);
        assertThat(t1.getEvents().size(), equalTo(7));
        assertThat(t1.getEvents().get(0).consoleFormat(), equalTo("09:00AM Writing Fast Tests Against Enterprise Rails 55min"));     
        assertThat(t1.getEvents().get(1).consoleFormat(), equalTo("09:55AM Common Ruby Errors 45min"));     
        assertThat(t1.getEvents().get(2).consoleFormat(), equalTo("10:40AM Pair Programming vs Noise 45min"));    
        assertThat(t1.getEvents().get(5).consoleFormat(), equalTo("12:00PM Lunch"));    
        assertThat(t1.getEvents().get(6).consoleFormat(), equalTo("05:00PM Networking Event"));  
        
        

 
    } 
}
