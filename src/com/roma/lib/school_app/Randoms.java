package com.roma.lib.school_app;

public class Randoms {

    public static String nameGen () {
        String[] name = {"Иван", "Александр", "Борис", "Толик", "Михал Палыч", "Наталья", "Александра", "Раиса", "Валентина", "Зинаида"};
        String[] surname = {"Зайчик", "Белочка", "Жирафик", "Тереньтьев", "Котик", "Попугайчик", "Солнышко", "Человечек", "Огуречик", "Нагнетатель"};
        return (name[(int) (Math.random() * 10)] + " " + surname[(int) (Math.random() * 10)]);
    }

    public static int kidAge() {
        return (7 + (int) (Math.random() * 11));
    }

    public static int adultAge() {
        return (30 + (int) (Math.random() * 30));
    }

    public static String schoolName () {
        return "Школа №" + (1 + (int) (Math.random() * 100));
    }

    public static String subjectGen () {
        String[] subject = {"Математика", "Русский язык", "Литература", "Информатика", "Химия", "Физика", "ИЗО", "Труд", "Музыка", "География"};
        return (subject[(int) (Math.random() * 10)]);
    }






}
