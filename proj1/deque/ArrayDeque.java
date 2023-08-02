package deque;

import java.util.Iterator;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    public void addFirst(T item) {
        if (isEmpty()) {
            nextFirst = items.length - 1;
            nextLast = 1;
            items[0] = item;
        }

        else if (size == items.length) {
            T[] resizedItems = (T[]) new Object[size * 2];
            int count = 1;
            for (T element : items) {
                if (count > size)
                    break;
                if (element == null)
                    continue;
                resizedItems[count] = element;
                count++;
            }
            items = resizedItems;
            items[0] = item;
            nextFirst = items.length - 1;
            nextLast = size + 1;
        }
        else {
            items[nextFirst] = item;
            nextFirst = (nextFirst - 1 + items.length) % items.length;
        }
        size++;
    }

    public void addLast(T item) {
        if (isEmpty()) {
            nextFirst = items.length - 1;
            nextLast = size + 1;
            items[0] = item;
        }
        else if (size == items.length) {
            T[] resizedItems = (T[]) new Object[size * 2];
            int count = 0;
            for (T element : items) {
                if (count == size)
                    break;
                if (element == null)
                    continue;
                resizedItems[count] = element;
                count++;
            }
            items = resizedItems;
            items[size] = item;
            nextFirst = items.length - 1;
            nextLast = size + 1;
        }
        else {
            items[nextLast] = item;
            nextLast = (nextLast + 1) % items.length;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty())
            return null;

        int first = (nextFirst + 1) % items.length;
        T removedItem = items[first];
        if (size < items.length / 4) {
            T[] resizedItems = (T[]) new Object[items.length / 4];
            int count = 0;
            for (T element : items) {
                if (count == size)
                    break;
                if (element == null)
                    continue;
                resizedItems[count] = element;
                count++;
            }
            items = resizedItems;
            items[0] = null;
            nextFirst = 0;
            nextLast = size + 1;
        }
        else {
            items[first] = null;
            nextFirst = (nextFirst + 1) % items.length;
        }
        size--;
        return removedItem;
    }

    public T removeLast() {
        if (isEmpty())
            return null;

        int last = (nextLast - 1 + items.length) % items.length;
        T removedItem = items[last];
        if (size < items.length / 4) {
            T[] resizedItems = (T[]) new Object[items.length / 4];
            int count = 0;
            for (T element : items) {
                if (count == size)
                    break;
                resizedItems[count] = element;
                count++;
            }
            items = resizedItems;
            items[size - 1] = null;
            nextLast = size - 1;
        }
        else {
            items[last] = null;
            nextLast = (nextLast - 1 + items.length) % items.length;
        }
        size--;
        return removedItem;
    }

    public T get(int index) {
        if (isEmpty())
            return null;
        if (index > size - 1 || index < 0)
            throw new IllegalArgumentException("Index is not existed.");

        int actualIndex = (nextFirst + 1 + index + items.length) % items.length;
        return items[actualIndex];
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int pos;

        public ArrayDequeIterator() {
            pos = 0;
        }

        public boolean hasNext() {
            return pos < size;
        }

        public T next() {
            T returnItem = get(pos);
            pos++;
            return returnItem;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ArrayDeque<?> other) {
            if (other == this)
                return true;
            if (other.size != this.size)
                return false;

            for (int i = 0; i < size; i++) {
                if (other.get(i) != this.get(i))
                    return false;
            }
            return true;
        }
        return false;
    }



    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (isEmpty())
            return;

        for (T item : items) {
            if (item == null)
                continue;
            System.out.print(item + " ");
        }
        System.out.println();
    }


}
