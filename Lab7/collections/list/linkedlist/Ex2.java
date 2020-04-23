package collections.list.linkedlist;

import java.util.LinkedList;

// head ---- tail

public class Ex2 {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
//        System.out.println(list.element()); //NoSuchElementException
        list.add("a");
        list.offer("c");
        list.offerFirst("rr");
        list.offerLast("zz");
        System.out.println(list);

        System.out.println(list.element()); // head, arunca exceptie daca e vida
        System.out.println(list.peek()); // primul element daca lista nu este vida
        System.out.println(list.poll()); // elimina primul element
        System.out.println(list);

        LinkedList<String> empty = new LinkedList<>();
        System.out.println(empty.poll()); // null
//        System.out.println(empty.pop()); // EXCEPTIE NoSuchElementException

        // from deque
        System.out.println(list.pop()); // elimina primul element; removeFirst()
    }
}
