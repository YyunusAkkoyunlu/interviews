package preperation.crackingTheCodingInterview.ChapterThreeStacksAndQueues;

import java.util.EmptyStackException;

public class FixedMultiStack {
    
    private int numberOfStacks = 3;

    private int stackCapacity;

    private int[] values;

    private int[] sizes;


    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }


    /* push value onto stack */
    public void push(int stackNum, int value) /*throws FullStackException*/ {
        /* check that we have space for the next element */
        if (isFull(stackNum)) {
            /*throw new FullStackException();*/
        }

        /* increment stack pointer and then update top value */
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    /* pop item from top stack */
    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }

        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex]; // get top
        values[topIndex] = 0; // clear
        sizes[stackNum] --; // shrink

        return value;
    }

    /* return top element */
    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }

        return values[indexOfTop(stackNum)];
    }

    /* return if stack is empty */
    public boolean isEmpty(int stackNum) {

        return sizes[stackNum] == 0;
    }

    /* return if stack is full */
    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    /* return index of the top of the stack */
    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];

        return offset + size - 1;
    }

}
