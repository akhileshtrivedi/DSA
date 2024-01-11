package advanced.feb_27;

class LongestPalindromicList {

  static class ListNode {

    int val;
    ListNode next;
  }

  static int countCommon(ListNode a, ListNode b) {
    int count = 0;

    for (; a != null && b != null;
        a = a.next, b = b.next) {
      if (a.val == b.val) {
        ++count;
      } else {
        break;
      }
    }
    return count;
  }

  static int maxPalindrome(ListNode A) {
    int result = 0;
    ListNode prev = null, curr = A;

    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;

      result = Math.max(result,
          2 * countCommon(prev, next) + 1);

      result = Math.max(result,
          2 * countCommon(curr, next));
      prev = curr;
      curr = next;
    }
    return result;
  }

  static ListNode newNode(int key) {
    ListNode temp = new ListNode();
    temp.val = key;
    temp.next = null;
    return temp;
  }

  public static void main(String[] args) {
    ListNode head = newNode(2);
    head.next = newNode(4);
    head.next.next = newNode(3);
    head.next.next.next = newNode(4);
    head.next.next.next.next = newNode(2);
    head.next.next.next.next.next = newNode(15);

    System.out.println(maxPalindrome(head));
  }
}

