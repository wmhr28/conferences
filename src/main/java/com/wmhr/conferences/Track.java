/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wmhr.conferences;

import com.wmhr.conferences.interfaces.ITrack;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.MINUTES;

/**
 *
 * @author wm_herrera
 */
public class Track implements ITrack {

    private final String name;
    private final LocalTime startTime;
    private final LocalTime startLunchTime;
    private final LocalTime endLunchTime;
    private final LocalTime endTime;

    private int minutesFreeMorning;
    private int minutesFreeAfternoon;
    private LocalTime allocationTime;

    private List<Event> events;

    
    /**
     * Construct track object
     *
     * @param name
     * @param startTime
     * @param startLunchTime
     * @param endLunchTime
     * @param endTime
     */
    public Track(String name, LocalTime startTime, LocalTime startLunchTime, LocalTime endLunchTime, LocalTime endTime) {
        this.name = name;
        this.startTime = startTime;
        this.startLunchTime = startLunchTime;
        this.endLunchTime = endLunchTime;
        this.endTime = endTime;
        this.events = new ArrayList<>();
        this.minutesFreeMorning = (int) MINUTES.between(this.startTime, this.startLunchTime);
        this.minutesFreeAfternoon = (int) MINUTES.between(this.endLunchTime, this.endTime);
        this.allocationTime = this.startTime;
    }


    /**
     * Gets the allocation time generated so far 
     * @return LocalTime
     */
    public LocalTime getAllocationTime() {
        return allocationTime;
    }

    /**
     * Get free minutes on the morning session 
     * @return int
     */
    public int getMinutesFreeMorning() {
        return minutesFreeMorning;
    }

    /**
     * Get free minutes on the afternoon session 
     * @return int
     */
    public int getMinutesFreeAfternoon() {
        return minutesFreeAfternoon;
    }

    /**
     * Add new event to list
     * @param event
     */
    @Override
    public void addEvent(Event event) {
        this.events.add(event);
    }

    /**
     * Add new event and calculate free minutes on the morning session
     * @param event
     */
    public void addEventMorning(Event event) {
        event.setStartTime(this.allocationTime);
        if (event.isLunch()) {
            event.setStartTime(this.startLunchTime);
        }
        this.allocationTime = event.getEndTime();
        this.minutesFreeMorning -= event.getMinutes();
        this.addEvent(event);
    }

    /**
     * Add new event and calculate free minutes on the afternoon session
     * @param event
     */
    public void addEventAfternoon(Event event) {
        event.setStartTime(this.allocationTime);
        if (event.isNetworking() && this.allocationTime.getHour()<17) {
            event.setStartTime(this.endTime);
        }
        this.allocationTime = event.getEndTime();
        this.minutesFreeAfternoon -= event.getMinutes();
        this.addEvent(event);
    }

    /**
     * Print all events
     */
    @Override
    public void print() {
        System.out.println(this.name);
        this.events.forEach((event) -> {
            System.out.println(event.consoleFormat());
        });
    }

    /**
     * Get list of all events
     * @return List<>
     */
    public List<Event> getEvents() {
        return events;
    }
   
        

}
