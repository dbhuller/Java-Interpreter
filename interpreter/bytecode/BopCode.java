package bytecode;

public class BopCode extends ByteCode {
    private String op;

    public void init(ArrayList<String> args) {
        op = args.get(0);
    }

    public void execute(VirtualMachine vm) {
        //add code for vm
    }
}
