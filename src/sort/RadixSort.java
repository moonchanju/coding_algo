//기수 정렬 코드

//LDS 기준으로 구성한거라 낮은자리부터 정렬해 나감.
//0부터 9까지의 버킷을 마련해두고 -> 각 자리에 해당하는 버킷에 넣어주고
//기수정렬의 반복을 통한 정렬 완료.

package sort;

public class RadixSort {
    public static int[] sort(int[] A) {
        int t = A.length;
        int exp = 1; //자리수 (1의 자리부터 검색)

        int[] B = new int[t]; //정렬 결과를 임시로 저장할 배열 ,최종적으로 쓰기도 함
        int m = -1; // A 배열 중 가장 큰 수를 저장.
        for (int i = 0; i < t; i++) {
            if (A[i] > m) m = A[i];
        } //가장 높은 수를 탐색
        while (m / exp > 0) // 자리수를 넘어선 정렬을 하려하는 경우 종료
        {
            int[] C = new int[10]; //0~9 까지의 버킷 10개를 마련 (배열로)
            for (int i = 0; i < t; i++) { //범위가 t까지인 이유-> 원 배열 A 배열에 속한 값만 C에 넣음
                C[(A[i] / exp) % 10]++;
            } // 자리별 합 계산 (현재 자리수 확인 로직 추가)
            for (int i = 1; i < 10; i++) {
                C[i] += C[i - 1];
            }//자리별 누적합 계산}
            for (int i = t - 1; i >= 0; i--) {
                B[--C[(A[i] / exp) % 10]] = A[i]; // B 배열에 값 할당.
            }
            for (int i = 0; i < B.length; i++) {
               A[i]=B[i]; // 정렬 결과를 그 다음 정렬의 입력으로 사용됨.
            }
            System.out.println();
            exp *= 10; //다음 자리수 탐색을 위한 exp 증가 (10,100,..)

        }
        return B; // 최종 결과를 return

    }

    public static void main(String[] args) {
        int[] A = {179, 208, 306, 93, 859, 984, 55, 9, 271, 33};
        int[] b = RadixSort.sort(A);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }

}
