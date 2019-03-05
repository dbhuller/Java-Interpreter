package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class BopCode extends ByteCode {
    private String op;

    @Override
    public void init(ArrayList<String> args) {
        op = (String)args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        //add code for vm

    }
}
