// 클래스 변수의 응용 : 상수 변수를 import 하기.
//
package com.eomcs.oop.ex03;

// 스테틱 변수를 사용할 때 다음과 같이 소속 클래스를 미리 밝혀두면
// 클래스 이름 없이 스태틱 변수를 사용할 수 있다.
import static com.eomcs.oop.ex03.Member.GUEST;
import static com.eomcs.oop.ex03.Member.MANAGER;
import static com.eomcs.oop.ex03.Member.MEMBER;
// 여러개 원할때.
//import static com.eomcs.oop.ex03.Member.*;

public class Exam0162_ {

  public static void main(String[] args) {

    // Member와 관련된 상수라면 
    // Member 클래스에 선언하는 것이 유지보수에 더 낫다.

    Member m4 = new Member();
    m4.id = "aaa";
    m4.password = "1111";
    m4.type = GUEST;
    // 스태틱 변수는 변수명 앞에 클래스명을 명시해야 한다.

    Member m5 = new Member();
    m5.id = "bbb";
    m5.password = "1111";
    m5.type = MANAGER;

    Member m6 = new Member();
    m6.id = "ccc";
    m6.password = "1111";
    m6.type = MEMBER;
  }
}








