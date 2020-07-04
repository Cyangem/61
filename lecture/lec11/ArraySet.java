import java.util.*;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class ArraySet<T> implements Iterable<T> { //T could be anything replaced

    private T[] items;
    private int size;//the next item to be added will be at position size.

    //returns an iterator (a.k.a. seer) into ME.
    public Iterator<T> iterator() {
      return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;
        public ArraySetIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            T returnItem = items[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }

    public ArraySet() {
        items = (T[]) new Object[100];

    }

    //returns true if this map contains a mapping for the specified key.
    public boolean contains(T x) {
        for (int i = 0; i < size; i += 1) {
            //if (x.equals(items[i])) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    public void add(T x) {
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    public int size() {
        return size;
    }

    /*@Override
    public String toString() {
        StringBuilder returnSB = new StringBuilder("{");
        for (int i = 0; i < size - 1; i += 1) {
            returnSB.append(items[i].toString());
            returnSB.append(", ");
        }
        returnSB.append(items[size - 1]);
        returnSB.append("}");
        return returnSB.toString();
    }*/

    @Override
    public String toString() {
        List<String> listOfItems = new ArrayList<>();
        for (T x : this) {
            listOfItems.add(x.toString());
        }
        return "{" + String.join(", ", listOfItems) + "}";
    }

    public static <Glerp> ArraySet<Glerp> of (Glerp... stuff) {
        ArraySet<Glerp> returnSet = new ArraySet<Glerp>();
        for (Glerp x : stuff) {
            returnSet.add(x);
        }
        return returnSet;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ArraySet<T> o =  (ArraySet<T>) other;
        if (o.size() != this.size()) {
            return false;
        }
        for (T item : this) {
            if (!o.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        System.out.println(aset);

        ArraySet<Integer> aset2 = new ArraySet<>();
        aset2.add(5);
        aset2.add(23);
        aset2.add(42);

        System.out.println(aset.equals(aset2));
        System.out.println(aset.equals(null));
        System.out.println(aset.equals("fish"));
        System.out.println(aset.equals(aset));

        ArraySet<String> asetOfStrings = ArraySet.of("hi", "I'm", "here");
        System.out.println(asetOfStrings);

        /**
        Iterator<Integer> aseer = aset.iterator();
        while (aseer.hasNext()) {
            int i = aseer.next();
            System.out.println(i);
        }
        //ultimate goal
        for (int i : aset) {
            System.out.println(i);
        }*/

        //in order to enhanced for loop, do the following:
        //Add an iterator()
        //The iterator<T> should have hasNext() & next()
        //implements Iterable<T> to the line defining your class

        /* Also to do:
        1. implement a toString method;
        2. Implement an equals() method
        3. make ArraySet implement the Iterable<T> interface*/
    }
}
