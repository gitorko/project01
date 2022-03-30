package com.demo.theory._007_stacktransaction;

import java.util.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Implement a stack data structure.
 * Apart from having normal Push, Pop, Top, isEmpty() implementations, the stack needs to have transaction support.
 *
 * That is:
 * The stack needs to support
 * Begin Transaction ()
 * Commit ()
 * Rollback()
 *
 * There could be multiple nested transactions as in inside a begin transaction there could be another begin transaction.
 * Example:
 *
 * Stack obj = new Stack()
 * obj.push(4)
 * obj.begin transaction()
 * obj.push(6)
 * obj.commit();
 * 6 gets commited
 * obj.rollback()
 * 4 gets removed from the stack since the transaction with 6 was already committed.
 */
public class TransactionStack {

    @Test
    public void test1() {
        MyStack s = new MyStack();
        s.push(4);
        s.begin();
        s.push(6);
        s.commit();
        s.rollback();
        Assertions.assertEquals("6", s.toString());
    }

    @Test
    public void test2() {
        MyStack s = new MyStack();
        s.push(4);
        s.rollback();
        Assertions.assertEquals("", s.toString());
    }

    @Test
    public void test3() {
        MyStack s = new MyStack();
        s.push(4);
        s.push(5);
        s.rollback();
        Assertions.assertEquals("", s.toString());
    }

    @Test
    public void test4() {
        MyStack s = new MyStack();
        s.begin();
        s.push(4);
        s.push(5);
        s.rollback();
        Assertions.assertEquals("", s.toString());
    }

    @Test
    public void test5() {
        MyStack s = new MyStack();
        s.begin();
        s.push(4);
        s.push(5);
        s.commit();
        s.rollback();
        Assertions.assertEquals("4,5", s.toString());
    }

    @Test
    public void test6() {
        MyStack s = new MyStack();
        s.begin();
        s.push(4);
        s.begin();
        s.push(5);
        s.rollback();
        Assertions.assertEquals("4", s.toString());
    }

    @Test
    public void test7() {
        MyStack s = new MyStack();
        s.begin();
        s.push(4);
        s.commit();
        s.begin();
        s.push(5);
        s.commit();
        Assertions.assertEquals("4,5", s.toString());
    }

    @Test
    public void test8() {
        MyStack s = new MyStack();
        s.begin();
        s.push(4);
        s.begin();
        s.push(5);
        s.commit();
        s.commit();
        s.rollback();
        Assertions.assertEquals("4,5", s.toString());
    }

    @Test
    public void test9() {
        MyStack s = new MyStack();
        s.begin();
        s.begin();
        s.push(4);
        s.push(5);
        s.commit();
        s.commit();
        s.rollback();
        Assertions.assertEquals("4,5", s.toString());
    }

    @Test
    public void test10() {
        MyStack s = new MyStack();
        s.begin();
        s.begin();
        s.push(4);
        s.commit();
        s.begin();
        s.push(5);
        s.rollback();
        s.commit();
        s.rollback();
        Assertions.assertEquals("4", s.toString());
    }

    @Test
    public void test11() {
        MyStack s = new MyStack();
        s.begin();
        s.push(4);
        s.commit();
        Assertions.assertThrows(RuntimeException.class, () -> {
            s.commit();
        });
        Assertions.assertEquals("4", s.toString());
    }

    @Test
    public void test12() {
        MyStack s = new MyStack();
        s.push(4);
        Assertions.assertThrows(RuntimeException.class, () -> {
            s.commit();
        });
        Assertions.assertEquals("4", s.toString());
    }

    @Test
    public void test13() {
        MyStack s = new MyStack();
        Assertions.assertThrows(RuntimeException.class, () -> {
            s.commit();
        });
        s.push(4);
        Assertions.assertEquals("4", s.toString());
    }

    class MyStack {
        Stack<String> primaryStack = new Stack<>();
        Stack<String> secondaryStack = new Stack<>();
        int begin = 0;

        public void push(int value) {
            primaryStack.add(String.valueOf(value));
        }

        public int pop() {
            return Integer.parseInt(primaryStack.pop());
        }

        public void begin() {
            begin++;
            primaryStack.add(String.valueOf("B"));
        }

        public boolean commit() {
            begin--;
            if (begin < 0) {
                begin = 0;
                throw new RuntimeException("Cant commit without beginning!");
            }
            primaryStack.add(String.valueOf("C"));
            return true;
        }

        public boolean rollback() {
            Boolean start = false;
            int counter = 0;
            while (!primaryStack.isEmpty()) {
                //all move to secondary stack.
                if (primaryStack.peek().equals("C")) {
                    while (!primaryStack.isEmpty()) {
                        String pop = primaryStack.pop();
                        if (pop.equals("C")) counter++;
                        if (pop.equals("B")) counter--;
                        secondaryStack.push(pop);
                        if (counter == 0 && pop.equals("B")) break;
                    }
                }
                if (!primaryStack.isEmpty() && !primaryStack.peek().equals("C")) break;
            }
            //remove what is left
            while (!primaryStack.isEmpty()) {
                if (primaryStack.peek().equals("C")) break;
                if (primaryStack.peek().equals("B")) {
                    primaryStack.pop();
                    break;
                }
                primaryStack.pop();
            }
            //revert from 2nd stack to primary stack
            while (!secondaryStack.isEmpty()) {
                primaryStack.push(secondaryStack.pop());
            }
            return true;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (String s : primaryStack) {
                if (!s.equals("C") && !s.equals("B")) {
                    sb.append(s);
                    sb.append(",");
                }
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            return sb.toString();
        }
    }

}
