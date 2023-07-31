package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> alist = new AListNoResizing<>();
        BuggyAList<Integer> blist = new BuggyAList<>();

        alist.addLast(4);
        alist.addLast(5);
        alist.addLast(6);

        blist.addLast(4);
        blist.addLast(5);
        blist.addLast(6);

        assertEquals(alist.size(), blist.size());

        assertEquals(alist.removeLast(), blist.removeLast());
        assertEquals(alist.removeLast(), blist.removeLast());
        assertEquals(alist.removeLast(), blist.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> alist = new AListNoResizing<>();
        BuggyAList<Integer> blist = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                alist.addLast(randVal);
                blist.addLast(randVal);
            }
            else if (operationNumber == 1) {
                // getLast
                if (alist.size() == 0 || blist.size() == 0)
                    continue;
                assertEquals(alist.getLast(), blist.getLast());
            }
            else if (operationNumber == 2) {
                // removeLast
                if (alist.size() == 0 || blist.size() == 0)
                    continue;
                assertEquals(alist.removeLast(), blist.removeLast());
            } else {
                // size
                assertEquals(alist.size(), blist.size());
            }
        }
    }

}
