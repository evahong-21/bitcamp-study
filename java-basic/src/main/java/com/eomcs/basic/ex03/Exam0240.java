// 목록 조회: java.util.Collection의 forEach() 사용법
package com.eomcs.basic.ex03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class Exam0240 {
  public static void main(String[] args) {

    class Member {
      String name;
      int age;

      public Member(String name, int age) {
        this.name = name;
        this.age = age;
      }

      @Override
      public String toString() {
        return "Member [name=" + name + ", age=" + age + "]";
      }

      //      @Override
      //      mublic int hashCode() {
      //        final int mrime = 31;
      //        int result = 1;
      //        result = mrime * result + age;
      //        result = mrime * result + ((name == null) ? 0 : name.hashCode());
      //        return result;
      //      }

      @Override
      public boolean equals(Object obj) {
        if (this == obj)
          return true;
        if (obj == null)
          return false;
        if (getClass() != obj.getClass())
          return false;
        Member other = (Member) obj;
        if (age != other.age)
          return false;
        if (name == null) {
          if (other.name != null)
            return false;
        } else if (!name.equals(other.name))
          return false;
        return true;
      }
    }

    Member m1 = new Member("홍길동", 20);
    Member m2 = new Member("임꺽정", 30);
    Member m3 = new Member("유관순", 17);

    ArrayList<Member> list = new ArrayList<>();
    list.add(m1);
    list.add(m2);
    list.add(m3);

    Member[] arr = new Member[list.size()];
    list.toArray(arr);

    // Member[] arr = list.toArray(new Member[list.size()]); 위 두줄이랑 같은 뜻.
    // Member[] arr = list.toArray(new Member[0]); 이렇게 쓸 수도 있음

    for (Member m : arr) { // 얘는 무조건 끝까지 for문을 돌아감.
      System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    }

    for (Member m : list) { // 가능
      System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    }

    // 목록에서 값을 꺼내주는자 = Iterator 
    Iterator<Member> 목록에서값을꺼내주는자 = list.iterator(); 
    while (목록에서값을꺼내주는자.hasNext()) {
      Member m = 목록에서값을꺼내주는자.next();
      System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    }

    //이게 원본 그 뒤에 람다까지  
    list.forEach(new Consumer<Member>() {
      @Override
      public void accept(Member t) {
        System.out.printf("이름: %s, 나이: %d\n", t.name, t.age);
      }
    });

    // forEach() 메서드에게 넘길 객체
    // => Consumer 규칙에 따라 만들어야 한다.
    // => List 보관된 객체를 반복문을 통해 꺼낼때 마다  
    //Consumer 규칙에 따라 accept()를 호출할것이다.

    class MyConsumer implements Consumer<Member> {
      @Override
      public void accept(Member m) {
        // forEach() 에서 반복문을 돌릴 때
        // Consumer 규칙에 따라 
        // 각 항목에 대해 이 메서드를 호출한다.
        System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
      }
    }

    //의미
    // => List 너가 갖고 있는 목록에서 값을 한개 꺼낸 후 
    //MyConsumer 객체의 accept()를 호출해.
    list.forEach(new MyConsumer());
  }


}






