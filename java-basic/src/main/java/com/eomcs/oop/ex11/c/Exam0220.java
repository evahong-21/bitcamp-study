// inner class : 다른 멤버에 접근하기
package com.eomcs.oop.ex11.c;

class B2 {
  // 클래스 멤버
  static int v1 = 10;
  static void m1() {}

  // 인스턴스 멤버
  int v2 = 20;
  int v3 = 30;
  int v4 = 40;
  void m2() {
    System.out.println("B2.v2 = "+ this.v2);
  }

  class X {
    //    바깥 객체의 주소를 저장할 빌트인 필드
    //    B2 this$0;

    //    inner 객체를 생성할때 바깥 객체의 주소를 받는 생성자
    //    public X(B2 p) {
    //      this.this$0 = p;
    //    }

    void test() {
      // 같은 클래스 멤버 접근 가능
      System.out.println(B2.this.v2);
      B2.this.m2();
    }
  }
}

public class Exam0220 {

  public static void main(String[] args) {
    B2 outer  = new B2();
    outer.v2 = 100;
    outer.m2();

    B2 outer2 = new B2();
    outer2.v2 = 200;
    outer2.m2();

    B2.X inner = outer.new X();
    B2.X inner2 = outer2.new X();

    inner.test();
    inner2.test();
  }

}
