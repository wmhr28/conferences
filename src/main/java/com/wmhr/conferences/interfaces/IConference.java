/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wmhr.conferences.interfaces;

/**
 *
 * @author wm_herrera
 */
public interface IConference {

    void loadEventsFromFile(String filePath);
    void buildSchedule();    
    void print();
}
