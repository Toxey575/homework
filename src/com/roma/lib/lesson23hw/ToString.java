package com.roma.lib.lesson23hw;

import com.roma.lib.catmouse.Cat;
import com.roma.lib.catmouse.Mouse;
import exams.firstfitness.Client;
import exams.firstfitness.Pass;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class ToString {

    public static void refToString2(Object o) throws IllegalAccessException {
        Class<?> objectClass = o.getClass();
        while (!objectClass.getSimpleName().equals("Object")) {

            Field[] fields = objectClass.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);

                if (field.getType().isArray()) {
                    ArrayList<Object> arrValues = new ArrayList<>();
                    Object[] arrayFields = (Object[]) field.get(o);

                    for (Object arrayFieldValue : arrayFields) {
                        if (arrayFieldValue == null) break;
                        arrValues.add(arrayFieldValue.getClass().getSimpleName());
                    }

                    System.out.println(field.getName() + ": " + arrValues);
                } else {
                    Object infoValObj = field.get(o);
                    System.out.println(field.getName() + ": " + infoValObj);
                }

            }
            objectClass = objectClass.getSuperclass();
        }
    }



    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Monkey monkey = new Monkey();
        for (int i = 0; i < 5; i++) {
            Banana banana = new Banana();
            monkey.getBananas()[i] = banana;
        }

        refToString2(monkey);

    }

}