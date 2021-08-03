// 상속 - 사용 전
package com.eomcs.oop.ex05.a;

public class Exam01 {
  public static void main(String[] args) {
    Car c1 = new Car();
    c1.maker = "비트자동차";
    c1.model = "티코";
    c1.capacity = 5;
    System.out.printf("%s,%s,%d", c1.maker, c1.model, c1.capacity);
    System.out.println();
    Car c2 = new Car("비트자동차", "소나타", 5);
    System.out.printf("%s,%s,%d", c2.maker, c2.model, c2.capacity);
  }
}
