package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 * ARGS n; Used prior to calling a function:
 *  n = # of args
 * this instruction is immediately followed by the CALL instruction:
 * the function has n args so ARGS n instructs the interpreter to set up a new
 * frame n down from the top, so it will include the arguments
 */

public class ArgsCode extends ByteCode {
    private int numArgs;

    @Override
    public void init(ArrayList<String> args) {
        numArgs = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
       vm.newFrameAt(numArgs);
    }

    public String toString() {
        return "ARGS" + numArgs;
    }
}