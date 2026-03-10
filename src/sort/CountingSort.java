//카운팅 소트 코드
package sort;

public class CountingSort {
    public static int[] sort(int[] A, int K) {
        int a = A.length;
        int[] B = new int[a]; //최종배열 마련
        int[] C = new int[K]; //임시배열 마련
        //모든 값이 0으로 채워집 배열 객체를 만듦.

        for (int i = 0; i < a; i++) {
            //원본배열 순회하며 임시배열에 넣기
            C[A[i]]++;

        } // 자리별 합 계산 [0,3,1,1,1]


        for (int i = 1; i < K; i++) {
            C[i] += C[i - 1];
        } //누적 합 계산 (위치정보를 가지고 있음) [0,3,4,5,6]


        for (int i = a - 1; i >= 0; i--) {
            B[--C[A[i]]] = A[i];
        } //최종 배열에 값 할당 [1,1,1,2,3,4]

        return B;
    }

    public static void main(String[] args) {
        int [] a = {2, 3, 4, 1, 1, 1}; //
        int[] b = CountingSort.sort(a, 5); //K 값은 임시배열에 사용할 용도 -> a 배열의 가장 큰 값+1 로 주기
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+" ");
        }
    }
}
