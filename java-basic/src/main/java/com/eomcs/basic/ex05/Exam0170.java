// Stack 클래스 사용법 - Iterator 사용
package com.eomcs.basic.ex05;

import java.util.Stack;

public class Exam0170 {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    // push() - 스택의 맨 마지막에 값을 추가한다.
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");

    // stack 도 Iterable 구현체이기 때문에 다음과 같이 for(:)문을 사용 가능.
    // => 내부적으로 iterator()를 호출하여 Iterator를 얻은 후에 이를 통해서 값을 꺼냄.
    // => 결국 Exam0160과 같다.
    //      즉 Exam0160처럼 개발자가 직접 Iterator를 사용할 것인지,
    //      for를 사용해서 호출할지 정해야한다.
    for (String s : stack) {
      System.out.println(s);
    }

  }

}

