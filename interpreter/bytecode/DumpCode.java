package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class DumpCode extends ByteCode {
    private String label;

    @Override
    public void init(ArrayList<String> args) { label = (String)args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
    // add code
    }

    public String toString() {
        return "DUMP" + label;
    }
}
