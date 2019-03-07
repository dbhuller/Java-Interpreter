package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class DumpCode extends ByteCode {
    private String label;

    @Override
    public void init(ArrayList<String> args) { label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
    if(label.equals("ON"))
        vm.setDump(true);
    else if(label.equals("OFF"))
        vm.setDump(false);
    }

    public String toString() {
        return "DUMP" + label;
    }
}
