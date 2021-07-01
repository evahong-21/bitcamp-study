package com.eomcs.lang.ex01;

class A {
    public static void main(String[] args) {
        System.out.println("Exam0120 A");
    }
}
class B {
    public static void main(String[] args) {
        System.out.println("Exam0120 B");
    }
}
class C {
    public static void main(String[] args) {
        System.out.println("Exam0120 C");
    }
}

// compile하면 각각의 class 명에 해당하는 class 파일이 생성됨.
// 생성 > 해당 경로에 A.class, B.class, C.class 가 생성됨.
// 각각의 class파일을 생성하고 싶을땐 이름으로 java 명령 실행 
// class 앞에 public 함수가 안붙었으므로 비공개 클래스 > 에러안남