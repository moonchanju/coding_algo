package searchStructure;

class Node<K,V>
{

    K key; // 키
    V val; // 값
    Node <K,V> next; // 다음 노드를 가리키는 포인터
    public Node(K key, V val, Node<K,V> next)
    {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}
public class SequentialSearchST {
}
