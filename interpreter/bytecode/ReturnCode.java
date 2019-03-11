package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

/**
 * RETURN <funcname>; Return from the current function; <funcname> is used as
 * a comment to indicate the current function
 * RETURN is generated for intrinsic functions
 */

public class ReturnCode extends ByteCode {
    private String label;
    private int returnValue;

    public void init(ArrayList<String> args) {
        if(args.size() > 0) {
            label = args.get(0);
        } else {
            label = "";
        }
    }

    public void execute(VirtualMachine vm ) {
        //add code for virtual machine
        vm.setProgramCounter(vm.popReturnAddrs());
        vm.popFrame();
        returnValue = vm.peek();
    }

    public String toString() {
        if (label == null)
            return "LABEL";
        else
            return "LABEL" + label;
    }
}
