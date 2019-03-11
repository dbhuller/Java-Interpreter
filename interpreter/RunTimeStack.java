package interpreter;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Iterator;
import java.util.Vector;


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
        // print RTS one frame at a time
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
            //if (i != 0)
                System.out.print("]");
            currentFrame = nextFrame;
        }
        System.out.println();
    }

    // returns top of stack without removing item
    public int peek() {
        return runTimeStack.size() - 1;
    }

    // remove the last item added (top) to runtimestack
    public int pop() {
        int toBePopped = runTimeStack.size() -1;
        runTimeStack.remove(runTimeStack.size()-1);
        return toBePopped;
    }

    // push function, add element to runtimestack
    public int push(int toBePushed) {
        runTimeStack.add(toBePushed);   //add item to be pushed to RTS
        return toBePushed;     //return top of RTS
    }

    // stores values into variables
    public int store(int offset) {
        int valStored = this.pop();
        //runTimeStack.remove(runTimeStack.size()-1);     //remove top of stack
        runTimeStack.set(framePointer.peek() + offset, valStored);      //replace value at offset in the current frame
        return valStored;
    }

    // load variables to runtime stack from offset witihn current frame
    public int load(int offset) {
        // go to offset of current frame
        int valLoaded = runTimeStack.get(framePointer.peek() + offset);
        // add valLoaded to runtimestack
        runTimeStack.add(valLoaded);
        return valLoaded;
    }

    // creates a new frame in the RunTimeStack class
    public void newFrameAt(int offset) {
        framePointer.push(runTimeStack.size()-offset);
    }

    public Integer push(Integer val) {
        runTimeStack.add(val);
        //return this.peek();// try using 'this' if it doesnt work
        return val;
    }

    public void popFrame() {
        int pop1 = this.peek();
        int pop2 = framePointer.pop();
        for(int i = runTimeStack.size() - 1; i >= pop2; i--) {
            this.pop();
        }
        this.push(pop1);
    }

    public int size() {
        return runTimeStack.size();
    }

    /** Returns the size used by a function in the RTS. This function ensures the pop() wont pop more items than
     * needed, even if the arguments followed by the pop exceed the size of the function
    */
    public int maxToPop() {
        Iterator fpIterator = framePointer.iterator();  // framePointer Iterator
        int nextFrame = 0;
        int currentFrame = (Integer)fpIterator.next();
        int size = 0;
        if(currentFrame == 0)
            size = 0;
        else if(fpIterator.hasNext()) {
            nextFrame = (Integer)fpIterator.next();
            size = currentFrame - nextFrame;
        }
        return size;
    }






    
}
