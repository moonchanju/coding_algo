package searchStructure;

class Node<K, V> {

    K key; // 키
    V val; // 값
    Node<K, V> next; // 다음 노드를 가리키는 포인터

    public Node(K key, V val, Node<K, V> next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}

//클래스에서 제네릭 사용 시 제네릭 선언이 필수 -> <k,v>
public class SequentialSearchST <K,V> {
    private Node<K,V> first;
    int N;

    // get 메소드 구현
    // 찾고하 하는 key 존재시 해당 key 의 val 반환, 없을 시 null 반환
    public V get(K key) {
        for(Node <K,V> x=first;x!=null; x = x.next)
        {
            if(key.equals(x.key))
            {
                return x.val;
            }
        }
        return null;
    }

}


