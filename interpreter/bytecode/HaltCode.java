package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class HaltCode extends ByteCode {
    @Override
    public void init(ArrayList<String> args) {
    //DOES NOTHING
    }

    //Add Code for VM
    @Override
    public void execute(VirtualMachine vm) {
        vm.exit();  //request vm to exit
    }

    public String toString() {
        return "HALT";
    }
}
