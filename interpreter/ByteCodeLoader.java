
package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import interpreter.bytecode.*;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    //
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
        //this.program = new Program();
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        Program p = new Program();
        String key, value;
        String nextLine;
        ByteCode code;
        ArrayList<String> tokens = new ArrayList<String>();
        try {
            //read line of the file
            nextLine = byteSource.readLine();
            while(nextLine != null) {
                StringTokenizer tokenizer = new StringTokenizer(nextLine);
                key = tokenizer.nextToken();
                value = CodeTable.getClassName(key);

                code = (ByteCode)(Class.forName("interpreter." + value).newInstance());

                while(tokenizer.hasMoreTokens()) {
                    tokens.add(tokenizer.nextToken());
                }
                //initialize bytecode instance with args
                code.init(tokens);
                //add bytecode to programs arraylist
                p.addCode(code);

                //clear tokens
                tokens.clear();
                //reads next line
                nextLine = byteSource.readLine();
            }
        } catch (Exception e) {
            System.out.println("file readline doesnt work");
        }
        //resolve branching
        try {
            p.resolveAddrs(p);
        } catch (Exception e) {
            System.out.println("ResolveAddress error in bytecodeloader.java");
        }

        return p;
    }
}
