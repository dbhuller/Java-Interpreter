package bytecode;

public class LitCode extends ByteCode {
    protected int val;
    protected String id;

    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
        if(args.size() > 1) {
            id = args.get(1);
        } else {
            id = "";
        }
    }

    public void execute(VirtualMachine vm) {
        //add code for method
    }
}
