package com.eomcs.lang.ex07;

// # JVM 아규먼트 응용 II
//
public class Exam0630 {

  public static void main(String[] 변수명은상관없다) {
    // JVM에 기본으로 설정되어 있는 프로퍼티를 모두 출력하라!
    //
    // JVM의 전체 프로퍼티 목록 가져오기
    java.util.Properties props = System.getProperties();

    // 1) Properties 객체에 저장되어 있는 값의 이름(key)를 알아낸다.
    // => keySet() 이 리턴하는 것은 이름이 들어있는 집합이다.
    java.util.Set keySet = props.keySet();

    // 이름 목록에서 한 개의 이름을 가져와서 그 이름으로 저장된 값을 꺼낸다.
    // => 이름 목록에서 꺼낸 값이 실제는 String이지만,
    // => 문법 상에서는 Object로 되어 있어서 
    // 변수를 선언할때 Object 타입으로 변수 선언해야함.
    for (Object key : keySet) {
      // getProperty()에 이름을 전달할 때는 String을 전달해야한다.
      // 물론 Key에 들어있는 것은 String이 맞지만 
      //문법 상으로는 key변수가 Object로 되어있다.
      //따라서 getProperty()에 key 변수에 들어있는 값을 전달할때 
      //String이라고 컴파일러에 알려줄 필요있음.
      props.getProperty((Stirng) key);
      System.out.printf("%s = %s\n", key, value);
    }

    //위 문장을 다음과 같이 바꿔도 됨.
    //    for (Object key : keySet) {
    //      String value = System.getProperty((String) key);
    //      System.out.printf("%s = %s\n", key, value);
    //    }
  }
}


