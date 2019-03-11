package interpreter;

import java.util.HashMap;
import java.util.ArrayList;
import interpreter.bytecode.*;

public class Program {

    private ArrayList<ByteCode> program;
    private HashMap<String, Integer> programHM;

    public Program() {
        program = new ArrayList<>();
        programHM = new HashMap<String, Integer>();
    }


    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    //function to identify if bytecode is LabelCode then store labelcode in hashmap
    public void addCode(ByteCode code) {
        if(code instanceof LabelCode) {
            LabelCode label = (LabelCode)code;
            programHM.put(label.getArgs(), program.size());
        }
        program.add(code);
    }


    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     *  Program object that holds a list of ByteCodes
     */
    public void resolveAddrs() {
        Integer addrToJumpTo;
        for(int i = 0; i < program.size(); i++) {
            if(program.get(i) instanceof BranchCode) {
                BranchCode branch = (BranchCode)program.get(i);
                addrToJumpTo = new Integer(programHM.get(branch.getLabel()));
                branch.setAddr(addrToJumpTo.intValue());
            }
        }
    }

    public ArrayList<ByteCode> getProgram() {
        return program;
    }
}
