/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wmhr.conferences;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import java.time.LocalTime;

import org.junit.Test;

/**
 *
 * @author wm_herrera
 */
public class UtilsTest {

    @BeforeClass
    public static void init() {
        System.out.println("Start unit test");
    }

    @Test
    public void extractTest1() {        
        System.out.println("Extract Number Function");
        System.out.println("1.- input 'Writing Fast Tests Against Enterprise Rails 60min' return 60");
        assertThat(Utils.extractNumber("Writing Fast Tests Against Enterprise Rails 60min"), equalTo(60));
    }

    @Test
    public void extractTest2() {
        System.out.println("2.- input with space 'Writing Fast Tests Against Enterprise Rails 60 min' return 60");
        assertThat(Utils.extractNumber("Writing Fast Tests Against Enterprise Rails 60 min"), equalTo(60));
    }

    @Test
    public void extractTest3() {
        System.out.println("3.- input with 2 numbers 'a45s66' return 4566");
        assertThat(Utils.extractNumber("a45s66"), equalTo(4566));
    }

    @Test
    public void extractTest4() {
        System.out.println("4.- input only numbers '34' return 34");
        assertThat(Utils.extractNumber("34"), equalTo(34));
    }

    @Test
    public void extractTest5() {
        System.out.println("5.- input only letters 'abc' return 0");
        assertThat(Utils.extractNumber("abc"), equalTo(0));
    }
    @Test
    public void timeFormatTest1() {
        System.out.println("Extract Time Format 12H Function");
        System.out.println("6.- input test 1 return 09:00AM");
        assertThat(Utils.timeFormat12h(LocalTime.of(9, 0)), equalTo("09:00AM"));
    }
    @Test
    public void timeFormatTest2() { 
        System.out.println("7.- input test 2 return 12:30PM");
        assertThat(Utils.timeFormat12h(LocalTime.of(12, 30)), equalTo("12:30PM"));
    }
}
