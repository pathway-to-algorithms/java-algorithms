package linked.list.S1_BasicInterweaving;

import static linked.list.S1_BasicInterweaving.ListNode.createLinkedList;
import static linked.list.S1_BasicInterweaving.ListNode.printLinkedList;

public class L2_AddTwoNumber {

  public static void main(String[] args) {
    ListNode l1 = createLinkedList(new int[]{2, 4, 3});
    ListNode l2 = createLinkedList(new int[]{5, 6, 4, 1});
    printLinkedList(addTwoNumbers(l1, l2));
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
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    long num1 = linkedListToLong(l1);
    long num2 = linkedListToLong(l2);
    long sum = num1 + num2;

    ListNode listNode = new ListNode((int) (sum % 10));
    sum /= 10;
    ListNode curr = listNode;
    while (sum >= 1) {
      curr.next = new ListNode((int) (sum % 10));
      curr = curr.next;
      sum /= 10;
    }
    return listNode;
  }

  private static long linkedListToLong(ListNode l1) {
    StringBuilder stringBuilder = new StringBuilder();
    while (l1 != null) {
      stringBuilder.insert(0, l1.val);
      l1 = l1.next;
    }
    return Long.parseLong(stringBuilder.toString());
  }
}
