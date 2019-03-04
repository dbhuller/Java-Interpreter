package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class StoreCode extends ByteCode {
	
	private int offset;
	private String id;
	private int val;

	public void init(ArrayList<String> args) {
		offset = Integer.parseInt(args.get(0));
		id = args.get(1);
	}

	//Add code for VM
}
