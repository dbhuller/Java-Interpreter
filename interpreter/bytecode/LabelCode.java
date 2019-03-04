package bytecode;

public class LabelCode extends ByteCode {
    private String label;

    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    public void execute(VirtualMachine vm) {

    }
}
