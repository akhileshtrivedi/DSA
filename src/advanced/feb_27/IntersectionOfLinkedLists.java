package advanced.feb_27;

import java.util.HashSet;

class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

class IntersectionOfLinkedLists {

  private static int findLength(ListNode temp) {
    int l = 0;
    while (temp != null) {
      l++;
      temp = temp.next;
    }
    return l;
  }

  private static ListNode findMerge(ListNode h1, ListNode h2, int l1, int l2) {
    ListNode t1 = h1;
    ListNode t2 = h2;

    for (int i = 0; i < l1 - l2; i++) {
      t1 = t1.next;
    }
    HashSet<ListNode> hs = new HashSet<ListNode>();
    while (t1 != null && t2 != null) {
      if (t1.val == t2.val) {
        return t1;
      }
      t1 = t1.next;
      t2 = t2.next;
    }
    return null;
  }

  private static ListNode getIntersectionNode(ListNode A, ListNode B) {

    int l1 = findLength(A);
    int l2 = findLength(B);

    ListNode ans = null;
    if (l1 > l2) {
      ans = findMerge(A, B, l1, l2);
    } else {
      ans = findMerge(B, A, l2, l1);
    }
    Print(ans);
    return ans;

  }

  public static void main(String[] args) {
    // list 1
    ListNode n1 = new ListNode(1);
    n1.next = new ListNode(2);
    n1.next.next = new ListNode(3);
    n1.next.next.next = new ListNode(4);
    n1.next.next.next.next = new ListNode(5);
    // n1.next.next.next.next.next = new ListNode(6);
    //n1.next.next.next.next.next.next = new ListNode(7);
    // list 2
    ListNode n2 = new ListNode(6);
    n2.next = new ListNode(3);
    n2.next.next = new ListNode(4);
    n2.next.next.next = new ListNode(5);
   // n2.next.next.next.next = n1.next.next.next.next;
    Print(n1);
    Print(n2);
    System.out.println(MegeNode(n1, n2).val);
    System.out.println(getIntersectionNode(n1, n2).val);
  }

  public static void Print(ListNode n) {
    ListNode cur = n;
    while (cur != null) {
      System.out.print(cur.val + " ");
      cur = cur.next;
    }
    System.out.println();
  }

  public static ListNode MegeNode(ListNode n1, ListNode n2) {

    HashSet<ListNode> hs = new HashSet<ListNode>();
    while (n1 != null) {
      hs.add(n1);
      n1 = n1.next;
    }
    while (n2 != null) {
      if (hs.contains(n2)) {
        return n2;
      }
      n2 = n2.next;
    }
    return null;
  }
}
