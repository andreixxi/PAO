package arrays;

import java.util.Arrays;

public class MyArrayList {

    private int dim;
    private float[] array;
    private int idxArray;

    public MyArrayList() {
        this.dim = 10;
        this.array = new float[dim];
        idxArray = 0;
    }

    public MyArrayList(int dim) {
        this.dim = dim;
        this.array = new float[dim];
        idxArray = 0;
    }

/*- o metodă numită add(float value), care adaugă valoarea value la primul index disponibil al vectorului.
 Dacă se depăşeşte capacitatea vectorului, acesta se va redimensiona la o capacitate dublă;
Atenţie! Există o diferenţă între capacitatea vectorului (dimensiunea cu care a fost iniţializat) şi
 numărul de elemente memorate efectiv în el (care este cel mult capacitatea).*/

    public void add(float value) {
        if (idxArray >= this.dim) {
            dim = dim * 2;
            array = Arrays.copyOf(array, dim);
        }
        array[idxArray++] = value;
    }

    public boolean contains(float value) {
        for (float element : this.array) {
            if (value == element) {
                return true;
            }
        }
        return false;
    }

    public void remove(int index) {
        if (index < 0 || index >= dim) {
            throw new RuntimeException("Invalid index");
        }
        for (int i = index; i < dim - 1; i++) {
            array[i] = array[i + 1];
        }
        dim--;
    }

    public float get(int index) {
        if (index < 0 || index >= dim) {
            throw new RuntimeException("Invalid index");
        }
        return array[index];
    }

    public int size() {
        return dim;
    }

    @Override
    public String toString() {
        StringBuilder afisare = new StringBuilder();
        afisare.append("Array= ");

        for (int i = 0; i < dim; i++) {
            afisare.append(array[i]).append(" ");
        }

        return afisare.toString();
    }
}
