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
    //주어진 Key 에 해당하는 값을 반환 , 키가 없으면 Null
    public V get(K key)
    {
        if(root == null) return null;
        Node<K,V> x = treeSearch(key);
        if(key.equals(x.key)) return x.val;
        //treeSearch 반환값 기준 equals 로 비교
        else
        {
            return null;
        }

    }
}
