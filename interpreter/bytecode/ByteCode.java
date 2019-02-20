package bytecode;

import java.util.*;
//need import for virtual machine when its created

public abstract class ByteCode {
    public abstract void init(Vector<String> args);
    // vm will call
    public abstract void execute();
}
