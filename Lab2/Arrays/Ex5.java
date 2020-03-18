public class Ex5 {
    public static void main(String[] args) {
        char[] source = {'a', 'b', 'c', 'd', 'e', 'f'};
        char[] destination = new char[5];

//        i : starting position in source array from where to copy = 3
//        i1 : starting position in destination array, where to copy in
//        i2 : total no. of components to be copied.

        System.arraycopy(source, 2, destination, 0, 4);
        System.out.println(String.valueOf(destination)); //cdef

        // on single-dimensional arrays, clone() method copies the values as expected
        int[] ints = {22, 33, 44, 55, 66};
        int[] clone = ints.clone();
        for (int i : clone) {
            System.out.println(i);
        }

        System.out.println();
        // au adrese diferite
        System.out.println(ints);
        System.out.println(clone);
        System.out.println(ints == clone); // false

        byte[][] bytes = new byte[3][];
        bytes[0] = new byte[]{1, 0};
        bytes[1] = new byte[]{};
        bytes[2] = new byte[]{1, 1, 1, 1, 1, 1};

        // cloning multidimensional arrays only copies the references of array elements (shallow copy)
        byte[][] clone2 = bytes.clone();
        // this will print true since we compare two byte values
        System.out.println(bytes[0][0] == clone2[0][0]);

        // will print true since both values are references to the same array in memory
        System.out.println(bytes[0] == clone2[0]);
        // same address in memory
        System.out.println(bytes[0]);
        System.out.println(clone2[0]);
    }
}