package com.roma.lib.lesson23hw;

import static com.roma.lib.lesson23hw.Random.*;

public class Monkey extends Mammal {
    private final String color = colorGen();
    private Banana[] bananas = new Banana[10];
    private String[] nums = {"1", "1", "1", "1", "1", "1",};

    public Banana[] getBananas() {
        return bananas;
    }
}
