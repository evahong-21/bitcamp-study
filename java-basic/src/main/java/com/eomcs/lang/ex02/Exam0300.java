package com.eomcs.lang.ex02;
public class Exam0300 {
    public static void main(String[] args){
        System.out.println("에노테이션 EX");
    }

    //@Override
    public String toString() {
        return "Exam0300";
    }
}


/*
1. 그냥 컴파일 > 실행 : 에러없이 잘 실행됨.
2 toString2() 로 변경하고 컴파일 > 실행 : 아래와 같은 에러메시지.
src\main\java\com\eomcs\lang\ex02\Exam0200.java:7: error: method does not override or implement a method from a supertype
    @Override
    ^
1 error

3. @Override 주석하고 컴파일 > 실행 : 에러안남.

*/