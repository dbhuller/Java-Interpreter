package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class PopCode extends ByteCode {
    protected int level2Pop;

    @Override
    public void init(ArrayList<String> args) {
        level2Pop = Integer.parseInt((args.get(0)));
    }

    @Override
    public void execute(VirtualMachine vm) {
        for (int i = 0; i < level2Pop; i++)
            vm.pop();
    }

    public String toString() {
        return "POP " + level2Pop;
    }

}
