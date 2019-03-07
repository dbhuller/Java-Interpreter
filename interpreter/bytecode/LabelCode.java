package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class LabelCode extends ByteCode {
    private String label;

    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    public void execute(VirtualMachine vm) {
    //DOES NOTHING
    }

    public String getArgs() {
        return label;
    }

    public String toString() {
        return "LABEL" + label;
    }
}
