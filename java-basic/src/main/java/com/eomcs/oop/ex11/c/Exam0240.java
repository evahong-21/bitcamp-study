// inner class : 다른 멤버에 접근하기
package com.eomcs.oop.ex11.c;

class B3 {
  // 인스턴스 멤버
  int v1 = 10;
  int v2 = 20;

  class X {
    int v1=100;

    void test() {
      int v1 = 2000;
      System.out.println(v1);
      System.out.println(this.v1);
      System.out.println(B3.this.v1);
    }
  }
}

public class Exam0240 {

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
