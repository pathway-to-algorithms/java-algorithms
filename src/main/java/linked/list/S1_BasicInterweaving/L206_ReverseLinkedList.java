package linked.list.S1_BasicInterweaving;

import static linked.list.S1_BasicInterweaving.ListNode.createLinkedList;
import static linked.list.S1_BasicInterweaving.ListNode.printLinkedList;

import java.util.Stack;

/*
 * Reverse Linked List
 */
public class L206_ReverseLinkedList {

  public static void main(String[] args) {
    ListNode l = createLinkedList(new int[]{0, 1, 2, 3, 4, 5});
    printLinkedList(reverseListByStack(l));    // expects 5->4->3->2->1->0->NULL
  }

  /*
  * Coding
  * 校验：
      -	list node 规范
  * 中间变量：双指针，curr 表示当前链表头结点，prev 表示反转链表头节点
  * 遍历：while（迭代）
  * 操作：
      - 将 curr 的节点，依次拼接到 prev 之前
  * 复杂度分析：
  * 	- 时间复杂度：O(n)
  * 	- 空间复杂度：O(1)
  */
  public static ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  /*
   * Coding
   * 校验：
   *   -	list node 规范
   * 中间变量：newHead 反转的链表，head 新链表
   * 遍历：递归
   * 操作：
   *  - 递归到最后一个节点，然后在反向。使用引用特性。
   * 复杂度分析：
   * 	- 时间复杂度：O(n)
   * 	- 空间复杂度：O(n)
   */
  public static ListNode reverseListByRecursive(ListNode head) {
    if (head.next == null) {
      return head;
    }
    ListNode newHead = reverseListByRecursive(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }

  /*
   * 复杂度分析：
   * 	- 时间复杂度：O(n)
   * 	- 空间复杂度：O(n)
   */
  public static ListNode reverseListByStack(ListNode head) {
    Stack<ListNode> stack = new Stack<>();

    while (head != null) {
      stack.push(head);
      head = head.next;
    }

    ListNode newHead = new ListNode(), curr = newHead;

    while (!stack.isEmpty()) {
      curr.next = stack.pop();
      curr = curr.next;
    }
    curr.next = null;
    return newHead.next;
  }


}
