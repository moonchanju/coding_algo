package searchStructure;

import java.util.ArrayList;

class Node<K, V> {
    public Node<K, V> next;
    public Node<K, V> left, right;
    K key;
    V val;
    int N; // 자손 노드 + 1 (ordered 연산)
    int aux; // AVL 트리나 RB 트리에 사용
    Node<K, V> parent; // AVL or RB

    public Node(K key, V val, Node<K, V> next) {
        this.key = key;
        this.val = val;
        this.next = next;
        this.N = 1;
    }

    public int getAux() {
        return aux;
    }

    public void setAux(int value) {
        aux = value;
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
    public void push(K key, V val) {
        for (Node<K, V> x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return; // 반환값이 void 더라도 함수 종료 필요시 return 해줄수있음.
            }
        }
        //새로운 key 삽입 시 -> first 를 새로 생성, 기존 first 의 포인터에 삽입하여 first의 위치를 바꾸어줌.
        first = new Node<K, V>(key, val, first);
        N++; //노드 개수 증가 표시
    }

    //delete 메소드 구현
    //이전 노드를 기준으로 구현
    //first 노드는 이전 노드가 없으므로 따로 빼서 구현
    public void delete(K key) {
        //first 삭제
        if (key.equals(first.key)) {
            first = first.next;
            N--;
            return;
        }
        //이외 노드 삭제 (삭제할 노드는 항상 이전 노드의 다음노드 -> x.next)
        for (Node<K, V> x = first; x.next != null; x = x.next) {
            if (key.equals(x.next.key)) {
                x.next = x.next.next;
                N--;
                return;
            }
        }
    }

    //keyList 구현
    //Iterable -> 객체를 반복해서 사용 할 경우 사용
    public Iterable<K> keys() {
        ArrayList<K> keyList = new ArrayList<K>(N);
        for (Node<K, V> x = first; x != null; x = x.next) {
            keyList.add(x.key);
        }
        return keyList;
    }


    public class Main {
        public static void main(String[] args) {

            // 객체 생성
            SequentialSearchST<String, Integer> st = new SequentialSearchST<>();

            // 데이터 삽입
            st.push("apple", 10);
            st.push("banana", 20);

            // 값 가져오기
            System.out.println("apple: " + st.get("apple"));

            // 전체 key 출력
            for (String key : st.keys()) {
                System.out.println(key);
            }

            // 삭제
            st.delete("banana");

            System.out.println("After delete:");
            for (String key : st.keys()) {
                System.out.println(key);
            }
        }
    }
}
