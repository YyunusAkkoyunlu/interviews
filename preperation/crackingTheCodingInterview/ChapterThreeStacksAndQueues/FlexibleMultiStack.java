package preperation.crackingTheCodingInterview.ChapterThreeStacksAndQueues;

import java.util.EmptyStackException;
import java.util.Stack;

public class FlexibleMultiStack {

    /**
     * stack info is simple class that holds a set of data about each stack. It
     * does not hold the actual items in the stack. We could have done this with
     * just a bunch of individual variables, but that's messy and doesn't gain us
     * much
     */
    private class StackInfo {
        public int start, size, capacity;

        public StackInfo(int start, int capacity) {
            this.start = start;
            this.capacity = capacity;
        }

        /**
         * Check if and index on the full array is within the stack boundaries. The
         * stack can wrap around to the start of the array
         */
        public boolean isWithinStackCapacity(int index) {
            /* If outside of bounds of array, return false */
            if (index < 0 || index >= values.length) {
                return false;
            }

            /* If index wraps around, adjust it */
            int contiguousIndex = index < start ? index + values.length : index;
            int end = start + capacity;

            return start <= contiguousIndex && contiguousIndex < end;
        }

        public int lastCapacityIndex() {

            return adjustIndex(start + capacity - 1);
        }

        public int lastElementIndex() {

            return adjustIndex(start + size - 1);
        }

        public boolean isFull() {

            return size == capacity;
        }

        public boolean isEmpty() {

            return size == 0;
        }

    }

    private StackInfo[] info;

    private int[] values;

    public FlexibleMultiStack(int numberOfStacks, int defaultSize) {
        /* create metadata for al stacks */
        info = new StackInfo[numberOfStacks];
        for (int i = 0; i < numberOfStacks; i++) {
            info[i] = new StackInfo(defaultSize * i, defaultSize);
        }

        values = new int[numberOfStacks * defaultSize];
    }

    /**
     * push value onto stack num, shifting / expanding stack as necessary. Throws
     * exception if all stacks are full
     */
    public void push(int stackNum, int value) throws FullStackException {
        if (allStacksAreFull()) {
            throw new FullStackException();
        }

        /* if this stack is full, expand it */
        StackInfo stack = info[stackNum];
        if (stack.isFull()) {
            expand(stackNum);
        }

        /**
         * find the index of the top element in the array + 1, and increment the
         * stack pointer
         */
        stack.size ++;
        values[stack.lastElementIndex()] = value;
    }

    /**
     * remove value from stack
     */
    public int pop(int stackNum) throws Exception {
        StackInfo stack = info[stackNum];
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        /* remove last element */
        int value = values[stack.lastElementIndex()];
        values[stack.lastElementIndex()] = 0; // clear item
        stack.size --; // shrink size

        return value;
    }

    /* get top element of stack */
    public int peek(int stackNum) {
        StackInfo stack = info[stackNum];

        return values[stack.lastElementIndex()];
    }

    /**
     * shift items in stack over by one element. If we have available capacity, then
     * we'll end up shrinking the stack by one element. If we don't have available
     * capacity, then we'll need to shift the next stack over too
     */
    private void shift(int stackNum) {
        System.out.println("/// shifting " + stackNum);
        StackInfo stack = info[stackNum];

        /**
         * if this stack is at its full capacity, then you need to move the next
         * stack over by one element. This stack can now claim the freed index
         */
        if (stack.size >= stack.capacity) {
            int nextStack = (stackNum + 1) % info.length;
            shift(nextStack);
            stack.capacity ++; // claim index that next stack lost
        }

        /* shift all elements in stack over by one */
        int index = stack.lastCapacityIndex();
        while (stack.isWithinStackCapacity(index)) {
            values[index] = values[previousIndex(index)];
            index = previousIndex(index);
        }

        /* adjust stack data */
        values[stack.start] = 0; // clear item
        stack.start = nextIndex(stack.start); // move start
        stack.capacity --; // shrink capacity
    }

    /**
     * expand stack by shifting over other stacks
     */
    private void expand(int stackNum) {
        shift((stackNum + 1) % info.length);
        info[stackNum].capacity ++;
    }

    /**
     * returns the number of items actually present in stack
     */
    public int numberOfElements() {
        int size = 0;
        for (StackInfo sd : info) {
            size += sd.size;
        }

        return size;
    }

    /**
     * returns true is all the stacks are full
     */
    public boolean allStacksAreFull() {

        return numberOfElements() == values.length;
    }

    /**
     * adjust index to be within the range of 0 -> length -1
     */
    private int adjustIndex(int index) {
        /**
         * java's mod operator can return neg values. From example, (-11 % 5 )will
         * return -1, not 4. We actually want the value to be 4 (since we're wrapping
         * around the index).
         */
        int max = values.length;

        return ((index % max) + max) % max;
    }

    /**
     * get index after this index, adjust for wrap around
     */
    private int nextIndex(int index) {

        return adjustIndex(index + 1);
    }

    /**
     * get index before this index, adjust for wrap around
     */
    private int previousIndex(int index) {

        return adjustIndex(index - 1);
    }

}
