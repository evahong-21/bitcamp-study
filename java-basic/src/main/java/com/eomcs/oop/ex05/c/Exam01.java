// 상속 - 상속하지 않고 기능 추가 II
package com.eomcs.oop.ex05.c;

public class Exam01 {
  public static void main(String[] args) {
    // 새 프로젝트에서는 제조사, 모델명, 수용인원 외에
    // 썬루프 장착여부, 자동변속 여부를 추가적으로 저장하고 싶다!
    //
    // 방법2) 기존 코드를 복사하여 새 클래스(Car2)를 만든다.
    //       문제점:
    //       => 같은 일을 하는 여러 클래스가 존재하게 되면 관리하기가 힘들다!
    //       => 만약 원본 코드에 버그가 있으면 버그도 복사하게 된다.
    //          따라서 버그를 고칠 때는 복사한 모든 소스 파일을 찾아 고쳐야 한다.
    Car2 c = new Car2("비트자동차", "티코", 5, true, true);
    System.out.printf("%s,%s,%d,%s,%s", c.maker, c.model, c.capacity, c.sunroof, c.auto);
  }
}


/*
# 기능 추가하기
1) 기존 클래스 파일에 추가하는 방법
  - 기존 코드를 변경하게 되면 원래 되던 기능도 오류가 발생할 수 있는 위험이 있다.
  - 그래서 원래 코드를 손대는 것은 매우 위험한 일이다.
  - 기존에 잘 되던 기능까지 동작이 안되는 문제가 발생할 수 있기 때문이다.

2) 기존 코드를 복사하여 새 클래스를 만드는 방법
  - 장점
    - 기존 코드를 손대지 않기 때문에 문제가 발생할 가능성은 줄인다.
  - 단점
    - 기존 코드의 크기가 큰 경우에는 복사 붙여넣기가 어렵다.
    - 기존 클래스의 소스가 없는 경우에는 이 방법이 불가능하다.
      엥? 다른 개발자가 배포한 라이브러리만 있는 경우를 말한다.
      소스가 없는 다른 개발자가 만든 클래스에 기능을 덧 붙일 때는 이 방법이 불가능하다.
    - 기존 코드에 버그가 있을 때 복사 붙여넣기 해서 만든 클래스도 영향을 받는다.
    - 기존 코드를 변경했을 때 복사 붙여넣기 한 모든 클래스를 찾아 변경해야 한다.
3) 기존 코드를 상속 받아 기능을 추가하는 방법
  - 장점
    - 기존 클래스의 소스 코드가 필요 없다.
    - 간단한 선언으로 상속 받겠다고 표시한 후 새 기능만 추가하면 된다.
  - 단점
    - 일부 기능만 상속 받을 수 없다.
    - 쓰든 안쓰든 모든 기능을 상속 받는다.
 */













