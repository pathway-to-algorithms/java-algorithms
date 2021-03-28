package linked.list.S1_BasicInterweaving;

// 链表节点类
public class ListNode {

  public int val;        // Have to make the attributes and the methods public
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  public ListNode() {
  }

  public ListNode get(int i) {  // 获取并返回第 i 个节点
    ListNode curr = this;
    while (curr.next != null && i != 0) {
      curr = curr.next;
      i--;
    }
    return i == 0 ? curr : null;
  }

  public ListNode tail() {  // 找到并返回链表中的最后一个节点（SEE: L160_IntersectionOfTwoLinkedLists）
    ListNode curr = this;
    while (curr.next != null) {
      curr = curr.next;
    }
    return curr;
  }

  // 从数组生成链表
  public static ListNode createLinkedList(int[] arr) {
    ListNode dummyHead = new ListNode();
    ListNode curr = dummyHead;
    for (int n : arr) {
      curr.next = new ListNode(n);
      curr = curr.next;
    }
    return dummyHead.next;
  }

  // 打印链表
  public static void printLinkedList(ListNode head) {
    StringBuilder s = new StringBuilder();
    while (head != null) {
      s.append(head.val);
      s.append("->");
      head = head.next;
    }
    s.append("NULL");
    System.out.println(s.toString());
  }

}
