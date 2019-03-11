package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

/**
 * WRITE; Write the value on top of the stack to output; leave the value on top
 * of the stack
 */

public class WriteCode extends ByteCode {
    public void init(ArrayList<String> args) {
    //DOES NOTHING
    }

    public void execute(VirtualMachine vm) {
        System.out.println("Result: ");
        System.out.println(vm.pop());
    }

    public String toString() {
        return "WRITE";
    }
}
