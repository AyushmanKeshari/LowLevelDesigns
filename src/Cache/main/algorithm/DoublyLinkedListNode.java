package Cache.main.algorithm;

import lombok.Getter;

@Getter
public class DoublyLinkedListNode<E> {
    DoublyLinkedListNode<E> prev;
    public DoublyLinkedListNode<E> next;
    E element;

    public DoublyLinkedListNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}
