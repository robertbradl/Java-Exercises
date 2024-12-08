package Exercise_8;

import java.util.function.Consumer;

public class Task3 {
    public static void main(String[] args) {
        TypeList L = new TypeList();
        TypeList L1 = L.addElement(1);
        TypeList L2 = L1.addElement(2);
        TypeList L3 = L2.addElement(3);

        System.out.println(L1);

        System.out.println(L2);

        System.out.println(L3);

        System.out.println(L3.head());

        System.out.println(L3.afterHead());

        TypeList L4 = L3.addElement(4).addElement(5).addElement(6);
        System.out.println(L4);
    }
}

class TypeList<T> {
    static class TypeNode<T> {
        public T data;
        public TypeNode<T> next = null;

        public TypeNode(T value) {
            data = value;
        }
    }

    TypeNode<T> first = null; // root
    TypeNode<T> last = null; // head

    @SafeVarargs
    public static <T> TypeList<T> of(T... elements) {
        TypeList<T> result = new TypeList<T>();
        for (T el : elements)
            result.addElement(el);
        return result;
    }

    private void add(T el) {
        TypeNode<T> n = new TypeNode<T>(el);
        if (last != null)
            last.next = n;
        last = n;
        if (first == null)
            first = n;
    }

    // or 'cons'
    public TypeList<T> addElement(T el) {
        new TypeList<T>();
        TypeList<T> retList;
        retList = this.copy();
        retList.add(el);
        return retList;
    }

    private TypeList<T> copy() {
        TypeList<T> retList = new TypeList<T>();
        this.forEach(retList::add);
        return retList;
    }

    private void forEach(Consumer<? super T> action) {
        traverseAndApply(first, action);
    }

    private void traverseAndApply(TypeNode<T> n, Consumer<? super T> action) {
        if (n == null)
            return;
        action.accept(n.data);
        traverseAndApply(n.next, action);
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public TypeList<T> theEmptyList() {
        return new TypeList<T>();
    }

    // or 'car'
    public T head() {
        return this.last.data;
    }

    // or 'cdr'
    public TypeList<T> afterHead() {
        if (this.last == this.first) {
            return new TypeList<T>();
        } else {
            TypeList<T> retList = new TypeList<T>();
            TypeNode<T> current = this.first;
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
            TypeNode<T> current = this.first;
            do {
                retString.insert(0, String.valueOf(current.data) + " ");
                current = current.next;
            } while (current != null);
            return retString.toString();
        }
    }
}