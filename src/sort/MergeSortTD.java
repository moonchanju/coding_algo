//병합정렬 코드 (탑 다운)
package sort;

public class MergeSortTD extends AbstractSort {
    public static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            aux[i] = a[i];
            //원본 배열을 임시 배열에게 복사해줌 -> low~high 에 해당하는 구간의 값을 정렬해서 재배치하기 위함.
        }
        //임시배열에 값을 복사해 넣어 -> 값을 꺼내서 정렬하며 원본배열을 수정해주는 느낌

        int i = low; //왼쪽 배열 첫 인덱스
        int j = mid + 1; //오른쪽 배열 첫 인덱스

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } //왼쪽 배열을 전부 검사 한 경우 -> 우측 배열을 모두 가져다 붙이면 됨.
            else if (j > high) {
                a[k] = aux[i++];
            } //오른쪽 배열을 전부 검사 한 경우 -> 좌측 배열을 전부 가져다 붙이면 됨
            else if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } //좌측이 더 작은 경우
            else {
                a[k] = aux[j++];
            } //우측이 더 작은 경우
        }


    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length]; //분할 한 배열을 담아줄 임시 배열
        sort(a, aux, 0, a.length - 1); //매개변수의 개수가 다른 sort 함수는 개별로 취급
    }

    public static void sort(Comparable[] a, Comparable[] aux, int low, int high)
    //a 원본 배열과, aux 임시배열, low 시작 인덱스와, high 끝 인덱스
    {
        if (low >= high) {
            return; // 길이가 1이 된 경우 ( 분할이 끝난 경우 ) return 으로 재귀 종료
        }
        int mid = low+ (high - low) / 2; // (중요 코드) 현재 부분을 두 부분으로 나눌때 중간 지점이 될 인덱스
        sort(a, aux, low, mid); //좌측 배열 재귀
        sort(a, aux, mid + 1, high); //우측 배열 재귀
        if(less(a[mid],a[mid+1])) return; // 이미 정렬이 되어있을 경우 병합할 필요 x -> 성능 개선
        merge(a, aux, low, mid, high); //재귀가 끝나는 시점에서 병합
    }

    public static void main(String[] args) {
        Integer[] a = {4, 5, 6, 1, 2, 3};
        // Comparable -> 객체 중심의 자료만 다룬다 .
        //따라서 참조형을 사용한 객체형식으로 배열을 만든다.
        MergeSortTD.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
