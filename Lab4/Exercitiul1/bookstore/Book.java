package bookstore;

import java.util.Scanner;

public class Book {

    private String title;
    private String author;
    private String publisher;
    private int pageCount;

    public Book(String title, String author, String publisher, int pageCount) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public String toString() {
        return "BOOK_TITLE: " + title.toUpperCase() + "\n" +
                "BOOK_AUTHOR: " + author.toLowerCase() + "\n" +
                "BOOK_PUBLISHER: " + publisher + "\n";
    }
}
