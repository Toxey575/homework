package lesson4;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Homework3 {
    public static void main(String[] args) {

        // 1. Поменять местами минимальный и максимальный элементы
        System.out.println("Задача 1.");

        int len = 10, max, min;
        int[] mass = new int[len];

        for (int i = 0; i < mass.length; i++) {
            mass[i] = 1 + (int) (Math.random() * 99);
        }
        System.out.println("Вывод массива: ");
        System.out.println(Arrays.toString(mass));

        Arrays.sort(mass);
        System.out.println("Вывод отсортированного массива: ");
        System.out.println(Arrays.toString(mass));

        min = mass[0];
        max = mass[mass.length - 1];

        mass[0] = max;
        mass[mass.length - 1] = min;

        System.out.println("Вывод измененного массива: ");
        System.out.println(Arrays.toString(mass));


        // 2. Задан одномерный массив целых чисел.
        // Образуйте из него два отсортированных по возрастанию массива, содержащих четные и нечетные числа.
        System.out.println("Задача 2.");

        int lenP = 0, lenN = 0;

        for (int i = 0; i < mass.length; i++) {
            mass[i] = -50 + (int) (Math.random() * 100);
        }
        System.out.println("Вывод массива: ");
        System.out.println(Arrays.toString(mass));

        Arrays.sort(mass);
        System.out.println("Вывод отсортированного массива: ");
        System.out.println(Arrays.toString(mass));

        for (int i : mass) {
            if (i > -1) lenP++;
            if (i < 0) {
                lenN++;
            }
        }

        int[] massP = new int[lenP];
        int[] massN = new int[lenN];

        System.arraycopy(mass, 0, massN, 0, lenN);
        System.arraycopy(mass, lenN, massP, 0, lenP);

        System.out.println("Вывод массива с отрицательными числами: ");
        System.out.println(Arrays.toString(massN));
        System.out.println("Вывод массива с положительными числами: ");
        System.out.println(Arrays.toString(massP));


        // 3. Задать массив. Отрицательные элементы массива перенести в новый массив.
        // Размер массива должен быть равен количеству отрицательных элементов.
        System.out.println("Задача 3.");

        lenN = 0;

        for (int i = 0; i < mass.length; i++) {
            mass[i] = -50 + (int) (Math.random() * 100);
        }

        System.out.println("Вывод массива: ");
        System.out.println(Arrays.toString(mass));

        Arrays.sort(mass);
        System.out.println("Вывод отсортированного массива: ");
        System.out.println(Arrays.toString(mass));

        for (int i : mass) {
            if (i < 0) {
                lenN++;
            }
        }

        massN = new int[lenN];

        System.arraycopy(mass, 0, massN, 0, lenN);

        System.out.println("Вывод массива с отрицательными числами: ");
        System.out.println(Arrays.toString(massN));


        // 4. Создайте массив из чётных чисел [2;20]
        // и выведите элементы массива в консоль в обратном порядке (20 18 16 ... 4 2)

        System.out.println("Задача 4.");

        len = 10;
        mass = new int[len];
        int[] massR = new int[len];

        for (int num = 0, i = 0, y = len - 1; i < len; i++, y--) {
            massR[y] = mass[i] = num+=2;
        }

        System.out.println("Вывод массива от большего к меньшему: ");
        System.out.println(Arrays.toString(massR));


        // 5. Создайте массив из 11 случайных целых чисел из отрезка [-1;1], выведите массив в консоль.
        //Определите какой элемент встречается в массиве чаще всего и выведите информацию об этом в консоль.

        System.out.println("Задача 5.");

        int countA = 0, countB = 0, countC = 0;
        len = 11;
        mass = new int[len];

        for (int i = 0; i <= 10; i++) {
            mass[i] = -1 + (int) (Math.random() * 3);
            if (mass[i] == -1) countA++;
            if (mass[i] == 0) countB++;
            if (mass[i] == 1) countC++;
        }

        System.out.println("Цифра -1 встречается " + countA + " раз");
        System.out.println("Цифра 0 встречается " + countB + " раз");
        System.out.println("Цифра 1 встречается " + countC + " раз");



    }
}
