package bookstore;

public class BookstoreCheck {

    public static void verif(Bookstore array, Book book) {
        //verific dacă o carte este în dublu exemplar
        int count = 0;
        for (int i = 0; i < array.getNrCarti(); i++) {
            if (array.getBooks()[i] == book) {
                count++;
            }
            if (count == 2) {
                System.out.println("Cartea " + book + "se afla in exemplar dublu");
                break;
            }
        }
        if (count != 2) {
            System.out.println("Cartea " + book + "nu se afla in dublu exemplar");
        }
    }

    public static Book verifGrosime(Book b1, Book b2) {
        //compara nr de pagini si returneaza cartea mai groasa
        if (b1.getPageCount() > b2.getPageCount()) {
            return b1;
        } else {
            return b2;
        }
    }
}
