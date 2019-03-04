package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class LoadCode extends ByteCode {
    private int offset;
    private String id;

    public void init(ArrayList<String> args) {
        offset = Integer.parseInt(args.get(0));
        id = args.get(1);
    }

    //add code for VM

}
