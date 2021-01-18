package Yangshun;

import java.util.Stack;

public class ValidParentheses {

//  Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//  An input string is valid if:
//
//  Open brackets must be closed by the same type of brackets.
//  Open brackets must be closed in the correct order.
//
//  Example 1:
//
//  Input: s = "()"
//  Output: true

  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for(Character c: s.toCharArray()) {
      if(c.equals('(')) {
        stack.push(')');
      }
      else if(c.equals('[')) {
        stack.push(']');
      }
      else if(c.equals('{')) {
        stack.push('}');
      }
      else if(stack.isEmpty() || stack.pop() != c) {
        return false;
      }
    }

    return stack.isEmpty();

  }

  public static void main(String[] args) {
    System.out.println(isValid("()"));
    System.out.println(isValid("()))))"));
    System.out.println(isValid("([)]"));
  }
}
