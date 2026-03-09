//삽입정렬 코드
package sort;

public class InsertionSort extends AbstractSort{

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i <N;i++)
        //마지막 요소까지 봐야하므로 N 까지 봄
            //1부터 보는 이유는 -> 아래 for 문에서 0번째와 비교할 것 이기때문
        {
            for(int j=i;j>0&&less(a[j],a[j-1]);j--)
            //j 가 j-1 보다 작은 경우 true -> 반복문 실행 (교체해주어야함.)
            {
                exch(a,j,j-1);
                //하나씩 교환하며 내려가야함
            }
        }
    }

    public static void main(String[] args)
    {
        Integer [] a = {5,6,7,8,1,2,3,4,9,10};
        sort(a);
        show(a);
    }
}
