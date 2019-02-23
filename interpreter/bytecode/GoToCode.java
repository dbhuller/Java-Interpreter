package bytecode;

// add import for vm

public class GoToCode extends ByteCode {
	private String label;
	int labelAddress;

	public void init(ArrayList<String> args) {
		label = (String) args.get(0);
	}

	//add other methods 
}
