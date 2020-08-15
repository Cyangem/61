import edu.princeton.cs.algs4.Queue;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSortAlgs {

    @Test
    public void testQuickSort() {
        Queue<Integer> tas = new Queue<>();
        tas.enqueue(6);
        tas.enqueue(3);
        tas.enqueue(5);
        tas.enqueue(7);
        tas.enqueue(9);
        tas.enqueue(2);
        tas.enqueue(8);
        for (int i = 10; i < 10000; i += 1) {
            tas.enqueue(i);
        }
        assertTrue(isSorted(QuickSort.quickSort(tas)));

        Queue<String> ssa = new Queue<>();
        ssa.enqueue("Grace");
        ssa.enqueue("Iris");
        ssa.enqueue("Carla");
        ssa.enqueue("Jenny");
        ssa.enqueue("Henry");
        ssa.enqueue("Michael");
        ssa.enqueue("John");
        assertTrue(isSorted(QuickSort.quickSort(ssa)));
    }

    @Test
    public void testMergeSort() {
        Queue<Integer> tas = new Queue<>();
        tas.enqueue(6);
        tas.enqueue(3);
        tas.enqueue(5);
        tas.enqueue(7);
        tas.enqueue(9);
        tas.enqueue(2);
        tas.enqueue(8);
        for (int i = 10; i < 10000; i += 1) {
            tas.enqueue(i);
        }
        assertTrue(isSorted(MergeSort.mergeSort(tas)));

        Queue<String> ssa = new Queue<>();
        ssa.enqueue("Grace");
        ssa.enqueue("Iris");
        ssa.enqueue("Carla");
        ssa.enqueue("Jenny");
        ssa.enqueue("Henry");
        ssa.enqueue("Michael");
        ssa.enqueue("John");
        assertTrue(isSorted(MergeSort.mergeSort(ssa)));
    }

    /**
     * Returns whether a Queue is sorted or not.
     *
     * @param items  A Queue of items
     * @return       true/false - whether "items" is sorted
     */
    private <Item extends Comparable> boolean isSorted(Queue<Item> items) {
        if (items.size() <= 1) {
            return true;
        }
        Item curr = items.dequeue();
        Item prev = curr;
        while (!items.isEmpty()) {
            prev = curr;
            curr = items.dequeue();
            if (curr.compareTo(prev) < 0) {
                return false;
            }
        }
        return true;
    }
}
