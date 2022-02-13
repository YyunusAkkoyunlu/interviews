package preperation.crackingTheCodingInterview.chapterTwoLinkedLists;

public class Palindrome {

    public boolean isPalindrome(LinkedListNode head) {
        LinkedListNode reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    private LinkedListNode reverseAndClone(LinkedListNode node) {
        LinkedListNode head = null;
        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.data); // clone
            n.next = head;
            head = n;
            node = node.next;
        }

        return head;
    }

    private boolean isEqual(LinkedListNode one, LinkedListNode two) {
        while (one != null && two != null) {
            if (one.data != two.data) {
                return false;
            }
            one = one.next;
            two = two.next;
        }

        return one == null && two == null;
    }

}
