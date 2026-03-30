package searchStructure;


public class BST<K extends Comparable<K>, V> {
    protected Node<K, V> root;

    //treeSearch
    //키를 입력 받아 -> 그 키를 가지는 노드 또는 노드를 가지지 않으면 순회의 마지막 노드를 반환하자 (삽입을 위해서)
    protected Node<K, V> treeSearch(K key) {
        Node<K, V> x = root;

        while (true) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x; //바로 찾음 -> x 반환
            else if (cmp < 0) {//key가 더 작음 -> x 가 더 작아진 범위에서 탐색 진행
                if (x.left == null)
                //x가 리프노드 였다면 -> 키가 없으므로 추후 삽입을 위해 마지막 노드를 반환
                {
                    return x;
                } else {
                    x = x.left;
                }

            } else //cmp>0
            {
                if (x.right == null) {
                    return x;
                } else {
                    x = x.right;
                }
            }
        }
    }

    //get
    //주어진 Key 에 해당하는 값을 반환 , 키가 없으면 null
    public V get(K key) {
        if (root == null) return null;
        Node<K, V> x = treeSearch(key);
        if (key.equals(x.key)) return x.val;
            //treeSearch 반환값 기준 equals 로 비교
        else {
            return null;
        }
    }

    //put
    //원하고자 하는 key를 검색 -> 있으면 값만 바꾸기, 없으면 순회의 마지막 노드에 추가해주기
    public void put(K key, V val) {
        //트리에 아무것도 없을 경우 해당 Key,val을 가진 노드를 생성하고 종료
        if (root == null) {
            root = new Node<K, V>(key, val, null);
            return;
        }
        Node<K, V> x = treeSearch(key); // * 중요 -> 반환값이 key 거나 순회의 마지막 노드(삽입해야할 노드)

        int cmp = key.compareTo(x.key);
        if (cmp == 0)
        // key 찾은 경우 값만 바꾸기.
        {
            x.val = val;
        }
        else
        {
            Node<K,V> newNode = new Node<K,V>(key, val,null); //삽입할 노드 생성
            if(cmp>0) //x가 더 크다 -> 새로 삽입한 노드가 좌측에 오도록 하자.
            {
                x.left = newNode;
            }
            else
            {
                x.right = newNode;
            }
            newNode.parent = x;
        }
    }


}
