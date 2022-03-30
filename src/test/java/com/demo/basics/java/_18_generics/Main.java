package com.demo.basics.java._18_generics;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

public class Main {
    public static void main(String[] args) {
        List<Building> buildingList = new ArrayList<>();
        buildingList.add(new Building("b1"));
        buildingList.add(new Building("b1"));
        printBuilding(buildingList);

        List<Office> officeList = new ArrayList<>();
        officeList.add(new Office("o1"));
        officeList.add(new Office("o1"));
        printBuilding(officeList);
        System.out.println();

        addHouseToList(buildingList);
        printBuilding(buildingList);
    }

    public static void printBuilding(List<? extends Building> buildings) {
        for (int i = 0; i < buildings.size(); i++) {
            System.out.println(buildings.get(i).toString());
        }
    }

    public static void addHouseToList(List<? super Home> buildings) {
        buildings.add(new Home("h1"));
    }
}

@AllArgsConstructor
class Building {
    String name;

    @Override
    public String toString() {
        return "building : " + name;
    }
}

class Office extends Building {
    public Office(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "office :" + name;
    }
}

class Home extends Building {
    public Home(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "home: " + name;
    }
}
