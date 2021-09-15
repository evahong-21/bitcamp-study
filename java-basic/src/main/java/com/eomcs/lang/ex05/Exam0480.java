package com.eomcs.lang.ex05;

//# 비트 연산자 : 응용 III
//
public class Exam0480 {
  public static void main(String[] args) {
    // 1) 사용자 권한을 값으로 정의
    final int LOGOUT = 0x01; //00000001
    final int GENERAL = 0x02; //00000010
    final int MANAGER = 0x04; //00000100

    // 2) 메뉴의 접근 범위 설정
    int menu1 = LOGOUT; // 로그아웃만
    int menu2 = GENERAL; // 일반 로그인만
    int menu3 = MANAGER; // 관리자만
    int menu4 = LOGOUT | GENERAL | MANAGER; //로그아웃이든, 일반이든, 관리자든 다 볼 수 있게

    // 3) 접근테스트
    // => menu1이 로그아웃 상태에서 접근 가능한 것인지 검사한다.
    System.out.println((menu1 & LOGOUT)>0);
    // 계산원리
    // menu1 : 00000001
    // LOGOUT: 00000001
    // 
  }
}
