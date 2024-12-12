package com.demo.basics.designpatterns._13_template;

import org.junit.jupiter.api.Test;

public class TemplatePatternTest {

    @Test
    public void test() {
        HouseTemplate houseType = new WoodenHouse();
        houseType.buildHouse();
        System.out.println();
        houseType = new GlassHouse();
        houseType.buildHouse();
    }
}

class GlassHouse extends HouseTemplate {

    @Override
    public void buildWalls() {
        System.out.println("Building Glass Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Glass Support Beams");
    }
}

class WoodenHouse extends HouseTemplate {

    @Override
    public void buildWalls() {
        System.out.println("Building Wooden Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Wood Pillars");
    }

}

abstract class HouseTemplate {

    /**
     * template method, final so subclasses can't override
     */
    public final void buildHouse() {
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("House is built.");
    }

    /**
     * default implementation
     */
    private void buildWindows() {
        System.out.println("Building Glass Windows");
    }

    /**
     * methods to be implemented by subclasses
     */
    public abstract void buildWalls();

    public abstract void buildPillars();

    /**
     * default implementation
     */
    private void buildFoundation() {
        System.out.println("Building foundation with cement,iron & sand");
    }
}
