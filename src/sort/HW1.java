//22212081 문찬주

import java.util.Arrays;


public class HW1 {
    public static void main(String[] args) {
        Solution1 S = new Solution1();
        int[] numbers = {5, 0, 2, 7};
        System.out.println("입력 = " + Arrays.toString(numbers));
        System.out.println("출력 = " + Arrays.toString(S.solution(numbers)));
    }
}

class Solution1 {
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int maxLength = (N * (N - 1)) / 2;
        int[] arr = new int[maxLength];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                arr[count++] = (numbers[i] + numbers[j]);
            }
        }

        for (int i = 1; i < count; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        return arr;
    }
}
