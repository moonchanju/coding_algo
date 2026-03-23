//22212081 문찬주
package sort;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

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
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
    }
}

class Solution2 {
    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head;
        ListNode dummy = new ListNode(0);

        while (cur != null)
        {
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val < cur.val)
            {
                prev = prev.next;
            }

            ListNode newNode = cur.next;

            cur.next = prev.next ;
            prev.next = cur;

            cur = newNode;
        }
        return dummy.next;
    }

}
