package com.roma.lib.library;

public class Application {
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
            authorsGen[i] = authorsN[(int) (Math.random() * 10)] + " " + authorsS[(int) (Math.random() * 10)];
            authorsGen[i] = authorsN[(int) (Math.random() * 10)] + " " + authorsS[(int) (Math.random() * 10)];
        }
        // ----------------------------------------------------------------------------------------------------------
        Author author1 = new Author(authorsN[(int) (Math.random() * 10)], authorsS[(int) (Math.random() * 10)] );
        Author author2 = new Author(authorsN[(int) (Math.random() * 10)], authorsS[(int) (Math.random() * 10)] );

        Book book1 = new Book(booksGen[(int) (Math.random() * 10)], 2);
        book1.setPageCount(50 + (int) (Math.random() * 200));
        book1.setYear(1700 + (int) (Math.random() * 320));
        book1.addAuthor(author1);
        book1.addAuthor(author2);

        Storage storage = new Storage();
        storage.addBook(book1);

        for (Book b : storage.getBooks()) {
            System.out.println(b.getTitle());
            for (Author author : b.getAuthors()) {
                System.out.println(author.getName());
                System.out.println(author.getSurName());
            }
        }











    }
}
