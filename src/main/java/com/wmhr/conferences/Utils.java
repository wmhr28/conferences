/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wmhr.conferences;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 *
 * @author wm_herrera
 */
public class Utils {

    /**
     * Convert TemporalAccessor to string format AM/PM
     *
     * @param tmpAccessor
     * @return String
     */
    public static String timeFormat12h(TemporalAccessor tmpAccessor) {
        return DateTimeFormatter.ofPattern("hh:mma").format(tmpAccessor);
    }

    /**
     * Replace all character non digits from string, and extract numbers
     *
     * @param input
     * @return int
     */
    public static int extractNumber(String input) {
        String ret = "0";
        String extract = input.replaceAll("\\D", "");
        if (!extract.equals("")) {
            ret = extract;
        }
        return Integer.parseInt(ret);
    }
}
