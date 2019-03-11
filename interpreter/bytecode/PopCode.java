package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

/**
 * POP n; Pop top n levels of runtime stack
 */

public class PopCode extends ByteCode {
    protected int level2Pop;

    @Override
    public void init(ArrayList<String> args) {
        level2Pop = Integer.parseInt((args.get(0)));
    }

    @Override
    public void execute(VirtualMachine vm) {
        /*
        for (int i = 0; i < level2Pop; i++)
            vm.pop();
    }
    */
        int size = vm.maxToPop()-1;
        if (size >= level2Pop)
            size = level2Pop-1;
        try {
            for(int i = 0; i < size; i++) {
                vm.pop();
            }
        }catch (Exception e) {
            System.out.println("Pop Error");
        }
    }

    public String toString() {
        return "POP " + level2Pop;
    }

}
