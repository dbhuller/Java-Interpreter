package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;


public class ArgsCode extends ByteCode {
    private int val;

    @Override
    public void init(ArrayList<String> args) {
        val = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        //add code
        vm.newFrameAt(val); // sets up new frame with "val" number of arguments

        //check dump mode
        if ("ON".equals(vm.dumpMode)) {
            System.out.println("ARGS" + " " + val);
        }
    }

    public String toString() {
        return "ARGS" + val;
    }
}