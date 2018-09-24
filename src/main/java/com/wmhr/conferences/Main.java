/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wmhr.conferences;

import java.time.*;
import java.util.Scanner;

/**
 *
 * @author wm_herrera
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file path: ");
        String filePath = scanner.next();
        
        Conference conf = new Conference(LocalTime.of(9, 0), LocalTime.of(12, 0), LocalTime.of(13, 0), LocalTime.of(17, 0));
        conf.loadEventsFromFile(filePath);
        conf.buildSchedule();
        conf.print();
        
        
        
        //String filePath = "C:\\Users\\wm_herrera\\Documents\\NetBeansProjects\\conferences\\src\\main\\resources\\conference1.txt";
        //String filePath = "C:\\Users\\wm_herrera\\Documents\\NetBeansProjects\\conferences\\src\\main\\resources\\conference2.txt";
        //String filePath = "C:\\Users\\wm_herrera\\Documents\\NetBeansProjects\\conferences\\src\\main\\resources\\conference3.txt";
    }

}
