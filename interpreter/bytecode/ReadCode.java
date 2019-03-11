package interpreter.bytecode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import interpreter.VirtualMachine;

/**
 * READ; Read an integer; prompt the user for input; put the value just read on
 * top of the stack
 */

public class ReadCode extends ByteCode{
    public void init(ArrayList<String> args) {
    //DOES NOTHING
    }

    public void execute(VirtualMachine vm) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Input an Int: ");
            String line = in.readLine();
            int x = Integer.parseInt(line);
            vm.push(x);
        } catch (Exception e) {
            System.out.println("Error Entering Int");
        }
    }

    public String toString() {
        return "READ";
    }
}
