package deque;

public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        ArrayDeque<Integer> lld2 = new ArrayDeque<>();
        ArrayDeque<String> lld3 = new ArrayDeque<>();
//        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
//        LinkedListDeque<Integer> lld2 = new LinkedListDeque<>(1);
//        LinkedListDeque<String> lld3 = new LinkedListDeque<>();


        lld1.addFirst(5);
        lld1.addFirst(1);
        lld1.addLast(10);
        lld1.addLast(15);

        lld2.addLast(5);
        lld2.addLast(10);
        lld2.addLast(15);
        lld2.addFirst(1);

        lld3.addLast("Booga");
        lld3.addLast("Miaozu");
        lld3.addLast("Tianye");
        lld3.addFirst("Xiye");

//        lld3.printDeque();
        lld3.removeFirst();
        lld3.addFirst("lalala");

        lld1.printDeque();
        lld2.printDeque();
        System.out.println(lld1.equals(lld2));
    }
}
