//22212081 문찬주
package sort;


import java.util.Scanner;
import java.util.HashMap;

public class HW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = sc.nextInt();
        sc.close();

        int[] original = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            original[i] = A[i];
        }
        int a = A.length;
        for (int i = 1; i < a; i++) {
            int key = A[i];
            int j = i - 1;

            while (j >= 0 && key < A[j]) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < a; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], rank++);
            }
        }

        for (int i = 0; i < a; i++) {
            System.out.print(map.get(original[i])+" ");
        }
    }
}