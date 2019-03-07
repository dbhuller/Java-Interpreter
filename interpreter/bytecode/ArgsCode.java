package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;


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