package interpreter.bytecode;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode { //add implements AddressResolution
	private String label;
	int labelAddress;

	public void init(ArrayList<String> args) {
		label = (String) args.get(0);
	}
}
