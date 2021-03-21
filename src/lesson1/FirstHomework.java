package lesson1;

public class FirstHomework {
    public static void main(String[] args) {
        /*Даны переменные типа long start и end.
        Если start меньше end переменной between присвоить значение end - start, в противном случае -1*/
        long start = 5, end = 13;
        long between = start < end ? end - start : -1;
        System.out.println(between);

        /*Задача на арифметические операторы
        Найти сумму цифр 2х значного числа*/
        int number = 51, a, b, c;
        a = number / 10;
        b = number % 10;
        System.out.println(a + b);

        /*Задача на арифметические операторы
        Найти сумму цифр 3х значного числа*/
        number = 514;
        a = number / 100;
        b = number / 10 % 10;
        c = number % 10;
        System.out.println(a + b + c);


    }
}
