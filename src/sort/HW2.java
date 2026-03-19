package sort;

class ListNode {
    int val;
    ListNode next ; //다음 위치를 가리키는 포인터
    ListNode() {};
    ListNode(int val) {this.val = val;}
    ListNode(int val,ListNode next) {this.val = val ; this.next = next;}
}
public class HW2 {
    public static void main(String[] args)
    {
        ListNode head = null;
        ListNode node5 = new ListNode(0);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(4,node4);
        ListNode node2 = new ListNode(4,node3);
        ListNode node1 = new ListNode(4,node2);
        head = node1;
        Solution2 sol = new Solution2();
        head = sol.insertionSortList(head);
        printList(head);
    }

    private static void printList(ListNode head) {
    }
}

class Solution2 {
    public ListNode insertionSortList(ListNode head)
    {
        ListNode cur = head;
        while(cur!=null)
        {
            //정렬 알고리즘 사용

            cur= cur.next;
        }
    }
}
