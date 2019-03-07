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
    private String dumpMode = "OFF"; // use true

    //Constructor
    protected VirtualMachine(Program program) {

        this.program = program;

    }

    // method to execute program
    // gets each bytecode from program and executes them according to each bytecode execute function
    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;

        while(isRunning) {
            ByteCode bytecode = program.getCode(pc);
            bytecode.execute(this);
            if("ON".equals(dumpMode) && !(bytecode instanceof DumpCode)) {
                runStack.dump();
            }
            pc++;
        }
    }

    public int maxToPop() {
        return runStack.maxToPop();
    }

    public void setProgramCounter(int x) {
        pc = x;
    }

    public int peek(){
        return runStack.peek();
    }

    public int pop() {
        return runStack.pop();
    }

    public int push(int toBePushed) {
        return runStack.push(toBePushed);
    }

    public int store(int offset) {
        return runStack.store(offset);
    }

    public int load(int offset) {
        return runStack.load(offset);
    }

    public void newFrameAt(int index) {
        runStack.newFrameAt(index);
    }

    public void popFrame() {
        runStack.popFrame();
    }

    public void pushReturnAddrs(int addrToBePushed) {
        returnAddrs.push(addrToBePushed);
    }

    public int popReturnAddrs(int addrToBePopped) {
        return (Integer)returnAddrs.pop();
    }

    public void setDump(boolean bool) {
        if (dumpMode.equals("ON")) {
            bool = true;
        } else {
            bool = false;
        }
    }

    public void exit() {
        isRunning = false;
    }

}
