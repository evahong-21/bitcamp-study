package com.eomcs.oop.ex00;

public class Test1 {

  static void deleteValue(int[] arr, int value) {
    int count = -1;
    for (int i =0; i<arr.length; i++) {
      if (arr[i]==value) {
        count = i;
        break;
      }
    }
    for (int j=count+1; j<arr.length; j++) {
      arr[j-1] = arr[j];
      arr[arr.length-1] = -1;
    }

  }
  public static void main(String[] args) {
    int[] arr = {100,200,300};
    deleteValue(arr, 200);
    for (int value : arr) {
      if (value == -1) 
        break;
      System.out.println(value);
    }
  }
}
