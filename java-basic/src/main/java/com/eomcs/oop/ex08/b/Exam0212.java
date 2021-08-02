// 캡슐화(encapsulation) - 접근 범위 테스트
// 다른 패키지의 멤버가 접근할 수 있는 범위.
package com.eomcs.oop.ex08.b;


public class Exam0212 {

  public static void main(String[] args) {
    // B 클래스는 Exam0212와 다른 패키지이다.

    com.eomcs.oop.ex08.b.sub.Y obj1 = new com.eomcs.oop.ex08.b.sub.Y();

    //obj1.privateVar = 100; // 접근 불가! 오직 그 클래스 안에서만 사용가능.
    //obj1.defaultVar = 100; // 접근불가! 같은 패치지까지만 접근 가능.
    //obj1.protectedVar = 100; // 접근불가 ! 같은 패키지 또는 자식 클래스 접근 가능.
    obj1.publicVar = 100; // OK! 모두 다 접근 가능!
  }
}

// private      : 클래스 안에서만 접근 가능
// (default)    : private + 같은 패키지 소속
// protected    : (default) + 서브 클래스로 만든 변수인 경우 서브 클래스에서 접근 가능
// public       : 모두 접근 가능
//
// 실무
// => 인스턴스 변수는 보통 private (or protected)으로 접근을 제한한다.
// => 겟터,셋터는 public으로 접근을 모두에게 공개한다.
// => 일반 메서드도 public으로 접근을 모두에게 공개한다.
// => 그 클래스 내부에서만 사용되는 메서드는 private으로 접근을 제한한다.
// => 자식 클래스의 접근을 허용할 필요가 있을 경우에만 protected로 만든다.
// => 다른 개발자가 사용할 클래스 모음을 만들 때
//    그 모음집 내에서만 사용될 변수나 메서드인 경우 (default)로 접근을 제한한다.
//    즉 라이브러리를 만드는 개발자인 경우 (default)를 사용하는 경우가 있다.






