package searchStructure;

public class BinarySearchST<K extends Comparable<K>, V>
        //제네릭으로 구현 -> 객체 생성시 타입 구체화 필요
{
    //변수 필드
    private static final int INIT_CAPACITY = 10;
    private K[] keys;
    private V[] vals;
    private int N;

    //배열 크기 미정시 기본 값 10 부여
    public BinarySearchST() {
        keys = (K[]) new Comparable[INIT_CAPACITY];
        //K[]로 캐스팅하여 기존 K의 형식 미정의 문제를 우회
        //그러려면 comparable 배열을 사용해 K와 같은 형식의 인자만 담기
        vals = (V[]) new Object[INIT_CAPACITY];
        //object-> 모든 타입의 객체를 담을수 있는 일반적인 타입
    }

    //배열 크기 명시적 부여
    public BinarySearchST(int capacity) {
        keys = (K[]) new Comparable[capacity];
        vals = (V[]) new Object[capacity];
    }

    //기본 메서드 구현
    public boolean contains(K key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    //배열 크기를 동적으로 변경하는 resize
    //capacity 만큼의 크기를 만들고, 기존 배열을 덮어 씌우는 기능
    private void resize(int capacity) {
        //배열 크기 동적 할당
        K[] tempk = (K[]) new Comparable[capacity];
        V[] tempv = (V[]) new Object[capacity];

        for (int i = 0; i < N; i++)
        //실제로 저장된 key-val 쌍의 개수를 의미하는 N
        {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }

        //기존 keys,vals 포인터 수정
        keys = tempk;
        vals = tempv;
    }

    private int search(K key) {
        int low = 0;
        int high = N - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(keys[mid]);
            //찾으려는 key가 keys 배열의 중앙과 비교한 상대 위치를 정수로 받음

            if (cmp < 0) {
                high = mid - 1;
            }
            else if (cmp > 0) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }
        return low;
        //찾으려는 값이 없다면 새로 삽입해야할 단계임으로 low 위치에 삽입할 수 있도록 low 반환
    }
}
