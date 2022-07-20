package Cache.main.cache.policies;

import Cache.main.algorithm.DoublyLinkedList;
import Cache.main.algorithm.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    DoublyLinkedList<Key> dll;
    Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy() {
        dll = new DoublyLinkedList<>();
        mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if (mapper.containsKey(key)) {
            dll.detachNode(mapper.get(key));
            dll.addNodeAtLast(mapper.get(key));
        } else {
            DoublyLinkedListNode<Key> node = dll.addElementAtLast(key);
            mapper.put(key, node);
        }
    }

    @Override
    public Key evict() {
        DoublyLinkedListNode<Key> node = dll.getFirstNode();
        if (node == null) {
            return null;
        }
        dll.detachNode(node);
        return node.getElement();
    }
}
