package searchStructure;


import java.util.ArrayList;

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
        } else {
            Node<K, V> newNode = new Node<K, V>(key, val, null); //삽입할 노드 생성
            if (cmp > 0) //x가 더 크다 -> 새로 삽입한 노드가 좌측에 오도록 하자.
            {
                x.left = newNode;
            } else {
                x.right = newNode;
            }
            newNode.parent = x;
        }
    }

    protected void rebalanceInsert(Node<K, V> x) {
        resetSize(x.parent, 1); // root까지 조상 노드들의 size를 1 증가
    }

    protected void rebalanceDelete(Node<K, V> p, Node<K, V> deleted) {
        resetSize(p, -1);
    }// root까지 조상 노드들의 size를 1 감소

    private void resetSize(Node<K, V> x, int value) {
        for (; x != null; x = x.parent) {
            x.N += value;
        }
    }

    public int size() {
        return (root != null) ? root.N : 0;
    }

    //keys
    //키의 정렬된 리스트를 반환 -> 중위 순회를 사용하면서 keyList에 담음.
    public Iterable<K> keys() {
        if (root == null) return null;
        ArrayList<K> keyList = new ArrayList<K>(size());
        //arraylist 로 순회결과를 동적으로 담음.
        inorder(root, keyList);
        return keyList;
    }

    private void inorder(Node<K, V> x, ArrayList<K> keyList)
    //매개변수로 순회 기점이 되는 x, 순회 결과를 도중에 담기위해 keyList를 넘겨둠
    {
        inorder(x.left, keyList);
        //좌측 순회
        keyList.add(x.key);
        //키를 담고
        inorder(x.right, keyList);
        //우측순회
        //이거 정형화된 틀이니 익혀두도록
    }

    //delete
    //삭제의 경우의 수
    //삭제할 노드가 루트인 경우 -> 루트이며 리프 , 루트이며 자식1개 , 루트이며 자식 2개
    //삭제할 노드의 자식이 있는 경우 -> 자식 2개, 자식 1개 , 자식 없음
    public void delete(K key) {
        if (root == null) return;
        Node<K, V> x, y, p;
        x = treeSearch(key); // 삭제할 노드 x
        if (!key.equals(x.key)) return; // 해당 노드가 존재하지 않을 경우 return

        //but ! 해당 코드는 루트인 부분과 자식 2개인 부분을 한대 묶어 if 로 처리
        if (x == root || isTwoNode(x)) //root 이거나 자식이 두개인 경우
        {
            // 루트이며 리프 -> 루트 삭제후 종료
            if (isLeaf(x)) {
                root = null;
                return;
            }
            //루트이며 자식이 하나 -> 자식을 루트로 올리고 해당 자식의 부모 포인터를 null
            else if (!isTwoNode(x)) {
                root = (x.left == null) ? x.right : x.left; //삼항 연산자로 자식의 위치를 찾아 root 로 올리기
                root.parent = null;
                return;
            }
            // 자식이 둘 ( 루트이며 자식이 둘인 경우도 포함이 됨)
            // successor 을 찾아서 root의 자리에 올리는 역할
            else {

                // min -> 해당 서브트리의 가장 작은 Key 값 return
                //successor = y
                y = min(x.right);

                //루트 자리에 succesor 값 이식
                x.key = y.key;
                x.val = y.val;

                //successor의 부모인 p -> successor의 자식과 이어주는 역할을 함
                p = y.parent;
                //relink 는 부모와 자식을 연결해주는 작업을 함, parent , child, makeleft(어느쪽 자식인가?) 의 인자를 가져감.
                //y.right를 자식으로 넣은 이유 -> successor은 우측 자식만 있을수있음.
                relink(p, y.right, y == p.left); //
                rebalance(p.y);
            }
        } else // 자식이 1개 또는 0개인 경우 처리
        //루트가 아님 , 즉 삭제할 시 본인의 자식이 있다면 부모와 연결 시켜주는 작업이 필요.]
        {
            //relink 사용 방식 -> 삭제할 노드의 부모 변수 설정, 삭제할 자식 변수 설정, 왼쪽 자식인가에 대한 매개변수 설정
            //자식이 없는 경우는 x.left , x.right 가 null로 처리 되므로 -> 자연스레 p와 null이 이어지므로 삭제 처리
            p = x.parent;
            if (x.right == null) {
                relink(p, x.left, p == x.left);
            } else if (x.left == null) {
                relink(p, x.right, p == x.right);
            }
            rebalanceDelete(p, x);
        }
    }

    //relink
    //삭제 노드 제거 후 연결을 도와주는 역할
    protected void relink(Node<K, V> parent, Node<K, V> child, boolean makeleft) {
        //연결 설정 시 자식과 부모 입장 에서의 연결 설정 총 2개가 필요함.

        //자식의 연결 설정
        if (child != null) {
            child.parent = parent; //
        }

        //부모의 연결 설정
        if (makeleft) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    //min
    //successor 발견용도
    //최소 key 값을 구할 때 에는 항상 왼쪽으로
    protected Node<K, V> min(Node<K, V> x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    public K min() {
        if (root == null) return null;
        Node<K, V> x = root;
        while (x.left != null)
        {
            x = x.left;
        }
        return x.key;
    }

    public K max() {
        if (root == null) return null;
        Node<K, V> x = root;
        while (x.right != null) {
            x = x.right;
        }
        return x.key;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    protected boolean isLeaf(Node<K, V> x) {
        return x.left == null && x.right == null;
    }

    protected boolean isTwoNode(Node<K, V> x) {
        return x.left != null && x.right != null;
    }


}
