/** An SLList is a list of integers, which hides the terrible
 * truth of the nakedness within. */

public class SLList {
    /** declare a variable on SLList*/
    private IntNode first;
    private IntNode last;

    /** move a class into another class, which will call the nested classes*/
    /**if no body else needs an IntNode reference, make it private*/
    /** the static keyword here means could be never looks outwards*/

    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }

    }
    /** declare a constructor for SLList*/
    public SLList(int x) {
        first = new IntNode(x, null);
    }

    /** Adds x to the front of the list*/
    public void addFirst(int x ) {
        first = new IntNode(x, first);

    }

    /** adds an item to the end of the list, write it iteratively*/
    public void addLast(int x) {
//        last = new IntNode(x, last);
        IntNode p = first;

        /** scan p to the end of the list, move p until it reaches the end of the list */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }
    //the SLList date structure doesn't have the list pointer
    //helper method
    //returns the size of the list that starts at IntNode p.
    private static int size(IntNode p) {
        if (p.next == null) {
            return 1;
        }
        return 1 + size(p.next);
    }
    //public method that speak the language of mortals & a private method
    // that speaks the language of the gods
// the middle man, public method
    public int size() {
        return size(first);
    }

    //my answer, not work
//    public int size() {
//        //base case is tricky, the recursive case is just equally strange
//        if (first == null) {
//            return 1;
//        }
//
//        return 1 + first.next.size();
//    }

    /** return the first item in the list*/
    public int getFirst() {
        return first.item;
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10*/
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        System.out.println(L.getFirst());
        System.out.println(L.size());
    }
}
/** */
