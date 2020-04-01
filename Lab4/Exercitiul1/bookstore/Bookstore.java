package bookstore;

import java.util.Scanner;

public class Bookstore {
    private int nrCarti;
    private Book[] books;
    private int idx;

    public Bookstore(int nrCarti) {
        if (nrCarti > 0) {
            this.nrCarti = nrCarti;
            this.books = new Book[nrCarti];
            this.idx = 0;
        } else {
            throw new RuntimeException("Nu ati introdus un numar natural");
        }
    }

    public Book[] getBooks() {
        return books;
    }

    public int getNrCarti() {
        return nrCarti;
    }

    public static Book read(Scanner scanner) {
        System.out.println("Introduceti numele cartii");
        String title = scanner.next();
        System.out.println("Introduceti numele autorului");
        String author = scanner.next();
        System.out.println("Introduceti numele editurii");
        String publisher = scanner.next();
        System.out.println("Introduceti numarul de pagini");
        int pageCount = scanner.nextInt();
        if (pageCount <= 0) {
            System.out.println("Nu ati introdus un numar de pagini valid. Incercati din nou.");
            pageCount = scanner.nextInt();
        }
        Book book = new Book(title, author, publisher, pageCount);
        return book;
    }

    public void update(Book book) {
        if (idx == nrCarti) {
            throw new RuntimeException("Nu pot adauga carti");
        }
        books[idx++] = book;
    }

    //sterge prima carte
    public void delete() {
        if (idx > 0) {
            for (int i = 0; i < idx - 1; i++) {
                books[i] = books[i + 1];
            }
            idx--;
        }
    }
}
