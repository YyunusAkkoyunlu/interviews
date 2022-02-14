package preperation.crackingTheCodingInterview.chapterTwoLinkedLists;

public class LoopDetection {

    LinkedListNode findBeginning(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        /* find meeting point. this will be LOOK_SIZE - k steps into the linked list */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // collision
                break;
            }
        }

        /* error check - no meeting point, and therefore no loop */
        if (fast == null || fast.next == null) {
            return null;
        }

        /* move slow to head. keep fast at meeting point. each are k steps from the
        * loop start. If they move at the same pace, they must meet at loop start
         */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        /* both now point to the start of the loop */
        return fast;
    }

}
