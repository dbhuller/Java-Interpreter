package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class CallCode extends BranchCode {
    private String label;
    private int address;

    @Override
    public void init(ArrayList<String> args) {
        label = (String)args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
    // add code
    }

    public String getLabel() {
        return label;
    }

    public int getAddr() {
        return targetAddress;
    }

    public void setAddr(int addr) {
        address = addr;
    }

    public String toString() {
        return "CALL" + label + " jump to address " + address;
    }

}
