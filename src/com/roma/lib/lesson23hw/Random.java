package com.roma.lib.lesson23hw;

import java.time.LocalDate;

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

    public static int weightGen() {
        return (10 + (int) (Math.random() * 40));
    }

    public static LocalDate dateOfBirthGen() {
        String strDate = null;

        int yGen = 1960 + (int) (Math.random() * 50);
        int mGen = 1 + (int) (Math.random() * 11);
        int dGen = 1 + (int) (Math.random() * 27);

        if (mGen < 10 && dGen < 10) strDate = yGen + "-" + "0" + mGen + "-" + "0" + dGen;
        else if (mGen >= 10 && dGen < 10) strDate = yGen + "-" + mGen + "-" + "0" + dGen;
        else if (mGen < 10 && dGen >= 10) strDate = yGen + "-" + "0" + mGen + "-" + dGen;
        else strDate = yGen + "-" + mGen + "-" + dGen;

        return LocalDate.parse(strDate);

    }

    public static int sizeGen() {
        return (1 + (int) (Math.random() * 9));
    }





}
