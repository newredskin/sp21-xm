package deque;

import java.util.Iterator;

public class LinkedListDeque<T>{
    private static class Node<T> {
        public T item;
        public Node<T> next;
        public Node<T> previous;

        public Node(T item, Node<T> n, Node<T> p) {
            this.item = item;
            next = n;
            previous = p;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node<>(66, null, null);
        size = 0;
    }

    public void addFirst(T item) {
        if (size == 0) {
            Node<T> initialNode = new Node(item, sentinel, sentinel);
            sentinel.next = initialNode ;
            sentinel.previous = initialNode;
        }
        else {
            Node temp = sentinel.next;
            Node<T> newFirst = new Node(item, temp, sentinel);
            temp.previous = newFirst;
            sentinel.next = newFirst;
        }
        size++;
    }

    public void addLast(T item) {
        if (size == 0) {
            Node<T> initialNode = new Node(item, sentinel, sentinel);
            sentinel.next = initialNode ;
            sentinel.previous = initialNode;
        }
        else {
            Node temp = sentinel.previous;
            Node<T> newLast = new Node(item, sentinel, temp);
            temp.next = newLast;
            sentinel.previous = newLast;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty())
            return null;

        Node removedNode = sentinel.next;
        sentinel.next = removedNode.next;
        removedNode.next.previous = sentinel;
        removedNode.next = null;
        removedNode.previous = null;

        size--;
        return (T) removedNode.item;
    }

    public T removeLast() {
        if (isEmpty())
            return null;

        Node removedItem = sentinel.previous;
        sentinel.previous = removedItem.previous;
        removedItem.previous.next = sentinel;
        removedItem.next = null;
        removedItem.previous = null;

        size--;
        return (T) removedItem.item;
    }

    public T get(int index) {
        if (isEmpty())
            return null;
        if (index > size - 1 || index < 0)
            throw new IllegalArgumentException("Index is not existed.");
        int count = 0;
        Node node = sentinel.next;
        while (node != sentinel) {
            if (count == index)
                return (T) node.item;
            count++;
            node = node.next;
        }
        return null;
    }

    public T getRecursive(int index) {
        if (isEmpty())
            return null;
        if (index > size - 1 || index < 0)
            throw new IllegalArgumentException("Index is not existed.");
        return (T) getRecursiveNode(index).item;
    }

    private Node<T> getRecursiveNode(int index) {
        if (index == 0)
            return sentinel.next;
        return getRecursiveNode(index - 1).next;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private int pos;

        public LinkedListIterator() {
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
        if (o == null)
            return false;
        if (o == this)
            return true;
        if (o.getClass() != this.getClass())
            return false;
        LinkedListDeque<T> other = (LinkedListDeque<T>) o;
        if (other.size() != this.size())
            return false;
        for (int i = 0; i < size; i++) {
            if (other.get(i) != this.get(i))
                return false;
        }
        return true;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (o instanceof LinkedListDeque other) {
//            if (other == this)
//                return true;
//            if (other.size != this.size)
//                return false;
//            for (int count = 0; count < size; count++) {
//                if (other.get(count) != this.get(count))
//                    return false;
//            }
//            return true;
//        }
//        return false;
//    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (isEmpty())
            return;
        Node node = sentinel.next;
        while (node != sentinel) {
            System.out.print(node.item + " ");
            node = node.next;
        }
        System.out.println();
    }




}
