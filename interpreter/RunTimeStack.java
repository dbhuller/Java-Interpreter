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

    
}
