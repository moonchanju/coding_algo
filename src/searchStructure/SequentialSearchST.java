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
public class SequentialSearchST<K, V> {
    private Node<K, V> first;
    int N;

    // get 메소드 구현
    // 찾고하 하는 key 존재시 해당 key 의 val 반환, 없을 시 null 반환
    public V get(K key) {
        for (Node<K, V> x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    //push 메소드 구현
    //같은 key 삽입 시 -> 값만 바꿔주기
    //새로운 key 삽입 시 -> 기존 first 위치에 삽입 후 포인터 변경
    public void push(K key,V val) {
        for (Node<K, V> x = first; x != null; x = x.next) {
            if(key.equals(x.key)) {
                x.val = val;
            }
        }
        //새로운 key 삽입 시 -> first 를 새로 생성, 기존 first 의 포인터에 삽입하여 first의 위치를 바꾸어줌.
        first = new Node <K,V> (key,val,first);
    }
}


