package com.rsm.util;

import java.util.Random;

public class RandomContent {

    private static String[] cities = {"St. Petersburg", "Stamford", "Sterling Heights", "Stockton", "Sunnyvale"};
    private static String[] states = {"PA", "NJ"};
    private static Random random = new Random();

    public static String getRandomCity() {
        int number = random.nextInt(cities.length);
        return cities[number];
    }

    public static String getRandomState() {
        int number = random.nextInt(states.length);
        return states[number];
    }
}
