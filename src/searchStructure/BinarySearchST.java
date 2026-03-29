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
        //그러려면 comparable 배열을 사용해 K와 같은 형식의 인자만 담기.
        vals = (V[]) new Object[INIT_CAPACITY];
        //object-> 모든 타입의 객체를 담을수 있는 일반적인 타입
    }

    //배열 크기 명시적 부여
    public BinarySearchST(int capacity) {
        keys = (K[]) new Comparable[capacity];
        vals = (V[]) new Object[capacity];
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }
}
