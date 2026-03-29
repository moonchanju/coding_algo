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

    //찾으려는 key가 있는지 검사하고 있으면 반환 , 없으면 새로 삽입할 위치를 알려주는 search
    private int search(K key) {
        int low = 0;
        int high = N - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(keys[mid]);
            //찾으려는 key가 keys 배열의 중앙과 비교한 상대 위치를 정수로 받음

            if (cmp < 0) {
                high = mid - 1;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
        //찾으려는 값이 없다면 새로 삽입해야할 단계임으로 low 위치에 삽입할 수 있도록 low 반환
    }

    //찾으려는 key가 있으면 해당 val 반환 , 없으면 null 반환하는 get
    public V get(K key) {
        int i = search(key); // 있으면 -> mid , 없으면 low
        if (i < N && keys[i].compareTo(key) == 0)
        // i 가 배열 범위 내 && search로 반환된 i가 keys 배열에 존재하는지 확인
        {
            return vals[i]; //맞으면 값 리턴
        } else {
            return null;
        }
    }

    public void put(K key, V val) {
        int i = search(key);
        //key가 존재할 경우 값만 바꾸기
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        //key 미존재시 기존 keys 배열의 길이가 꽉 찬 경우 resize 로 배열 길이 늘리기.
        if(N==keys.length)
        {
            resize(2*keys.length);
        }

        //key 미존재시 i 위치에 삽입해야 함으로 -> 기존 N 배열의 i 위치부터 N 까지 모든 값을 뒤로 땡기기.
        for (int j = N; j > i; j--) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        //해당 위치에 삽입
        keys[i] = key;
        vals[i] = val;

        //N 증가로 값이 들어갔음을 표시
        N++;
    }
}
