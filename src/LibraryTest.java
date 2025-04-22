public class LibraryTest {
    public static void main(String[] args) {
        Library library = new Library();

        // Создание книг
        Book book1 = new Book("1984", "Джордж Оруэлл", 1949);
        Book book2 = new Book("Скотный двор", "Джордж Оруэлл", 1945);
        Book book3 = new Book("Мастер и Маргарита", "Михаил Булгаков", 1967);
        Book book4 = new Book("Преступление и наказание", "Фёдор Достоевский", 1866);

        // Добавление книг
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        // Тестирование методов
        library.printAllBooks();
        library.printUniqueAuthors();
        library.printAuthorStatistics();

        // Поиск по автору
        System.out.println("\nКниги Джорджа Оруэлла:");
        library.findBooksByAuthor("Джордж Оруэлл").forEach(System.out::println);

        // Поиск по году
        System.out.println("\nКниги 1945 года:");
        library.findBooksByYear(1945).forEach(System.out::println);

        // Удаление книги
        library.removeBook(book2);
        System.out.println("\nПосле удаления 'Скотный двор':");
        library.printAllBooks();
        library.printAuthorStatistics();
    }
}