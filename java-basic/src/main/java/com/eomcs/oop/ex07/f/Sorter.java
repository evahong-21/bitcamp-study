package com.eomcs.oop.ex07.f;

// 추상 메서드만 있을 경우,
// 객체 사용 규칙을 정의하는 " 인터페이스" 문법으로 바꿔도 좋다.

public interface Sorter {
  // 인터페이스는 호출 규칙을 정의하는 것이기 떄문에 
  // 모든 메서드는 기본이 public 이고, abstract 이다.
  // => 다음과 같이 public, abstract 생략 가능.

  //interface의 메서드를 쓰는것도 Override라고 함.
  void sort(int[] values);
}
