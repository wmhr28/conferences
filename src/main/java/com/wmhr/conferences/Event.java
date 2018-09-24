/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wmhr.conferences;

import com.wmhr.conferences.interfaces.IEvent;
import java.time.LocalTime;

/**
 *
 * @author wm_herrera
 */
public class Event implements IEvent {

    private final String title;
    private int minutes;
    private LocalTime startTime;
    private LocalTime endTime;

    public static final String NETWORKING_NAME = "Networking Event";
    public static final String LUNCH_NAME = "Lunch";
    public static final String LIGHNING_NAME = "lightning";


    /**
     * Construct event object and calculate minutes
     *
     * @param title
     */
    public Event(String title) {
        this.title = title;
        if (this.title.equals(LUNCH_NAME)) {
            this.minutes = 60;
        } else {
            calculateMinutes();
            this.startTime = LocalTime.MIN;
            this.endTime = LocalTime.MIN;
        }
    }

    /**
     * Calculate minutes based o title's rules, If lightning = 5 minutes
     */
    private void calculateMinutes() {
        if (this.title.endsWith(LIGHNING_NAME)) {
            this.minutes = 5;
        } else {
            this.minutes = Utils.extractNumber(title);
        }
    }

    /**
     * Set start time and calculate end time
     *
     * @param previousTime
     */
    public void setStartTime(LocalTime previousTime) {
        this.startTime = previousTime;
        this.endTime = previousTime.plusMinutes(this.minutes);
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getMinutes() {
        return minutes;
    }

    public String getTitle() {
        return title;
    }
    

    public boolean isNetworking() {
        return this.title.equals(NETWORKING_NAME);
    }

    public boolean isLunch() {
        return this.title.equals(LUNCH_NAME);
    }

    /**
     * Generate string format required. eg: timeformat AM/PM + space + title
     * return "09:00AM Writing Fast Tests Against Enterprise Rails 60min"
     *
     * @return String
     */
    @Override
    public String consoleFormat() {
        return Utils.timeFormat12h(this.startTime) + " " + this.title;
    }

}
