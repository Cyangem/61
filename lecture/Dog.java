import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    private String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }

    //return negative number if this dog is less than the dog pointed at by 0, and so forth.
    public int compareTo(Dog uddaDog) {//compare yourself to other objects
        //cast the object
//        Dog uddaDog = (Dog) o;

        return this.size - uddaDog.size;
//        if (this.size < uddaDog.size) {
//            return -1;
//        } else if (this.size == uddaDog.size) {
//            return 0;
//        }
//        return 1;
    }

    private static class NameComparator implements Comparator<Dog> {
        public int compare(Dog a, Dog b) {
            return a.name.compareTo(b.name);
        }
    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }

}