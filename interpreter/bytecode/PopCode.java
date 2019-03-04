package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class PopCode extends ByteCode {
    protected int level2Pop;

    public void init(ArrayList<String> args) {
        level2Pop = Integer.parseInt(((String)args.get(0)));
    }
    //Add code for VM

}
