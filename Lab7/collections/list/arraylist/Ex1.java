package collections.list.arraylist;

import java.util.ArrayList;
import java.util.List;

/* Iterable
    Collection
    -list
    -set
    -queue
 */
public class Ex1 {

    public static void main(String[] args) {

        // without generics
        List bulkList = new ArrayList();
        bulkList.add(1);
        bulkList.add("hey hey hey");
        bulkList.add(new Object());
        System.out.println(bulkList);

        List<String> stringList = new ArrayList<>();
        System.out.println(stringList.isEmpty());
        stringList.add("are you ready for this?");
        stringList.add("for what?");
        stringList.add("zimzalabim");
        stringList.add(0, "hehe");
        stringList.add(1, "20 20");

        System.out.println(stringList);
        System.out.println(stringList.size());

        if (stringList.contains("20 20")) {
            System.out.println(stringList.remove(0)); // afiseaza si obiectul de la indexul respectiv, dupa care il scoate
            System.out.println(stringList.remove("for what?")); // true sau false
        }

        System.out.println(stringList);
//        stringList.remove(3); // IndexOutOfBoundsException

        List<Integer> ints = new ArrayList<>(bulkList);
        ints.add(1);
        System.out.println(ints);

        List<String> list2 = new ArrayList<>(stringList);
        System.out.println("list2 created " + list2);
        list2.addAll(list2);
        System.out.println(list2);
        list2.addAll(1, list2);
        System.out.println(list2);
        list2.add("last element");

        list2.removeAll(stringList); // sterge toate elementele din stringlist care apar in list2
        System.out.println("after removing all " + list2);

        list2.clear(); // sterge tot
        System.out.println("after clear " + list2);
    }
}
