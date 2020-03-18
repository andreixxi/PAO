public class Ex1 {
    public static void main(String[] args) {
        //declare an array
        int[] intArray;
        //initialise the array
        intArray = new int[5];
        //initialise some elements
        intArray[0] = 123;
        intArray[1] = 21;
        intArray[4] = 0;
        // trying to access an out of bounds index will result in a runtime exception
        // intArray[5] = 55; // this line will compile, but will throw an exception at runtime

        //display
        for (int i = 0; i < intArray.length; i++) {
            System.out.println("element at index " + i + ": " + intArray[i]);
        }

        // can also put the brackets after the name, but language convention discourages this form
        int intArray2[] = new int[10];

        // can declare an array of any other primitive or reference type
        byte[] byteArray;
        short[] shortArray;
        long[] longArray;
        float[] floatArray;
        double[] doubleArray;
        char[] charArray;
        boolean[] booleanArray;
        String[] stringArray = args;
        Object[] objectArray;
    }
}
