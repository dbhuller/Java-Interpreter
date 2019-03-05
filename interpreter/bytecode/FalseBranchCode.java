package interpreter.bytecode;

import java.util.ArrayList;

public class FalseBranchCode extends BranchCode {
	private String label;
	int labelAddress;

	@Override
	public void init(ArrayList<String> args) {
		label = (String) args.get(0);
	}
}
