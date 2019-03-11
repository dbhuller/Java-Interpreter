package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

/**
 * STORE n <id> - pop the top of the stack; store value into the offset n from
 * the start of the frame;<id> is used as a comment, it's the variable name
 * where the data is stored
 */

public class StoreCode extends ByteCode {
	
	private int offset;
	private String id;
	private int val;

	public void init(ArrayList<String> args) {
		offset = Integer.parseInt(args.get(0));
		id = args.get(1);
	}

	@Override
	public void execute(VirtualMachine vm) {
		val = vm.peek();
		vm.store(offset);
	}

	public String toString() {
		return "STORE" + offset + " " + id + " " + id + " = " + val;
	}
}
