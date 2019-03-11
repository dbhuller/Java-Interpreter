package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

/**
 * GOTO <label>
 */

public class GoToCode extends BranchCode {
	private String label;
	private int address;

	public void init(ArrayList<String> args) {
		label = args.get(0);
	}

	//add other methods
	public void execute(VirtualMachine vm) {
		vm.setProgramCounter(address);
	}
	public String getLabel() {
		return label;
	}

	public void setAddr(int addrToBeSet) {
		address = addrToBeSet;
	}

	public int getAddr() {
		return address;
	}

	public String toString() {
		return "GOTO" + label + " jump to address: " + address;
	}
}
