package bookstore;

import javax.sound.midi.SysexMessage;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BookstoreTest {

    public static void main(String[] args) {

        // b) create
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul de carti");
        int noBooks = scanner.nextInt();
        Bookstore books = new Bookstore(100);

        // read + update
        for (int i = 0; i < noBooks; i++) {
            Book book = Bookstore.read(scanner);
            books.update(book);
        }
        scanner.close();

        // c)
        // test metoda dublu exemplar
        Book firstBook = books.getBooks()[0];

        System.out.println("Inainte de a adauga o dublura: ");
        BookstoreCheck.verif(books, firstBook);

        System.out.println("Dupa adaugarea unei dubluri:");
        books.update(firstBook);
        BookstoreCheck.verif(books, firstBook);

        //sterg prima carte(dublura)
        books.delete();

        //test metoda grosime
        Book secondBook = books.getBooks()[1];
        firstBook = books.getBooks()[0];
        Book thick = BookstoreCheck.verifGrosime(firstBook, secondBook);
        System.out.println("Dintre cartile " + firstBook + " si " + secondBook + " , are mai multe pagini " +
                thick);

        // d) print
        for (int i = 0; i < noBooks; i++) {
            System.out.println(books.getBooks()[i]);
        }

    }
}