// stack과 Deque : Iterator
package com.eomcs.basic.ex05;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Exam0220 {

  public static void main(String[] args) {

    ArrayDeque<String> stack = new ArrayDeque<>();

    // push() - 스택의 맨 마지막에 값을 추가한다.
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");

    // Stack 클래스와 다르게 Deque 구현체의 Iterator는 
    // 스택 방식(LIFO)으로 데이터를 꺼낸다.
    // 결론!
    // Iterator를 통해 데이터를 꺼낼때 스택의 특성을 그대로 유지하고 싶다면
    // Stack 클래스 대신 ArrayDeque 클래스를 사용하라!

    Iterator<String> iterator = stack.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    //여기서 잠깐!
    // Iterator 설계 기법의 목적
    // - 데이터 조회 방식(LiFO, FIFO)에 상관없이 일관된 방법으로 데이터 조회 가능
    // - 즉 스택처럼 역순으로 꺼내던 큐처럼 입력순으로 꺼내던

  }

}

