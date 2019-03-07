package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends BranchCode {
	private String label;
	private int address;

	@Override
	public void init(ArrayList<String> args) {
		label = args.get(0);
	}
	@Override
	public void execute(VirtualMachine vm) {
		int topOfRunStack = vm.pop();
		if(topOfRunStack == 0)
			vm.setProgramCounter(address);
	}


	public void setAddr(int addrToBeSet) {
		address = addrToBeSet;
	}
	public int getAddr() {
		return address;
	}

	public String toString() {
		return "FALSEBRANCH" + label + " jump to address: " + address;
	}

	public String getLabel(){
		return label;
	}
}
