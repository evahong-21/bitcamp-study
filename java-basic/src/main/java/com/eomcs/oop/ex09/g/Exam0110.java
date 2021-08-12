// 인터페이스 활용: 스태틱 메서드의 활용
package com.eomcs.oop.ex09.g;

public class Exam0110 {
  public static void main(String[] args) {
    Tico c1 = new Tico(1,2,3);
    //    Tico c1 = new Tico();
    //    c1.gas = 10;
    //    c1.brakeOil = 10;
    //    c1.engineOil = 10;
    //Tico가 직접 CarCheckInfo를 구현한 것은 아니지만, 
    if (CarCheckInfo.validate(c1)) {
      c1.start();
      c1.run();
      c1.shutdown();
    } else {
      System.out.println("자동차를 점검하시기 바랍니다. 문제 발생!");
    }

  }
}
