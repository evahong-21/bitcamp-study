package com.eomcs.lang.ex01;
public class Exam2_2x {
    public static void main(String[] args){
        System.out.println("체크 Exam0220");
    }
}
/*
src\main\java\com\eomcs\lang\ex01\Exam0220.java:2: error: class Exam2_2x is public, should be declared in a file named Exam2_2x.java
public class Exam2_2x {
       ^
1 error
이런식으로 에러메세지가 남.
원인 : 공개 클래스인데 자바파일 이름과 class이름이 다르기 때문에 에러.
*/