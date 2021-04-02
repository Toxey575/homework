package com.roma.lib.catmouse;

import java.util.Arrays;
import java.util.Random;

import static com.roma.lib.library.utils.Random.*;

public class Application {
    public static void main(String[] args) {

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();
        Cat cat6 = new Cat();
        Cat cat7 = new Cat();
        Cat cat8 = new Cat();
        Cat cat9 = new Cat();
        Cat cat10 = new Cat();

        Mouse mouse1 = new Mouse();
        Mouse mouse2 = new Mouse();
        Mouse mouse3 = new Mouse();
        Mouse mouse4 = new Mouse();
        Mouse mouse5 = new Mouse();
        Mouse mouse6 = new Mouse();
        Mouse mouse7 = new Mouse();
        Mouse mouse8 = new Mouse();
        Mouse mouse9 = new Mouse();
        Mouse mouse10 = new Mouse();

        cat1.catchMouse(mouse1);
        cat2.catchMouse(mouse2);
        cat3.catchMouse(mouse3);
        cat4.catchMouse(mouse4);
        cat5.catchMouse(mouse5);
        cat6.catchMouse(mouse6);
        cat7.catchMouse(mouse7);
        cat8.catchMouse(mouse8);
        cat9.catchMouse(mouse9);
        cat10.catchMouse(mouse10);

        cat1.catchMouse(mouse1);
        cat1.catchMouse(mouse2);
        cat1.catchMouse(mouse3);
        cat1.catchMouse(mouse4);
        cat1.catchMouse(mouse5);
        cat1.catchMouse(mouse6);
        cat1.catchMouse(mouse7);
        cat1.catchMouse(mouse8);
        cat1.catchMouse(mouse9);
        cat1.catchMouse(mouse10);

        cat2.catchMouse(mouse1);
        cat2.catchMouse(mouse2);
        cat2.catchMouse(mouse3);
        cat2.catchMouse(mouse4);
        cat2.catchMouse(mouse5);
        cat2.catchMouse(mouse6);
        cat2.catchMouse(mouse7);
        cat2.catchMouse(mouse8);
        cat2.catchMouse(mouse9);
        cat2.catchMouse(mouse10);

        System.out.println(cat1);
        System.out.println(cat2);

        cat1.hijack(cat2);

        System.out.println(cat1);
        System.out.println(cat2);

        System.out.println(mouse1.getSpeed());












    }
}
