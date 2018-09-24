/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wmhr.conferences.interfaces;

import com.wmhr.conferences.Event;

/**
 *
 * @author wm_herrera
 */
public interface ITrack { 

    void addEvent(Event event);
    void print();
}
