package com.roma.storage;

public class Library {
    public static void main(String[] args) {

        String[] adjectives = {"Тихий", "Темный", "Большой", "Сильный", "Живой", "Стеклянный", "Быстрый", "Круглый", "Худой", "Базовый"};
        String[] nouns = {"дом", "берег", "дядька", "пес", "попугай", "текст", "стол", "курс", "стакан", "сынок"};
        String[] authorsN = {"Игорь", "Наталья", "Федор", "Александр", "Анатолий", "Татьяна", "Олег", "Дарья", "Николай", "Роман",};
        String[] authorsS = {"Хороший", "Плохой", "Бедненький", "Больной", "Богатый", "Синий", "Берёзка", "Белочка", "Суслик", "Телек"};
        String[] booksGen = new String[20];
        String[] authorsGen = new String[20];

        for (int i = 0; i < 20; i++) {
            booksGen[i] = adjectives[(int) (Math.random() * 10)] + " " + nouns[(int) (Math.random() * 10)];
            authorsGen[i] = authorsN[(int) (Math.random() * 10)] + " " + authorsS[(int) (Math.random() * 10)];
        }

        Author author1 = new Author();
        // создали нового автора
        author1.name = (authorsN[(int) (Math.random() * 10)]);
        author1.secondName = (authorsS[(int) (Math.random() * 10)]);
        // задали имя и фамилию

        Book book1 = new Book();
        // создали новую книгу
        book1.setName(booksGen[(int) (Math.random() * 20)]);
        // Название книги

        // Имя автора(ов)
        book1.setPages(50 + (int) (Math.random() * 200));
        book1.setYear(1700 + (int) (Math.random() * 320));


        System.out.println(book1);
        System.out.println(author1);







    }
}
