package preperation.crackingTheCodingInterview.chapterTwoLinkedLists;

import java.util.HashSet;

public class RemoveDups {

    void deleteDups(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode previous = null;

        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
        }
    }
    
}
