package com.roma.lib.catmouse.utils;

public class Random {

    public static String nameGen () {
        String[] firstHalf = {"Кис", "Мур", "Бус", "Кош", "Боб", "Шар", "Пер", "Дур", "Пуш", "Вор"};
        String[] secondHalf = {"ик", "чик", "юга", "улькен", "зилла", "ка", "ок", "уля", "ан", ""};
        return (firstHalf[(int) (Math.random() * 10)] + secondHalf[(int) (Math.random() * 10)]);
    }

    public static String colorGen() {
        String[] color = {"Красный", "Синий", "Зеленый", "Черный", "Белый", "Коричневый", "Филюлетовый", "Серый", "Желтый", "Розовый"};
        return color[(int) (Math.random() * 10)];
    }

    public static int speedGen() {
        return (20 + (int) (Math.random() * 80));
    }

    public static int wightGen() {
        return (10 + (int) (Math.random() * 40));
    }





}
