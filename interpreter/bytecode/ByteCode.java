package interpreter.bytecode;

import java.util.ArrayList;
//need import for virtual machine when its created
import interpreter.VirtualMachine;

/**
 * abstract class for each bytecode
 */

public abstract class ByteCode {
    public abstract void init(ArrayList<String> args);

    // vm will call
    public abstract void execute(VirtualMachine vm);
}
