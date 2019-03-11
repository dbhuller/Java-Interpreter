package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

/**
 * LOAD n <id>; push the value in the slot which is offset n from the start
 * of the frame onto the top of the stack; <id> is used as a comment, it's the
 * variable name from which the data is loaded
 */

public class LoadCode extends ByteCode {
    private int offset;
    private String id;

    public void init(ArrayList<String> args) {
        offset = Integer.parseInt(args.get(0));
        id = args.get(1);
    }

    //add code for VM
    @Override
    public void execute(VirtualMachine vm) {
        vm.load(offset);
    }

    public String toString() {
        if(id.equals(""))
            return "LOAD" + offset;
        else
            return "LOAD" + offset + " " + id;
    }

}
