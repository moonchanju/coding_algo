package sort;

//문제 이해
//좌표 압축 -> 본인 보다 작은 값들의 개수를 의미함. -> 이거 그냥 좌표 개인에 맞추어서 출력하면 됨.


import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력받기
        int n = sc.nextInt(); //숫자 입력
        int[] A = new int[n]; //A 배열의 크기를 해당 숫자의 크기만큼으로 설정
        for (int i = 0; i < n; i++)
            A[i] = sc.nextInt();
        // 각 인덱스 마다 값을 할당해 A 배열에 저장
        sc.close();


        //삽입 정렬 로직으로 크기별로 1차 정렬
        int a = A.length;
        for (int i = 1; i < a; i++) {
            int key = A[i];
            int j = i - 15

            while (j >= 0 && key < A[j]) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key; // 삽입위치에 key 삽입
        }


    }
}