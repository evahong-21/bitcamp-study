package com.eomcs.algorithm.quiz;

// 출처: codefights.com
//
// 배열의 전체 길이를 L이라고 하자.
// 배열을 절반(L/2)으로 나눌 때, 앞쪽 부분과 뒤쪽 부분의 위치를 바꿔라.
// 예)
// [2, 4, 5, 6, 4, 3, 7, 8] => [4, 3, 7, 8, 2, 4, 5, 6]
//
// 한 줄에 버그가 있다. 고쳐라!
public class Test003_ {

  static void changeValuePosition(int[] values) {
    //짝수라면 
    int half = values.length >> 1 ;
    //홀수까지 생각했을 때 
    int addIndex = values.length & 1;
    int tmp;
    for (int i = 0; i < half; i++) { // 0에서 3까지 4번반복.
      tmp = values[i]; // 5, 6, 7, 8 tmp = 5
      values[i] = values[i + half + addIndex]; // 5,6,7,8 va[0] = [5]
      values[i + half + addIndex] = tmp; //5,6,7,8 v[5] = 
    }
  }

  public static void main(String[] args) {
    int[] values = {2, 4, 5, 6, 9, 4, 3, 7, 8};
    changeValuePosition(values);

    for (int v : values) {
      System.out.print(v + ",");
    }
  }

}
