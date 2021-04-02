package com.roma.lib.catmouse;

import com.roma.lib.library.utils.Random;

import java.lang.reflect.Array;
import java.util.Arrays;

import static com.roma.lib.catmouse.Settings.*;
import static com.roma.lib.library.utils.Random.*;



public class Cat {
    // Кот: имя, цвет, скорость, вес, пойманные мыши;

    private final String name = nameGen();
    private final String color = colorGen();
    private final int speed = speedGen();
    private final int weight = wightGen();
    private Mouse[] catches = new Mouse[MAX_CATCHES];
    private int mouseCount = 0;

    public void catchMouse (Mouse mouse) {
        System.out.println(this.name + " пытается поймать мышку");
        for (int i = 0; i < catches.length; i++) {
            if (this.speed < mouse.speed) {
                System.out.println("Мышка убежала!");
                break;
            }
            if (this.catches[i] == null && this.speed > mouse.speed) {
                System.out.println(this.name + " поймал мышку!");
                this.catches[i] = mouse;
                this.mouseCount++;
                System.out.println("Всего " + this.name + " поймал " + this.mouseCount + " мышек");
                break;
            } else if (this.catches[this.catches.length - 1] != null) {
                System.out.println("Кот поймал максимальное кол-во мышек");
                break;
            }
        }
        System.out.println("---------------------");
    }


    public void hijack (Cat cat) {
        if (this.weight > cat.weight) {
            for (int i = 0, j = 0; i < this.catches.length; i++) {
                //int currentMouse = cat.catches[2].getSpeed();
                if (this.catches[i] == null /*&& this.speed > currentMouse*/) {
                    this.catches[i] = cat.catches[j];
                    j++;
                }
            }
            System.out.println(this.name + " гопнул " + cat.name + " на " + cat.mouseCount + " мышек!");
            this.mouseCount += cat.mouseCount;
            cat.mouseCount = 0;
            cat.catches = new Mouse[100];
        } else if (this.weight == cat.weight) System.out.println("Коты равны и решили дружить");
        else {
            for (int i = 0, j = 0; i < cat.catches.length; i++) {
                //int currentMouse = this.catches[2].getSpeed();;
                if (cat.catches[i] == null /*&& cat.speed > currentMouse*/) {
                    cat.catches[i] = this.catches[j];
                    j++;
                }
            }
            System.out.println(cat.name + " гопнул " + this.name + " на " + this.mouseCount + " мышек!");
            cat.mouseCount += this.mouseCount;
            this.mouseCount = 0;
            this.catches = new Mouse[100];
        }
    }

    // --------------------------------------------------------------

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWeight() {
        return weight;
    }

    public int getCatches(int num) {
        return catches[num].getSpeed();
    }

    @Override
    public String toString() {
        return  "Имя - " + name +
                ", цвет - " + color +
                ", скорость - " + speed +
                ", вес - " + weight +
                ", поймано мышек - " + mouseCount;
    }
}
