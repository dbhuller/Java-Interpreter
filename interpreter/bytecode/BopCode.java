package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class BopCode extends ByteCode {
    private String operator;

    @Override
    public void init(ArrayList<String> args) {
        operator = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        //add code for vm
        int operand1 = vm.pop();
        int operand2 = vm.pop();
        int result = 0;

        switch (operator) {
            case "+":
                result = operand2 + operand1;
                break;
            case "-":
                result = operand2 - operand1;
                break;
            case "*":
                result = operand2 * operand1;
                break;
            case "/":
                while(operand1 != 0)
                    result = operand2/operand1;
                break;
            case "==":
                if(operand2 == operand1)
                    result = 1;
                else
                    result = 0;
                break;
            case "!=":
                if(operand2 == operand1)
                    result = 0;
                else
                    result = 1;
                break;
            case "<=":
                if(operand2 <= operand1)
                    result = 1;
                else
                    result = 0;
                break;
            case ">=":
                if(operand2 >= operand1)
                    result = 1;
                else
                    result = 0;
                break;
            case "<":
                if(operand2 < operand1)
                    result = 1;
                else
                    result = 0;
                break;
            case ">":
                if(operand2 > operand1)
                    result = 1;
                else
                    result = 0;
                break;
            case "|":
                if(operand2 == 0 && operand1 == 0)
                    result = 0;
                else
                    result = 1;
                break;
            case "&":
                if(operand2 == 1 && operand1 == 1)
                    result = 1;
                else
                    result = 0;
                break;
        }
        vm.push(result);
    }

    public String toString() {
        return "BOP" + operator;
    }
}
