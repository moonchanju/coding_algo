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
        ListNode cur = head; // 첫번째 노드를 가리키는 포인터
        ListNode dummy = new ListNode(0);
        //기존 연결리스트에서 새로운 연결을 취해주기
        //위한 더미노드를 만듦. -> 연결리스트으 삽입과 삭제에서 유리하려나
        while (cur != null) // cur이 마지막이 아닐동안
        {
            ListNode prev = dummy;
            // dummy 노드를 가리키는 포인터
            // 연결리스트는 삽입대상 노드의 이전 노드(prev) 통해서만 삽입, 삭제가 가능하기에

            while (prev.next != null && prev.next.val < cur.val)
            // 삽입될 자리의 노드를 찾으려면 이전노드의 다음노드를 대상으로 검사를 해야함.
            //해당 자리가 삽입이 될 자리의 노드. prev.next 가 cur의 후보가 됨.
            {
                prev = prev.next; // prev의 포인터를 옮겨주며 자리를 찾아감.
            }

            ListNode newNode = cur.next;
            //기존 노드의 위치를 저장해줘야함
            //왜 ? 순서를 바꿔가면서 하는 정렬 이기에 기존 처리해야할 노드의 다음위치를 기억해둔 후

            //여기서 일단 정렬의 위치를 바꿔주고
            cur.next = prev.next ; //새로운 연결 먼저
            prev.next = cur; //기존 연결 수정

            //여기서 기존 처리해야할 노드대로 다시 이동해서 while 문에 삽입.
            cur = newNode;
        }
        return dummy.next;
    }

}

