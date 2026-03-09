package sort;

public class SelectionSort extends AbstractSort {
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            int min =i; //선택할 후보를 min으로 저장
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    //j가 더 작으면
                    min = j;
                }
                //min의 최신화
            }
            exch(a,i,min); //exch 로 최종 교환
        }
    }

    public static void main(String[] args) {
        Integer[] a = {10, 4, 3, 2, 1, 5, 6, 7, 8, 9};
        sort(a);
        show(a);
    }
}