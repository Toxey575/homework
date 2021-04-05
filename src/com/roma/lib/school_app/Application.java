package com.roma.lib.school_app;

public class Application {
    public static void main(String[] args) {

        School school = new School();

        school.getPrincipal().startDay(school.getTeachers(), school.getApprentices());

        System.out.println(school);

        // Как интерфейсами пользоваться не разобрался

    }
}
