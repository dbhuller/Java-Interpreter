package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class ReturnCode extends ByteCode {
    private String function;
    private int returnValue;

    public void init(ArrayList<String> args) {
        if(args.size() > 0) {
            function = args.get(0);
        } else {
            function = "";
        }
    }

    public void execute(VirtualMachine vm ) {
        //add code for virtual machine
    }
}
