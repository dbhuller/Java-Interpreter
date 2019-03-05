package interpreter.bytecode;

import interpreter.VirtualMachine;

// abstract class that is the superclass of branching instructions(FalseBranchCode, CallCode, ect...)
public abstract class BranchCode extends ByteCode  {
    @Override
    public abstract void init(ArrayList<String> args);

    @Override
    public abstract void execute(VirtualMachine vm);

    public abstract String getLabel();
    public abstract int getAddr();
    public abstract void setAddr(int addr);
}
