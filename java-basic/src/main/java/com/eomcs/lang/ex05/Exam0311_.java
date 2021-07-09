package com.eomcs.lang.ex05;

//# 논리 연산자 : &&, ||, !(not), ^(XOR; exclusive-OR)
//
public class Exam0311_ {
  public static void main(String[] args) {
    // AND 연산자 
    // - 두 개의 논리 값이 모두 true일 때 결과가 true가 된다.
    // boolean 타입이 아닌 데이터 타입에 대해서는 사용 불가
    // 아래 3가지 경우에는 컴파일 에러.
    //System.out.println(0 && 1);
    //System.out.println(0 || 1);
    //System.out.println(!0);
    // ^ 연산자를 정수값에 대해 사용하면 비트 단위로 연산을 수행함

    System.out.println(1 ^ 0);
    System.out.println(1 ^ 1);
    System.out.println(3 ^ 2);
    System.out.println(2 ^ 3);


  }
}
