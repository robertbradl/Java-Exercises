package Exercise_8;

import java.util.function.Consumer;

public class Task5 {}

class List  {
    static class Node {
        public Object data;
        public Node next = null;

        public Node(Object value) {
            data = value;
        }
    }
    Node first = null; // root
    Node last = null; // head

    @SafeVarargs
    public static List of(Object... elements) {
        List result = new List();
        for (Object el : elements)
            result.addElement(el);
        return result;
    }

    private void add(Object el) {
        Node n = new Node(el);
        if (last != null)
            last.next = n;
        last = n;
        if (first == null)
            first = n;
    }

    // or 'cons'
    public List addElement(Object el) {
        List retlist = new List();
        retlist = this.copy();
        retlist.add(el);
        return retlist;
    }

    private List copy() {
        List retList = new List();
        this.forEach(retList::add);
        return retList;
    }

    private void forEach(Consumer<? super Object> action) {
        traverseAndApply(first, action);
    }

    private void traverseAndApply(Node n, Consumer<? super Object> action) {
        if (n == null)
            return;
        action.accept(n.data);
        traverseAndApply(n.next, action);
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public List theEmptyList() {
        return new List();
    }

    // or 'car'
    public Object head() {
        return this.last.data;
    }

    // or 'cdr'
    public List afterHead() {
        if (this.last == this.first) {
            return new List();
        } else {
            List retlist = new List();
            Node current = this.first;
            while (current != this.last) {
                retlist.add(current.data);
                current = current.next;
            }
            return retlist;
        }
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "";
        } else {
            StringBuilder retString = new StringBuilder();
            Node current = this.first;
            do {
                retString.insert(0, String.valueOf(current.data) + " ");
                current = current.next;
            } while (current != null);
            return retString.toString();
        }
    }
}