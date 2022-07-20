package Cache.main.algorithm;

public class DoublyLinkedList<E> {
    DoublyLinkedListNode<E> dummyHead;
    DoublyLinkedListNode<E> dummyTail;

    public DoublyLinkedList() {
        dummyHead = new DoublyLinkedListNode<>(null);
        dummyTail = new DoublyLinkedListNode<>(null);

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public void detachNode(DoublyLinkedListNode<E> node) {
        if (node != null) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }

    public void addNodeAtLast(DoublyLinkedListNode<E> node) {
        DoublyLinkedListNode<E> prevDummyTail = dummyTail.prev;
        prevDummyTail.next = node;
        node.prev = prevDummyTail;
        node.next = dummyTail;
        dummyTail.prev = node;
    }

    public DoublyLinkedListNode<E> addElementAtLast(E element) {
        DoublyLinkedListNode<E> node = new DoublyLinkedListNode<>(element);
        addNodeAtLast(node);
        return node;
    }

    public boolean isItemPresent() {
        return dummyHead.next != dummyTail;
    }

    public DoublyLinkedListNode<E> getFirstNode() {
        if (!isItemPresent()) return null;
        return dummyHead.next;
    }

    public DoublyLinkedListNode<E> getLastNode() {
        if (!isItemPresent()) return null;
        return dummyTail.prev;
    }
}
