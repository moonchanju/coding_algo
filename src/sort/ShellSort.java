//쉘 정렬 코드
package sort;

public class ShellSort extends AbstractSort{
    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1; //최적의 간격을 찾는 코드 -> 배열 길이 10 기준 h(간격) =4

        while (h >= 1) // 반복문을 통한 간격 줄여가기
        {
            for (int i = h; i < n; i++) {
                //간격 h를 기준에 정렬 원소 선정
                for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h)
                //간격 h 에 맞추어 삽입 정렬
                {
                    exch(a,j,j-h); //바로 교환
                }
            }
            h/=3; //간격을 줄여가며 탐색
        }
    }

    public static void main(String[] args)
    {
        Integer [] a = {5,6,7,8,9,1,2,3,4,10};
        ShellSort.sort(a);
        ShellSort.show(a);
    }

}
