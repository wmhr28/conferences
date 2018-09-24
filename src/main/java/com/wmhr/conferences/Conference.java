/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wmhr.conferences;

import com.wmhr.conferences.interfaces.IConference;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author wm_herrera
 */
public class Conference implements IConference {

    private final LocalTime startTime;
    private final LocalTime startLunchTime;
    private final LocalTime endLunchTime;
    private final LocalTime endTime;
    private List<Event> allEvents;
    private List<Track> tracks;

    /**
     * Construct conference object
     *
     * @param startTime
     * @param startLunchTime
     * @param endLunchTime
     * @param endTime
     */
    public Conference(LocalTime startTime, LocalTime startLunchTime, LocalTime endLunchTime, LocalTime endTime) {
        this.startTime = startTime;
        this.startLunchTime = startLunchTime;
        this.endLunchTime = endLunchTime;
        this.endTime = endTime;
        this.tracks = new ArrayList<>();
        this.allEvents = new ArrayList<>();
    }

    public List<Event> getAllEvents() {
        return allEvents;
    }

    public List<Track> getTracks() {
        return tracks;
    }
    /**
     * Load event objects from a txt file
     *
     * @param filePath
     */
    @Override
    public void loadEventsFromFile(String filePath) {
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            this.allEvents = stream
                    .map(line -> new Event(line))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Build the conference assigning the sessions to each track, according to
     * the established schedules
     */
    @Override
    public void buildSchedule() {
        int trackNumber = 0;
        while (!this.allEvents.isEmpty()) {
            trackNumber++;
            Track objTrack = new Track("Track" + trackNumber, this.startTime, this.startLunchTime, this.endLunchTime, this.endTime);

            /* Start assignment in the morning*/
            boolean canAssign = true;
            while (canAssign) {
                //get free minutes 
                int freeMinutes = objTrack.getMinutesFreeMorning();
                //get the optimal events to fill the space
                List<Event> eventsScoring = this.allEvents.stream()
                        .filter(e -> freeMinutes - e.getMinutes() >= 0)
                        .sorted(Comparator.comparing(Event::getMinutes).reversed())
                        .collect(Collectors.toList());

                if (!eventsScoring.isEmpty()) {
                    Event selEvent = eventsScoring.get(0);
                    objTrack.addEventMorning(selEvent);
                    this.allEvents.remove(selEvent);
                } else {
                    canAssign = false;
                }
            }

            /* End assignment in the morning*/
            // create Lunch Event
            Event lunchEvent = new Event(Event.LUNCH_NAME);
            objTrack.addEventMorning(lunchEvent);

            /* Start assignment in the afternoon*/
            canAssign = true;
            while (canAssign) {
                //get free minutes 
                int freeMinutes = objTrack.getMinutesFreeAfternoon();
                //get the optimal events to fill the space
                List<Event> eventsScoring = this.allEvents.stream()
                        .filter(e -> freeMinutes - e.getMinutes() >= 0)
                        .sorted(Comparator.comparing(Event::getMinutes).reversed())
                        .collect(Collectors.toList());

                if (!eventsScoring.isEmpty()) {
                    Event selEvent = eventsScoring.get(0);
                    objTrack.addEventAfternoon(selEvent);
                    this.allEvents.remove(selEvent);
                } else {
                    canAssign = false;
                }
            }

            /* Start assignment in the afternoon*/
            // create Networking Event
            Event netEvent = new Event(Event.NETWORKING_NAME);
            objTrack.addEventAfternoon(netEvent);

            this.tracks.add(objTrack);
        }

    }

    /**
     * Print all tracks
     */
    @Override
    public void print() {
        this.tracks.forEach((track) -> {
            track.print();
        });
    }

}
