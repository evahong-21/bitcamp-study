package com.eomcs.pms.mini_02_c;
import java.util.Date;
import java.util.Scanner;

// 1) 배열사용 전.
public class App0_0 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int no1,no2,no3,no4,no5;
    String name1,name2,name3,name4,name5;
    String email1,email2,email3,email4,email5;
    String passwd1,passwd2,passwd3,passwd4,passwd5;
    String photo1,photo2,photo3,photo4,photo5;
    String tel1,tel2,tel3,tel4,tel5;
    Date regisDate1,regisDate2,regisDate3,regisDate4,regisDate5;

    Scanner scn = new Scanner(System.in);
    ///////////////////////////////////1번째
    System.out.println("[회원]");
    System.out.println("번호? ");
    no1 = Integer.parseInt(scn.nextLine());

    System.out.println("이름? ");
    name1 = scn.nextLine();

    System.out.println("이메일? ");
    email1 = scn.nextLine();

    System.out.println("암호? ");
    passwd1 = scn.nextLine();

    System.out.println("사진? ");
    photo1 = scn.nextLine();

    System.out.println("전화? ");
    tel1 = scn.nextLine();

    regisDate1 = new Date();
    System.out.println();

    /////////////////////////////////////2번째

    System.out.println("[회원]");
    System.out.println("번호? ");
    no2 = Integer.parseInt(scn.nextLine());

    System.out.println("이름? ");
    name2 = scn.nextLine();

    System.out.println("이메일? ");
    email2 = scn.nextLine();

    System.out.println("암호? ");
    passwd2 = scn.nextLine();

    System.out.println("사진? ");
    photo2 = scn.nextLine();

    System.out.println("전화? ");
    tel2 = scn.nextLine();

    regisDate2 = new Date();
    System.out.println();

    ///////////////////////////////////3번째
    System.out.println("[회원]");
    System.out.println("번호? ");
    no3 = Integer.parseInt(scn.nextLine());

    System.out.println("이름? ");
    name3 = scn.nextLine();

    System.out.println("이메일? ");
    email3 = scn.nextLine();

    System.out.println("암호? ");
    passwd3 = scn.nextLine();

    System.out.println("사진? ");
    photo3 = scn.nextLine();

    System.out.println("전화? ");
    tel3 = scn.nextLine();

    regisDate3 = new Date();
    System.out.println();

    ///////////////////////////////////4번째
    System.out.println("[회원]");
    System.out.println("번호? ");
    no4 = Integer.parseInt(scn.nextLine());

    System.out.println("이름? ");
    name4 = scn.nextLine();

    System.out.println("이메일? ");
    email4 = scn.nextLine();

    System.out.println("암호? ");
    passwd4 = scn.nextLine();

    System.out.println("사진? ");
    photo4 = scn.nextLine();

    System.out.println("전화? ");
    tel4 = scn.nextLine();

    regisDate4 = new Date();
    System.out.println();

    ///////////////////////////////////5번째
    System.out.println("[회원]");
    System.out.println("번호? ");
    no5 = Integer.parseInt(scn.nextLine());

    System.out.println("이름? ");
    name5 = scn.nextLine();

    System.out.println("이메일? ");
    email5 = scn.nextLine();

    System.out.println("암호? ");
    passwd5 = scn.nextLine();

    System.out.println("사진? ");
    photo5 = scn.nextLine();

    System.out.println("전화? ");
    tel5 = scn.nextLine();

    regisDate5 = new Date();
    System.out.println();

    scn.close();

    System.out.println("---------------------");
    System.out.printf("번호: %s",no1);
    System.out.printf("\n이름: %s", name1);
    System.out.printf("\n이메일: %s", email1);
    System.out.printf("\n암호: %s", passwd1);
    System.out.printf("\n사진: %s", photo1);
    System.out.printf("\n전화: %s", tel1);
    //System.out.printf("\n가입일: %1$tY-%1$tm-%1$td", date); // 아래랑 같은 결과.
    System.out.printf("\n가입일: %s",regisDate1);

    System.out.printf("번호: %s",no2);
    System.out.printf("\n이름: %s", name2);
    System.out.printf("\n이메일: %s", email2);
    System.out.printf("\n암호: %s", passwd2);
    System.out.printf("\n사진: %s", photo2);
    System.out.printf("\n전화: %s", tel2);
    //System.out.printf("\n가입일: %1$tY-%1$tm-%1$td", date); // 아래랑 같은 결과.
    System.out.printf("\n가입일: %s",regisDate2);

    System.out.printf("번호: %s",no3);
    System.out.printf("\n이름: %s", name3);
    System.out.printf("\n이메일: %s", email3);
    System.out.printf("\n암호: %s", passwd3);
    System.out.printf("\n사진: %s", photo3);
    System.out.printf("\n전화: %s", tel3);
    //System.out.printf("\n가입일: %1$tY-%1$tm-%1$td", date); // 아래랑 같은 결과.
    System.out.printf("\n가입일: %s",regisDate3);

    System.out.printf("번호: %s",no4);
    System.out.printf("\n이름: %s", name4);
    System.out.printf("\n이메일: %s", email4);
    System.out.printf("\n암호: %s", passwd4);
    System.out.printf("\n사진: %s", photo4);
    System.out.printf("\n전화: %s", tel4);
    //System.out.printf("\n가입일: %1$tY-%1$tm-%1$td", date); // 아래랑 같은 결과.
    System.out.printf("\n가입일: %s",regisDate4);

    System.out.printf("번호: %s",no5);
    System.out.printf("\n이름: %s", name5);
    System.out.printf("\n이메일: %s", email5);
    System.out.printf("\n암호: %s", passwd5);
    System.out.printf("\n사진: %s", photo5);
    System.out.printf("\n전화: %s", tel5);
    //System.out.printf("\n가입일: %1$tY-%1$tm-%1$td", date); // 아래랑 같은 결과.
    System.out.printf("\n가입일: %s",regisDate5);
  }

}
