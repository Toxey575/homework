package com.roma.lib.lesson23hw;

import static com.roma.lib.lesson23hw.Random.*;

public class Mammal extends Animal {
    private final int weight;
    private final int speed;

    public Mammal() {
        this.weight = weightGen();
        this.speed = speedGen();

    }
}
