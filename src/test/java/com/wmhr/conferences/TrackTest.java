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
public class TrackTest {

    @BeforeClass
    public static void init() {
        System.out.println("Start track test");
    }

    @Test
    public void constructTest1() {
        System.out.println("Construct track");
        System.out.println("1.- check the allocation time is equal to start time  ");
        Track obj = new Track("Track1", LocalTime.of(9, 0), LocalTime.of(12, 0), LocalTime.of(13, 0), LocalTime.of(17, 0));
        assertThat(obj.getAllocationTime(), equalTo(LocalTime.of(9, 0)));
    }

    @Test
    public void constructTest2() {
        System.out.println("2.- check free minutes on the morning and fternoon session, return 180 and 240 minutes ");
        Track obj = new Track("Track1", LocalTime.of(9, 0), LocalTime.of(12, 0), LocalTime.of(13, 0), LocalTime.of(17, 0));
        assertThat(obj.getMinutesFreeMorning(), equalTo(180));
        assertThat(obj.getMinutesFreeAfternoon(), equalTo(240));
    }

    @Test
    public void addEventTest1() {
        System.out.println("3.- add new event to list , return 1 element ");
        Track obj = new Track("Track1", LocalTime.of(9, 0), LocalTime.of(12, 0), LocalTime.of(13, 0), LocalTime.of(17, 0));
        Event event = new Event(Event.LUNCH_NAME);
        obj.addEvent(event);
        assertThat(obj.getEvents().size(), equalTo(1));
        assertThat(obj.getAllocationTime(), equalTo(LocalTime.of(9, 0)));
    }

    @Test
    public void addEventTest2() {
        System.out.println("4.- add new event to morning session ");
        Track obj = new Track("Track1", LocalTime.of(9, 0), LocalTime.of(12, 0), LocalTime.of(13, 0), LocalTime.of(17, 0));
        Event event = new Event("Writing Fast Tests Against Enterprise Rails 30min");
        obj.addEventMorning(event);
        assertThat(obj.getEvents().size(), equalTo(1));
        assertThat(obj.getAllocationTime(), equalTo(LocalTime.of(9, 30)));
    }

    @Test
    public void addEventTest3() {
        System.out.println("5.- add event lunch and new event to afternoon session ");
        Track obj = new Track("Track1", LocalTime.of(9, 0), LocalTime.of(12, 0), LocalTime.of(13, 0), LocalTime.of(17, 0));
        Event lunchEvent = new Event(Event.LUNCH_NAME);
        obj.addEventMorning(lunchEvent);
        Event event = new Event("Writing Fast Tests Against Enterprise Rails 30min");
        obj.addEventAfternoon(event);
        assertThat(obj.getEvents().size(), equalTo(2));
        assertThat(obj.getAllocationTime(), equalTo(LocalTime.of(13, 30)));
    }

    @Test
    public void addEventTest4() {
        System.out.println("6.- add event networking to afternoon session ");
        Track obj = new Track("Track1", LocalTime.of(9, 0), LocalTime.of(12, 0), LocalTime.of(13, 0), LocalTime.of(17, 0));
        Event lunchEvent = new Event(Event.LUNCH_NAME);
        obj.addEventMorning(lunchEvent);
        Event event = new Event("Writing Fast Tests Against Enterprise Rails 30min");
        obj.addEventAfternoon(event);
        Event netEvent = new Event(Event.NETWORKING_NAME);
        obj.addEventAfternoon(netEvent);
        assertThat(obj.getEvents().size(), equalTo(3));
        assertThat(obj.getAllocationTime(), equalTo(LocalTime.of(17, 00)));
    } 

}
