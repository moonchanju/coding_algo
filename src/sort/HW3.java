package sort;

//문제 이해
//좌표 압축 -> 본인 보다 작은 값들의 개수를 의미함. -> 이거 그냥 좌표 개인에 맞추어서 출력하면 됨.


import java.util.Scanner;
import java.util.HashMap;

public class HW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력받기
        int n = sc.nextInt(); //숫자 입력
        int[] A = new int[n]; //A 배열의 크기를 해당 숫자의 크기만큼으로 설정
        for (int i = 0; i < n; i++)
            A[i] = sc.nextInt();
        // 각 인덱스 마다 값을 할당해 A 배열에 저장
        sc.close();
        // 2 4 -10 4 -9

        //원본 배열을 저장하고 있음.
        int[] original = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            original[i] = A[i];
        }

        //삽입 정렬 로직으로 크기별로 1차 정렬
        int a = A.length;
        for (int i = 1; i < a; i++) {
            int key = A[i];
            int j = i - 1;

            while (j >= 0 && key < A[j]) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key; // 삽입위치에 key 삽입
        }
        //-10 -9 2 4 4

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < a; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], rank++); //키와 값 형태로 put
            }
        }
        //키 와 값의 형태로 저장, 정렬을 해두었으므로 차례대로 rank를 가지게 되고

        for (int i = 0; i < a; i++) {
            System.out.print(map.get(original[i])+" "); //조회시 key로만 조회
        }
    }
}