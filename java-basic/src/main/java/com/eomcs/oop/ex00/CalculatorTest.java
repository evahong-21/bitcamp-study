package com.eomcs.oop.ex00;

public class CalculatorTest {
  public void main(String[] args) {
    // 2 + 3 + 4 - 7 * 3 = 6
    // 3 * 2 - 1 = 5
    Calculator cal1 = new Calculator();
    Calculator cal2 = new Calculator();

    cal1.plus(2);
    cal1.plus(3);
    cal1.plus(4);
    cal1.minus(7);
    cal1.multiple(3);
    System.out.println(cal1.result);

    //Calculator.result=0;
    cal2.plus(3);
    cal2.multiple(2);
    cal2.minus(1);

    System.out.println(cal2.result);
  }


}
