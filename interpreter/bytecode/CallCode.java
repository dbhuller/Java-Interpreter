package bytecode;

public class CallCode extends ByteCode {
    private String function;
    private int targetAddress;
    private int value;

    public void int(ArrayList<String> args) {
        function = args.get(0);
    }

    public void execute(VirtualMachine vm) {
        //add code for vm
    }
}
