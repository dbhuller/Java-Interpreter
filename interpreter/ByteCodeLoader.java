
package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import interpreter.bytecode.*;
/***
 *
 This is the class that will be in charge of loading the code from the
 * source file. It also has a method that loads bytecode objects into an
         * instance of the program class. This is done with the help of a
        * Hashtable that matches the bytecode to their equivalent classname.
        */

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
        Program loadedProgram = new Program();
        String hKey, hValue;
        String line;
        ByteCode byteCode;
        ArrayList<String> tokenList = new ArrayList<String>();

        try {
            line = byteSource.readLine();
            while (line != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);

                hKey = tokenizer.nextToken();
                hValue = CodeTable.getCode(hKey);

                byteCode = (ByteCode)(Class.forName("interpreter.bytecode." + hValue).newInstance());
                while(tokenizer.hasMoreTokens()) {
                    tokenList.add(tokenizer.nextToken());
                }

                byteCode.init(tokenList);

                loadedProgram.addCode(byteCode);

                tokenList.clear();;

                line  = byteSource.readLine();
            }
        }catch (Exception e) {
            System.out.println("readline doesnt work");
        }

        try {
            loadedProgram.resolveAddrs();
        }catch (Exception e) {
            System.out.println("ResolveAddress Erorr in ByteCodeLoader.java");
        }
        return loadedProgram;
    }
    /*
    public Program loadCodes() throws IOException {
        Program loadedProgram = new Program();
        ArrayList<String> args = new ArrayList<>();

        //lines of code read from file
        String codeFromSrc = byteSource.readLine();

        while (codeFromSrc != null) {
            args.clear();
            StringTokenizer tokenizer = new StringTokenizer(codeFromSrc);
            String next = tokenizer.nextToken();
            if (next != null) {
                String code = CodeTable.getCode(next);
                while (tokenizer.hasMoreTokens()) {
                    args.add(tokenizer.nextToken());
                }

                try {
                    if(code != null) {
                        ByteCode byteCode = (ByteCode)(Class.forName("interpreter.bytecode."+code).newInstance());

                        byteCode.init(args);

                        loadedProgram.addCode(byteCode);
                    }
                    codeFromSrc = byteSource.readLine();
                }
                catch (InstantiationException|IllegalAccessException|ClassNotFoundException|IOException e) {
                    System.out.println("Exception occurred " + e + "\n");
                }
            }
        }
        loadedProgram.resolveAddrs();
        return loadedProgram;
    }
*/
}
