// Stack 클래스 사용법 - Iterator 사용
package com.eomcs.basic.ex05;

import java.util.Iterator;
import java.util.Stack;

public class Exam0160 {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    // push() - 스택의 맨 마지막에 값을 추가한다.
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");

    Iterator<String> iterator = stack.iterator();
    // Iterator는 처음 들어간 순서대로 호출한다.
    // stack엔 pop을 사용해야 마지막에 들어간게 호출된다.
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

  }

}

