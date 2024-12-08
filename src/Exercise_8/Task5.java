package Exercise_8;

import java.util.function.Consumer;

public class Task5 {
    public static void main(String[] args) {
        ObjectList L = new ObjectList();
        ObjectList L1 = L.addElement("1");
        ObjectList L2 = L1.addElement("2");
        ObjectList L3 = L2.addElement("3");

        System.out.println(L1);

        System.out.println(L2);

        System.out.println(L3);

        System.out.println(L3.head());

        System.out.println(L3.afterHead());

        ObjectList L4 = L3.addElement("4").addElement("5").addElement("6");
        System.out.println(L4);
    }
}

class ObjectList  {
    static class ObjectNode {
        public Object data;
        public ObjectNode next = null;

        public ObjectNode(Object value) {
            data = value;
        }
    }
    ObjectNode first = null; // root
    ObjectNode last = null; // head

    public static ObjectList of(Object... elements) {
        ObjectList result = new ObjectList();
        for (Object el : elements)
            result.addElement(el);
        return result;
    }

    private void add(Object el) {
        ObjectNode n = new ObjectNode(el);
        if (last != null)
            last.next = n;
        last = n;
        if (first == null)
            first = n;
    }

    // or 'cons'
    public ObjectList addElement(Object el) {
        new ObjectList();
        ObjectList retList;
        retList = this.copy();
        retList.add(el);
        return retList;
    }

    private ObjectList copy() {
        ObjectList retList = new ObjectList();
        this.forEach(retList::add);
        return retList;
    }

    private void forEach(Consumer<? super Object> action) {
        traverseAndApply(first, action);
    }

    private void traverseAndApply(ObjectNode n, Consumer<? super Object> action) {
        if (n == null)
            return;
        action.accept(n.data);
        traverseAndApply(n.next, action);
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public ObjectList theEmptyList() {
        return new ObjectList();
    }

    // or 'car'
    public Object head() {
        return this.last.data;
    }

    // or 'cdr'
    public ObjectList afterHead() {
        if (this.last == this.first) {
            return new ObjectList();
        } else {
            ObjectList retList = new ObjectList();
            ObjectNode current = this.first;
            while (current != this.last) {
                retList.add(current.data);
                current = current.next;
            }
            return retList;
        }
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "";
        } else {
            StringBuilder retString = new StringBuilder();
            ObjectNode current = this.first;
            do {
                retString.insert(0, String.valueOf(current.data) + " ");
                current = current.next;
            } while (current != null);
            return retString.toString();
        }
    }
}