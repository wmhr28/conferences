/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wmhr.conferences;

import java.time.LocalTime;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

import org.junit.Test;

/**
 *
 * @author wm_herrera
 */
public class EventTest {

    @BeforeClass
    public static void init() {
        System.out.println("Start event test");
    }

    @Test
    public void constructTest1() {
        System.out.println("Construct Event Normal");
        System.out.println("1.- set title 'Writing Fast Tests Against Enterprise Rails 30min' get 30 minutes ");
        Event obj = new Event("Writing Fast Tests Against Enterprise Rails 30min");
        assertThat(obj.getMinutes(), equalTo(30));
    }

    @Test
    public void constructTest2() {
        System.out.println("2.- Construct Event Lunch get 60 minutes ");
        Event obj = new Event(Event.LUNCH_NAME);
        assertThat(obj.getMinutes(), equalTo(60));
        assertThat(obj.isLunch(), equalTo(true));
    }

    @Test
    public void constructTest3() {
        System.out.println("3.- Construct Event Networking get 0 minutes ");
        Event obj = new Event(Event.NETWORKING_NAME);
        assertThat(obj.getMinutes(), equalTo(0));
        assertThat(obj.isNetworking(), equalTo(true));
    }

    @Test
    public void constructTest4() {
        System.out.println("4.- set title 'Rails for Python Developers lightning' get 5 minutes ");
        Event obj = new Event("Rails for Python Developers lightning");
        assertThat(obj.getMinutes(), equalTo(5));
        assertThat(obj.isLunch(), equalTo(false));
        assertThat(obj.isNetworking(), equalTo(false));
    }

    @Test
    public void getEndTimeTest1() {
        System.out.println("5.- set start time 09:00AM and event lightning get '09:05AM' ");
        Event obj = new Event("Rails for Python Developers lightning");
        obj.setStartTime(LocalTime.of(9, 0));
        assertThat(obj.getEndTime(), equalTo(LocalTime.of(9, 5)));
    }

    @Test
    public void getEndTimeTest2() {
        System.out.println("6.- set title 'Writing Fast Tests Against Enterprise Rails 30min' get '09:30AM' ");
        Event obj = new Event("Writing Fast Tests Against Enterprise Rails 30min");
        obj.setStartTime(LocalTime.of(9, 0));
        assertThat(obj.getEndTime(), equalTo(LocalTime.of(9, 30)));
    }

    @Test
    public void consoleFormatTest1() {
        System.out.println("7.- set title 'Writing Fast Tests Against Enterprise Rails 30min' get '09:00AM Writing Fast Tests Against Enterprise Rails 30min'");
        Event obj = new Event("Writing Fast Tests Against Enterprise Rails 30min");
        obj.setStartTime(LocalTime.of(9, 0));
        assertThat(obj.consoleFormat(), equalTo("09:00AM Writing Fast Tests Against Enterprise Rails 30min"));
    }

    @Test
    public void consoleFormatTest2() {
        System.out.println("8.- set title 'Writing Fast Tests Against Enterprise Rails 30min' get '09:00AM Writing Fast Tests Against Enterprise Rails 30min'");
        Event obj = new Event("Writing Fast Tests Against Enterprise Rails 30min");
        obj.setStartTime(LocalTime.of(12, 0));
        assertThat(obj.consoleFormat(), equalTo("12:00PM Writing Fast Tests Against Enterprise Rails 30min"));
    }

}
