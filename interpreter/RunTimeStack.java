package interpreter;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Iterator;

// Class to hold the runtime stack and frame pointers
public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    //Constructor
    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {
        Iterator fpIterator = framePointer.iterator();
        int nextFrame, currentFrame = (Integer) fpIterator.next();
        // print stack
        for (int i = 0; i < framePointer.size(); i++) {
            if (fpIterator.hasNext() ) {
                nextFrame = (Integer) fpIterator.next();
            } else {
                nextFrame = runTimeStack.size();
            }
            //if (i != 0) {}
            System.out.println("[");
            // print the current frame
            for (int k = currentFrame; k < nextFrame; k++) {
                System.out.print(runTimeStack.get(k));
                if (k != nextFrame - 1) {
                    System.out.println(",");
                }
            }
            if (i != 0)
                System.out.print("]");
            currentFrame = nextFrame;
        }
        System.out.println("\n");
    }

    // returns top of stack without removing item
    public int peek() {
        return (Integer)runTimeStack.get(runTimeStack.size() - 1);
    }

    // remove the last item added (top) to runtimestack
    public int pop() {
        int toBePopped = (Integer)runTimeStack.get(this.size()-1);
        runTimeStack.remove(runTimeStack.size()-1);
        return toBePopped;
    }

    // push function, add element to runtimestack
    public int push(int toBePushed) {
        runTimeStack.add(toBePushed);   //add item to be pushed to RTS
        return runTimeStack.peek();     //return top of RTS
    }

    // stores values into variables
    public int store(int offset) {
        int valStored = (Integer)runTimeStack.get(this.size()-1);
        runTimeStack.remove(runTimeStack.size()-1);     //remove top of stack
        runTimeStack.set(framePointer.peek() + offset, valStored);      //replace value at offset in the current frame
        return valStored;
    }



    
}
