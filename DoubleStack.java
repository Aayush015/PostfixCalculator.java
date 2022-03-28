/**
 * LAB 5 : Postfix Calculator
 *
 * Name: Aayush Kafle
 * Class: CS-251L-005 (Spring 2022)
 * Email: akafle1@unm.edu
 * Date Submitted: 03/25/2022
 *
 * Brief explanation of the class:
 * This class implements Stack<Double>. A linkedlist is created in this class
 * so that we can push, pop, peek, and check if the list is empty so that
 * we can create a stack for the postfix calculator.
 */

import java.util.LinkedList;

public class DoubleStack implements Stack<Double>
{
    /**
     * Creating a list so that we can push, peek, pop and check if the list
     * is empty
     * */
    LinkedList<Double> list = new LinkedList<>();

    /**
     * Pushes the value of given double to the top of the stack
     * */
    @Override
    public void push(Double val) {
        list.add(val);
    }

    /**
     * Returns the value of given double to the top of the stack without
     * removing it
     * */
    @Override
    public Double peek() {
        return list.get(list.size()-1);
    }

    /**
     * Pop the item from the top of the stack then return it
     * */
    @Override
    public Double pop() {
        return list.remove(list.size()-1);
    }

    /**
     * Checks if the given list is empty
     * */
    @Override
    public boolean isEmpty() {
        if (list.size() == 0) {
            return true;
        }
        return false;
    }

}
