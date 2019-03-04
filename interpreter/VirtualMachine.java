package interpreter;

import java.util.Stack;
import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;

    //initial dump set to off (default)
    private String dumpMode = "OFF";

    protected VirtualMachine(Program program) {

        this.program = program;

    }

    //method to execute program
    public void executeProgram() {
        int x = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;

        while(isRunning) {
            ByteCode bytecode = program.getCode(x);
            bytecode.execute(this);
            if("ON".equals(dumpMode) && !(bytecode instanceof DumpCode)) {
                runStack.dump();
            }
            x++;
        }
    }

}
