// stack과 Deque
package com.eomcs.basic.ex05;

import java.util.ArrayDeque;

public class Exam0210 {

  public static void main(String[] args) {

    //Deque 인터페이스
    // - "Double ended queue" 의 약자이다.
    //      즉, 앞,뒤 모두 양방향에서 값을 넣고 꺼낼 수 있다.
    // - queue와 stack 사용법을 모두 정의한 인터페이스다.
    // - 큐, 스텍 둘다 사용할 수 있도록 queue와 stack 사용법을 모두 정의한다.

    // 다음은 Dequeue 구현체 중의 하나이다.
    ArrayDeque<String> stack = new ArrayDeque<>();

    // push() - 스택의 맨 마지막에 값을 추가한다.
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");

    // stack 도 Iterable 구현체이기 때문에 다음과 같이 for(:)문을 사용 가능.
    // => 내부적으로 iterator()를 호출하여 Iterator를 얻은 후에 이를 통해서 값을 꺼냄.
    // => 결국 Exam0160과 같다.
    //      즉 Exam0160처럼 개발자가 직접 Iterator를 사용할 것인지,
    //      for를 사용해서 호출할지 정해야한다.
    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }

  }

}

