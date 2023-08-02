package deque;

import java.util.Comparator;

public class MaxArrayDequeTest {
    public static void main(String[] args) {
        Comparator<Character> cmp = new Comparator<>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1.hashCode() - o2.hashCode();
            }
        };

        MaxArrayDeque<Character> mad1 = new MaxArrayDeque<>(cmp);

        mad1.addFirst('a');
        mad1.addLast('z');
        mad1.addLast('d');
        mad1.addLast('f');
        mad1.addLast('r');

        System.out.println(mad1.max());

    }
}
