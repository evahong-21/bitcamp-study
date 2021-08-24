// 아규먼트에 람다(lambda) 활용
package com.eomcs.oop.ex12;

public class Exam0310 {

  static interface Player {
    void play();
  }

  static void testPlayer(Player p) {
    p.play();
  }

  public static void main(String[] args) {
    // 로컬 클래스 - 시작
    class MyPlayer implements Player {
      @Override
      public void play() {
        System.out.println("실행1");
      }
    }
    testPlayer(new MyPlayer());

    // 중간1
    Player p = new Player() {
      @Override
      public void play() {
        System.out.println("실행2");
      }
    };
    testPlayer(p);

    // 증긴2
    testPlayer(new Player() {
      @Override
      public void play() {
        System.out.println("실행3");
      }
    });

    //
    testPlayer(() -> System.out.println("실행4"));

    Player p3 = ()-> System.out.println("실행5");
    p3.play();
  }
}


