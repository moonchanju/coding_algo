//병합 정렬 코드 (바텀 업)
package sort;

public class MergeSortBU extends AbstractSort {
    public static void merge(Comparable[] before, Comparable[] after, int low, int mid, int high) {
        //before은 정렬 전, after은 정렬 후를 기점으로 after이 정렬된 배열의 값을 담고 있어야함.
        int i = low; //왼쪽 배열의 시작 인덱스
        int j = mid + 1; //오른쪽 배열의 시작 인덱스
        for (int k = low; k <= high; k++) {
            //한쪽 배열을 다 읽었을 경우
            if (i > mid) //왼쪽 배열을 다 읽었을 경우
            {
                after[k] = before[j++];
            } else if (j > high) { //우측 배열을 다 읽었을 경우
                after[k] = before[i++];
            }
            //왼,오 배열의 값을 비교 해야하는 경우
            else if (less(before[i], before[j])) {
                after[k] = before[i++];
            } else {
                after[k] = before[j++];
            }
        }
    }

    public static void sort(Comparable[] a) {
        Comparable[] src = a; //원본배열
        Comparable[] dst = new Comparable[a.length]; //복사한 배열
        Comparable[] tmp;
        //BU 는 가장 작은 원소부터 점점 늘려가는 기법이다.
        for (int n = 1; n < a.length; n *= 2)
        // 배열크기 순으로 반복문 -> 크기가 1인 경우 , 크기가 2인 경우 , 크기가 4인 경우 ...
        {
            for (int i = 0; i < a.length; i += 2*n) {
                //2*n -> 크기가 1 일 경우 위치 2씩, 2일 경우 위치 4씩 이동이 되어 Merge 실행되어야함.
                merge(src, dst, i, i + n - 1, Math.min(i + 2 * n - 1, a.length - 1));
                //처음 , 중간, 끝 인덱스를 계산
                //끝 인덱스가 하나만 남는 경우(전체 개수가 홀수인 경우)를 대비한 Math.min 처리 -> 해당 경우만 a.length-1이 더 작아 채택.
                //짝수인 경우는 Math.min에서 동일한 값이 나와 상관이 없게 됨.
            }

            //정렬 결과가 다음 정렬의 입력으로 쓰여야함
            tmp = src;
            src = dst;
            dst = tmp;
        }
        if (src != a) System.arraycopy(src, 0, a, 0, a.length);
    }

    public static void main(String[] args) {
        Integer[] a = {4, 3, 2, 1, 5, 6, 7};
        MergeSortBU.sort(a);
        for (int i = 0; i < a.length; i++) {
           System.out.print(a[i] + " ");
        }
    }
}
