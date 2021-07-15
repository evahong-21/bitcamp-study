package com.eomcs.algorithm.quiz;

public class Test001_ {

  // 한줄에 버그가 있다 고쳐라.
  static int countEvenNumber(int value) { // value는 n으로 받는것을 추천.
    // 일단 10씩 나눠가면서 끝의 자리가 2로 나눴을때 0인지 1인지 확인하여 count함.
    int count=0;
    while (1<value) { // (value>0)
      if (value % 2 == 0) { // (n & 1)== 0 : 비트연산자 1과 비교함.
        count++;
      }
      value/=10;

    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(countEvenNumber(1238694636));

  }

}
