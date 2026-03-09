package sort;

public abstract class AbstractSort {
    public static void sort(Comparable[] a) {
    } //sort 함수 하위 클래스에서 구현 예정

    //Comparable (타입) -> 자바 내장함수로, 객체끼리의 비교를 가능하게 해줌, 현재는 배열 형태의 매개변수로 줌
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
        // v가 w 보다 작으면 음수, 같으면 0 크면 양수를 반환하ㅁ는데
        // < 0 으로의 비교 연산을 통하면 -> 불린 값이 반환됨.
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] b) {
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i] + " ");
            System.out.println();
        }
    }

    public static boolean isSorted(Comparable[] c) {
        for (int i = 0; i < c.length - 1; i++) {
            if (less(c[i], c[i + 1]) == false) return false;
            //less 메서드 사용, 인덱스 비교해가며 앞이 뒤보다 큰 순간이나오면 -> false 가 됨 -> return false 로 정렬 여부 반환
        }
        return true; // 정상 정렬 시 반환
    }
}