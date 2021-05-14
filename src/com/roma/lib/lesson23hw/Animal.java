package com.roma.lib.lesson23hw;

import java.time.LocalDate;

import static com.roma.lib.lesson23hw.Random.*;

public class Animal {
    private final String name;
    private final LocalDate dateOfBirth;

    public Animal() {
        this.name = nameGen();
        this.dateOfBirth = dateOfBirthGen();
    }
}
