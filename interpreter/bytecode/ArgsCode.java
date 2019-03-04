package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;


public class ArgsCode extends ByteCode {
    private int val;

    public void init(ArrayList<String> args) {
        val = Integer.parseInt(args.get(0));
    }

    public void execute(VirtualMachine vm) {
        //add code
    }
}
