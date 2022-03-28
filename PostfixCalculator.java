/**
 * LAB 5 : Postfix Calculator
 *
 * Name: Aayush Kafle
 * Class: CS-251L-005 (Spring 2022)
 * Email: akafle1@unm.edu
 * Date Submitted: 03/25/2022
 *
 * Brief explanation of the class:
 * This class is where the actual postfix calculator is implemented. A stack is
 * created for which the operator and key is mapped so that we can do the
 * calculation. OperatorMap is used to put the symbol to their corresponding
 * operator.
 * A method to push the value on top of stack is also defined(storeOperand).
 * A method to calculate the result from the value in the stack and
 * return it to the top of the stack is also defined (evalOperator).
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Builds up the stack and maps the corresponding operator and String
 * Make separate implementation for addition, subtraction, multiplication,
 * division, and print. Also puts the value after the operation for the
 * corresponding symbols.*/
public class PostfixCalculator
{
    /** Create the stack of double operands for holding the values */
    private final DoubleStack stack = new DoubleStack();

    /** Maps Operators to their corresponding symbols */
    private final Map<String, Operator> operatorMap = new HashMap<>();

    /**
     * Includes the implementation of addition operation
     * Addition must be done between two numbers
     */
    private static class Addition implements Operator{

        @Override
        public int numArgs() {
            // Has 2 arguments
            return 2;
        }

        @Override
        public double eval(List<Double> args) {
            // Adds the last number with the second last number
            double addition = args.get(1) + args.get(0);
            return addition;
        }
    }

    /**
     * Includes the implementation of subtraction operation
     * Subtraction must be done between two numbers
     */
    private static class Subtraction implements Operator {
        @Override
        public int numArgs() {
            return 2;
        }

        @Override
        public double eval(List<Double> args) {
            // Subtracts the last number with the second last number
            double subtraction = args.get(1) - args.get(0);
            return subtraction;
        }
    }

    /**
     * Includes the implementation of multiplication operation
     * Multiplication must be done between two numbers
     */
    private static class Multiplication implements Operator {
        @Override
        public int numArgs() {
            return 2;
        }

        @Override
        public double eval(List<Double> args) {
            double multiplication = args.get(1) * args.get(0);
            return multiplication;
        }
    }

    /**
     * Includes the implementation of division operation
     * Division must be done between two numbers
     */
    private static class Division implements Operator {
        @Override
        public int numArgs() {
            return 2;
        }

        @Override
        public double eval(List<Double> args) {
            double division = args.get(1) / args.get(0);
            return division;
        }
    }

    /**
     * Includes the implementation of Print operation
     * Prints the result which would be the last number calculated
     */
    private static class Print implements Operator {
        @Override
        public int numArgs() {
            return 1;
        }

        @Override
        public double eval(List<Double> args) {
            // Prints out the value of the operation and puts it in the stack
            System.out.println(args.get(0));
            return args.get(0);
        }

    }

    /**
     * The class has operator map that associates the symbol for addition,
     * subtraction, multiplication, division, and print to their
     * corresponding operation.
     */
    public PostfixCalculator() {
        operatorMap.put("+", new Addition());
        operatorMap.put("add", new Addition());
        operatorMap.put("-", new Subtraction());
        operatorMap.put("sub", new Subtraction());
        operatorMap.put("*", new Multiplication());
        operatorMap.put("mult", new Multiplication());
        operatorMap.put("/", new Division());
        operatorMap.put("div", new Division());
        operatorMap.put("=", new Print());
        operatorMap.put("print", new Print());
    }

    /**
     * This method takes a double and pushes it onto the operand stack
     */
    public void storeOperand(double another)
    {
        stack.push(another);
    }

    /**
     * This method looks up the corresponding operator object in the operator
     * map for the given String v. Then it evaluates the value of given
     * operation and pushes the result onto the operand stack.
     */
    public void evalOperator(String v) {
        Double[] args;
        List<Double> list;

        // Maps the corresponding operator and does the calculation accordingly
        if (operatorMap.containsKey(v)) {
            Operator evalOpp = operatorMap.get(v);
            args = new Double[evalOpp.numArgs()];

            // Looping till the end of the command line arguments
            for (int i = 0; i < evalOpp.numArgs() && !stack.isEmpty(); i++) {
                args[i] = stack.pop();
            }
            list = Arrays.asList(args);
            stack.push(evalOpp.eval(list));
        }
    }
}
