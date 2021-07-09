package com.eomcs.lang.ex04;

import java.util.Arrays;

//# 배열 - 배열 메모리 초기화 
public class Exam0570 {
  public static void main(String[] args) {
    // 배열 선언
    int[] arr1 = new int[5]; // OK!

    // 배열 메모리를 특정 값으로 초기화 
    arr1[0] = 100;
    arr1[1] = 90;
    arr1[2] = 80;
    arr1[3] = 70;
    arr1[4] = 60;

    // 1) 배열 선언 + 초기화 명령
    int[] arr2 = new int[]{100, 90, 80, 70, 60}; // OK!
    //int[] arr2 = new int[5]{100, 90, 80, 70, 60}; // 문법오류! 배열 개수 지정하면 안된다. 
    System.out.println(Arrays.toString(arr2));

    // 2) 배열 선언 + 초기화 명령 II
    int[] arr3 = {100, 90, 80, 70, 60}; // new int[] 생략 가능
    System.out.println(Arrays.toString(arr3));

    // 그러나 배열 변수를 선언한 후 따로 초기화시킬 때는
    // 다음과 같이 new 명령을 생략할 수 없다.
    int[] arr4;
    //arr4 = {100, 90, 80, 70, 60}; // 컴파일 오류!
    //System.out.println(arr4); > 초기화가 안됐으므로 호출 불가능.

    // 배열 초기화 명령을 따로 실행할 때는 new int[] 를 생략할 수 없다. <-> 2번과 차이. ####
    int[] arr5;
    arr5 = new int[]{0, 0, 0, 0, 0}; 
    System.out.println(Arrays.toString(arr5));
  }
}

// 정리!
// 1) 배열 선언 + 초기화
//    데이터타입[] 변수명 = new 데이터타입[]{값, 값, 값};
//    - 배열 메모리를 초기화시킬 때는 배열 개수를 지정해서는 안된다.
//    - 배열을 초기화시키는 값의 개수 만큼 메모리가 만들어진다.
//    - 즉 다음은 값 개수만큼 int 메모리가 3개가 생성된다.
//      ex) int[] arr = new int[]{10, 20, 30};
//    - 다음과 같이 new 명령을 생략할 수 있다.
//      데이터타입[] 변수명 = {값, 값, 값};
//      ex) int[] arr = {10, 20, 30};
// 
// 2) 배열 선언 후 따로 배열 초기화 문장 실행
//    데이터타입[] 변수명;
//    변수명 = new 데이터타입[]{값, 값, 값};
//    ex) 
//    int[] arr1;
//    arr1 = new int[]{10, 20, 30}; 
//    - 변수를 선언한 후 따로 배열을 초기화시킬 때는 
//      new 명령을 생략할 수 없다.

