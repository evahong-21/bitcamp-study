// 추상 클래스를 인터페이스로 전환하기.
package com.eomcs.oop.ex07.f;

public class Exam01 {

  public static void main(String[] args) {
    int[] values = {23, 7, 12, 15, 9, 2, 22, 8, 11, 25, 13, 5};
    int[] values2 = {23, 7, 12, 15, 9, 2, 22, 8, 11, 25, 13, 5};
    int[] values3 = {23, 7, 12, 15, 9, 2, 22, 8, 11, 25, 13, 5};

    // Sorter 추상 클래스처럼 
    display(new BubbleSort(), values);
    display(new QuickSort(), values2);
    display(new MergeSort(), values3);

  }

  static void display(Sorter sorter, int[] values) {

    // 어? 강사님! Sorter 클래스의 sort() 메서드는 추상 메서드인데
    // 어떻게 호출할 수 있나요? 다음 코드는 오류가 아닌가요?
    // => 레퍼런스를 통해 메서드를 호출할 때
    //    실제 레퍼런스가 가리키는 인스턴스의 클래스에서 메서드를 찾아 올라간다.
    //    즉 Sorter 추상 클래스의 sort() 추상 메서드를 호출하는 것이 아니다.
    //    sorter 레퍼런스가 실제 가리키는 BubbleSort, QuickSort,
    //    MergeSort 객체의 sort()를 호출하는 것이다.
    //
    //
    sorter.sort(values);

    // 정렬된 값을 출력한다.
    for (int  value : values) {
      System.out.print(value + ",");
    }
    System.out.println();
  }
}






