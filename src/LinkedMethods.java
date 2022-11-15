import java.util.*;

public class LinkedMethods<E> implements List<E>, Deque<E> {
    int count = 0;
    Node<E> first;
    Node<E> last;

    /**
     * this method returns the number of elements
     *
     * @return amount
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * this method checks the content of the elements in the list
     *
     * @return true if o is removed, else - false
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * this method checks if the element is present in the list
     *
     * @param o - object to check
     * @return true if o is removed, else - false
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * this method iterates over the list
     *
     * @return true if o is removed, else - false and element
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                if (first.getNext() == null) {
                    return false;
                }
                return true;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    return first.getNext().getItem();
                }
                return null;
            }
        };
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    /**
     * this method returns an array containing all the elements in this list
     *
     * @return massive
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[count];
        int i = 0;
        for (Node<E> x = first; x != null; x = x.getNext())
            result[i++] = x.getItem();
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * this method adding to the beginning
     * @param e the element to add
     */
    @Override
    public void addFirst(E e) {
        Node<E> f = first;
        Node<E> node = new Node<>(null, e, first);
        first = node;
        if (f == null) {
            last = node;
        } else
            f.setPrev(node);
        count++;
    }

    /**
     * this method adding to the end
     * @param e the element to add
     */
    @Override
    public void addLast(E e) {
        add(e);
    }

    /**
     * this method adding to the beginning
     * @param e the element to add
     * @return true if o is removed, else - false and element
     */
    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    /**
     * this method adding to the end
     * @param e the element to add
     * @return true if o is removed, else - false and element
     */
    @Override
    public boolean offerLast(E e) {
        add(e);
        return true;
    }

    @Override
    public E removeFirst() {

        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    /**
     * this method adds the specified element to the end of this list
     *
     * @param student - element to add
     * @return true if o is removed, else - false
     */
    @Override
    public boolean add(E student) {
        final Node<E> r = last;
        final Node<E> newNode = new Node<>(r, student, null);
        last = newNode;
        if (r == null) {
            first = newNode;
        } else {
            r.setNext(newNode);
        }
        count++;
        return true;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    /**
     * this method remove object by reference
     *
     * @param o - object to delete
     * @return true if o is removed, else - false
     */
    @Override
    public boolean remove(Object o) {
        for (Node<E> x = first; x != null; x = x.getNext()) {
            if (o.equals(x.getItem())) {
                del(x);
                return true;
            }
        }
        return false;
    }

    /**
     * this method checks if the collection is in the list
     *
     * @param c - passed collection to check
     * @return true if o is removed, else - false
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (var item : c) {
            if (!contains(item))
                return false;
        }
        return true;
    }

    /**
     * this method adding a collection to the end of a list
     *
     * @param c - passed collection to add
     * @return true if o is removed, else - false
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (var o : c) {
            add(o);
        }
        return false;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    /**
     * this method adds the collection at the specified index
     *
     * @param index - specified number to add
     * @param c     - passed collection to add
     * @return true if o is removed, else - false
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        indexCheck(index);
        for (var item : c) {
            add(index, item);
        }
        return false;
    }

    /**
     * this method removes the elements of the passed collection
     *
     * @param c passed collection to remove
     * @return true if o is removed, else - false
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        for (var item : c) {
            remove(item);
        }
        return false;
    }

    /**
     * this method removes all elements except the passed collection
     *
     * @param c - passed collection to remove
     * @return true if o is removed, else - false
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = 0; i < count; i++) {
            var item = get(i);
            if (!c.contains(item))
                remove(item);
        }
        return false;
    }

    /**
     * this method removes all elements of the list
     */
    @Override
    public void clear() {
        first = last = null;
        count = 0;
    }

    /**
     * this method gets the element of the list at the specified index
     *
     * @param index - specified number to receive
     * @return element
     */
    @Override
    public E get(int index) {
        return indexCheck(index).getItem();
    }

    /**
     * this method replaces one of the specified list elements with another
     *
     * @param index   - specified replacement number
     * @param element - passed element to replace
     * @return element
     */
    @Override
    public E set(int index, E element) {
        Node<E> j = indexCheck(index);
        E number = j.getItem();
        j.setItem(element);
        return number;
    }

    /**
     * Add element at specified index
     *
     * @param index   - specified number to add
     * @param element -  passed element to add
     */
    @Override
    public void add(int index, E element) {
        if (index == count) {
            add(element);
        } else {
            linkBefore(element, indexCheck(index));
        }
    }

    /**
     * Removing an element by index
     *
     * @param index - specified index to remove
     * @return removed element
     */
    @Override
    public E remove(int index) {
        return del(indexCheck(index));
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     *
     * @param o - object to check
     * @return index
     */
    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.getNext()) {
                if (x.getItem() == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.getNext()) {
                if (o.equals(x.getItem())) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
     *
     * @param o - bject to check
     * @return index
     */
    @Override
    public int lastIndexOf(Object o) {
        int index = count;
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.getNext()) {
                count--;
                if (x.getItem() == null) {
                    return index;
                }

            }
        } else {
            for (Node<E> x = last; x != null; x = x.getPrev()) {
                count--;
                if (o.equals(x.getItem())) {
                    return index;
                }
            }
        }
        return -1;
    }

    Node<E> indexCheck(int index) {
        Node<E> x;
        if (index < (count / 2)) {
            x = first;
            for (int i = 0; i < index; i++)
                x = x.getNext();
        } else {
            x = last;
            for (int i = count - 1; i > index; i--)
                x = x.getPrev();
        }
        return x;
    }

    public E del(Node<E> x) {
        if (x.getPrev() == null) {
            first = x.getNext();
        } else {
            x.getPrev().setNext(x.getNext());
            x.setPrev(null);
        }
        if (x.getNext() == null) {
            last = x.getPrev();
        } else {
            x.getNext().setPrev(x.getPrev());
            x.setNext(null);
        }
        x.setItem(null);
        count--;
        return x.getItem();
    }

    void linkBefore(E e, Node<E> succ) {
        Node<E> pred = succ.getPrev();
        Node<E> newNode = new Node<>(pred, e, succ);
        succ.setPrev(newNode);
        if (pred == null)
            first = newNode;
        else
            pred.setNext(newNode);
        count++;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListIterator1();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        indexCheck(index);
        return new ListIterator1();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    class ListIterator1 implements ListIterator {
        final LinkedMethods<E> newlinkedMethods = new LinkedMethods<>();

        @Override
        public boolean hasNext() {
            if (first.getNext() == null) {
                return false;
            }
            return true;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return first.getNext().getItem();
            }
            return null;
        }

        @Override
        public boolean hasPrevious() {
            if (first.getPrev() == null) {
                return false;
            }
            return true;
        }

        @Override
        public Object previous() {
            if (hasPrevious()) {
                return first.getPrev().getItem();
            }
            return null;
        }

        @Override
        public int nextIndex() {
            return indexOf(first.getNext());
        }

        @Override
        public int previousIndex() {
            return lastIndexOf(first.getPrev());
        }

        @Override
        public void remove() {
            newlinkedMethods.remove(indexOf(first));

        }

        @Override
        public void set(Object o) {
            newlinkedMethods.set(indexOf(first), (E) o);

        }

        @Override
        public void add(Object o) {
            newlinkedMethods.add((E) o);

        }
    }
}
