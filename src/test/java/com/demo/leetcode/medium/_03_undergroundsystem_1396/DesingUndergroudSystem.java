package com.demo.leetcode.medium._03_undergroundsystem_1396;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [1396. Design Underground System - MEDIUM](https://leetcode.com/problems/design-underground-system/)
 *
 * https://www.youtube.com/watch?v=W5QOLqXskZM&ab_channel=NeetCodeIO
 */
public class DesingUndergroudSystem {

    @Test
    public void test() {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
        undergroundSystem.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
        undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
        Assertions.assertEquals(14.0, undergroundSystem.getAverageTime("Paradise", "Cambridge")); // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
        Assertions.assertEquals(11.0, undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
        undergroundSystem.checkIn(10, "Leyton", 24);
        Assertions.assertEquals(11.0, undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
        Assertions.assertEquals(12.0, undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // return 12.00000. Three trips "Leyton" -> "Waterloo", (10 + 12 + 14) / 3 = 12
    }

    class UndergroundSystem {

        Map<String, Stats> travelMap;
        Map<Integer, Stats> checkinMap;

        public UndergroundSystem() {
            travelMap = new HashMap<>();
            checkinMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            checkinMap.put(id, new Stats(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            String startStation = checkinMap.get(id).startStation;
            int startTime = checkinMap.get(id).startTime;
            int timeTaken = t - startTime;
            String route = startStation + "-" + stationName;
            if (!travelMap.containsKey(route)) {
                travelMap.put(route, new Stats(timeTaken, 1));
            } else {
                int totalTime = travelMap.get(route).totalTime;
                int numOfRoutes = travelMap.get(route).numOfRoutes;
                travelMap.put(route, new Stats(totalTime + timeTaken, numOfRoutes + 1));
            }
        }

        public double getAverageTime(String startStation, String endStation) {
            String route = startStation + "-" + endStation;
            double avg = 0.0;
            if (!travelMap.containsKey(route)) {
                return avg;
            } else {
                avg = travelMap.get(route).totalTime / (double) travelMap.get(route).numOfRoutes;
            }
            return avg;
        }

        class Stats {
            String startStation;
            int startTime;
            int totalTime;
            int numOfRoutes;

            Stats(String startStation, int startTime) {
                this.startStation = startStation;
                this.startTime = startTime;
            }

            Stats(int totalTime, int numOfRoutes) {
                this.totalTime = totalTime;
                this.numOfRoutes = numOfRoutes;
            }
        }
    }
}
