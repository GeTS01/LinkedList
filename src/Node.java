
public class Node<S> {
    private S item;
    private Node<S> next;
    private Node<S> prev;

    public Node(Node<S> prev, S element, Node<S> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }


    public S getItem() {
        return item;
    }

    public void setItem(S item) {
        this.item = item;
    }

    public Node<S> getNext() {
        return next;
    }

    public void setNext(Node<S> next) {
        this.next = next;
    }

    public Node<S> getPrev() {
        return prev;
    }

    public void setPrev(Node<S> prev) {
        this.prev = prev;
    }
}
