package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class CallCode extends BranchCode {
    private String label;
    private int address;

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnAddrs(vm.getProgramCounter());
        vm.setProgramCounter(address);
    }

    public String getLabel() {
        return label;
    }

    public int getAddr() {
        return address;
    }

    public void setAddr(int addrToBeSet) {
        address = addrToBeSet;
    }

    public String toString() {
        return "CALL" + label + " jump to address " + address;
    }

}
