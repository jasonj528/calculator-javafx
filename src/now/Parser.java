package now;

import java.util.Stack;

public class Parser {
    // add operator symbols to this 
    private final static String OPS = "-+*/%^";
    // corresponds to the precedence of the operator at OPS.charAt(n)
    private final static int[] PREC = {1,1,2,2,2,3};
    // associativity of the operator at OPS.charAt(n)
    private final static boolean[] RIGHT = {
            false, false, false, false, false, true
    };
    
    public static void main(String args[]) {
        System.out.println(calculate(rpn("2 ^ 5")));
    }
    
    public static String rpn(String eq) {
        StringBuilder sb = new StringBuilder(); // constructs string representing the rpn conversion
        // operator indices are stored here
        // due to the nature of the ops list having two operators each of two total precedences,
        // dividing its index by two will give an operator's precedence value
        Stack<Integer> stk = new Stack<>();

        for (String str : eq.split("\\s")) {
            char c = str.charAt(0);
            int index = OPS.indexOf(c);

            // if the operation is - but the string is longer than a character,
            // it's a negative number
            if (index == 0 && str.length() > 1) index = -1;

            // check if c is an operator
            if (index != -1) {
                if (stk.isEmpty()) stk.push(index);
                else {
                    int cur = PREC[index];
                    while (!stk.isEmpty()) {
                        int next = PREC[stk.peek()];
                        // if current op has a greater precedence than the top of the stack,
                        // pop the stack until it does not
                        if (next > cur || (next == cur && !RIGHT[index]))
                            sb.append(OPS.charAt(stk.pop())).append(' ');
                        else break;
                    }
                    // only push to the operator stack when the operator in question
                    // has the least (or equal to least) precedence on stack
                    stk.push(index);
                }
            }
            else if (c == '(')
                stk.push(-2);   // arbitrary value representing (
            else if (c == ')') {
                // pop operators until -2 (representing '(') is reached
                while (stk.peek() != -2)
                    sb.append(OPS.charAt(stk.pop())).append(' ');
                stk.pop();  // discard the (
            }
            else
                sb.append(str).append(' ');
        }
        while (!stk.isEmpty())
            sb.append(OPS.charAt(stk.pop())).append(' ');

        return sb.toString();
    }

    /*
    Produces the result (as a string) of parsing and evaluating an equation represented in reverse
    polish notation. Results too big to display will be represented in scientific notation.
     */
    public static double calculate(String rpn) {
        // for now, only binary operations are implemented, so we'll keep track only of right/left
        Stack<Double> operands = new Stack<>();

        for (String str : rpn.split("\\s")) {
            if (str.matches("-?[0-9]+\\.?[0-9]*"))
                operands.push(Double.parseDouble(str));
            else {
                // add conditional here for what number of operands a group of ops take
                double rhs = operands.pop();
                double lhs = operands.pop();
                if (str.equals("-"))
                    operands.push(lhs - rhs);
                else if (str.equals("+"))
                    operands.push(lhs + rhs);
                else if (str.equals("*"))
                    operands.push(lhs * rhs);
                else if (str.equals("/"))
                    operands.push(lhs / rhs);
                else if (str.equals("%"))
                    operands.push(lhs % rhs);
                else if (str.equals("^"))
                    operands.push(Math.pow(lhs, rhs));
                // add additional operations here
            }
        }

        return operands.pop();
    }
}
