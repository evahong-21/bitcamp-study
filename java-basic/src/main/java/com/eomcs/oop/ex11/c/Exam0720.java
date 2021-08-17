// inner class 응용 II : 2단계 - 스태틱 중첩 클래스 사용.
package com.eomcs.oop.ex11.c;

import java.util.ArrayList;
import java.util.List;

public class Exam0720 {
  public static void main(String[] args) {
    Musics4 m1 = new Musics4();
    m1.add("aaa.mp3");
    m1.add("bbb.mp3");
    m1.add("bbb.mp3");

    Musics4 m2 = new Musics4();
    m2.add("xxx.mp3");
    m2.add("yyy.mp3");


    Player p1 = m1.createPlayer();
    Player p2 = m2.createPlayer();

    p1.play();
    p2.play();
  }
}

interface Player {
  void play();
}

class Musics4 {

  List<String> songs = new ArrayList<>();

  public void add(final String song) {
    songs.add(song);
  }

  public void delete(final int index) {
    songs.remove(index);
  }

  public Player createPlayer() {
    return new PlayerImpl();
  }

  class PlayerImpl implements Player {
    public void play() {
      // 필드에 보관되어 있는 
      for (final String song : songs) {
        System.out.println(song);
      }
      System.out.println("-----------------------------");
    }
  }

}


