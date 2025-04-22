import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private Set<String> authors = new HashSet<>();
    private Map<String, Integer> authorStats = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
        authors.add(book.getAuthor());
        authorStats.put(book.getAuthor(),
                authorStats.getOrDefault(book.getAuthor(), 0) + 1);
    }

    public void removeBook(Book book) {
        if (books.remove(book)) {
            String author = book.getAuthor();
            int count = authorStats.get(author) - 1;

            if (count == 0) {
                authors.remove(author);
                authorStats.remove(author);
            } else {
                authorStats.put(author, count);
            }
        }
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findBooksByYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() == year) {
                result.add(book);
            }
        }
        return result;
    }

    public void printAllBooks() {
        System.out.println("\nВсе книги в библиотеке:");
        books.forEach(System.out::println);
    }

    public void printUniqueAuthors() {
        System.out.println("\nУникальные авторы:");
        authors.forEach(System.out::println);
    }

    public void printAuthorStatistics() {
        System.out.println("\nСтатистика по авторам:");
        authorStats.forEach((author, count) ->
                System.out.println(author + ": " + count + " книг(и)"));
    }
}