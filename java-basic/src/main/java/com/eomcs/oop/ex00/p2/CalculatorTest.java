package com.eomcs.oop.ex00.p2;

public class CalculatorTest {
  public static void main(String[] args) {
    // 2 + 3 + 4 - 7 * 3 = 6
    // 3 * 2 - 1 = 5

    Calculator.plus(2);
    Calculator.plus(3);
    Calculator.plus(4);
    Calculator.minus(7);
    Calculator.multiple(3);
    System.out.println(Calculator.result);
    //static 변수를 다시 사용하고 싶으면 초기화 해야함.
    Calculator.result = 0;
    Calculator.plus(3);
    Calculator.multiple(2);
    Calculator.minus(1);
    System.out.println(Calculator.result);

  }


}
