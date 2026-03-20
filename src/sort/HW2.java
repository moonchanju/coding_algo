package sort;

class ListNode {
    int val;
    ListNode next; //다음 위치를 가리키는 포인터

    ListNode() {
    }

    ;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class HW2 {
    public static void main(String[] args) {
        ListNode head = null;
        ListNode node5 = new ListNode(0);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(5, node3);
        ListNode node1 = new ListNode(-1, node2);
        head = node1;
        Solution2 sol = new Solution2();
        head = sol.insertionSortList(head);
        printList(head);
    }

    private static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }
    }
}

class Solution2 {
    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head ; // 첫번째 노드를 가리키는 포인터
        ListNode dummy = new ListNode(0); //기존 연결리스트에서 새로운 연결을 취해주기
        //위한 더미노드를 만듦.
        while(cur!=null) // cur이 마지막이 아닐동안
        {
            ListNode prev = dummy; // dummy 노드를 가리키는 포인터
        }
    }

}

