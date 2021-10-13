// Statement 와 SQL 삽입 공격
package com.eomcs.jdbc.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam0210 {

  public static void main(String[] args) throws Exception {
    String title = null;
    String contents = null;

    try (Scanner keyboard = new Scanner(System.in)) {

      System.out.print("제목? ");
      title = keyboard.nextLine();

      System.out.print("내용? ");
      contents = keyboard.nextLine();
    }

    try (Connection con = DriverManager.getConnection( //
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement("insert into x_board(title,contents) values(?,?)")) {

      // SQL 삽입 공격
      // => 입력 문자열에 SQL 명령을 삽입하여 프로그램의 의도와 다르게 데이터를 조작하는 행위.
      // => 사용자가 입력한 값을 가지고 SQL 문장을 만들 때 이런 문제가 발생한다.
      // => 예를 들어 이 예제를 실행할 때 다음과 같이 입력해 보라!
      // 번호? 1
      // 제목? okok
      // 내용? test', view_count = 300, created_date = '2019-3-3
      // 위에서 준비한 SQL 문의 값을 설정
      // = ? : 값을 놓일 자리를 의미한다 'in-parameter'라 부른다.

      stmt.setString(1, title);
      stmt.setString(2, contents);

      int count = stmt.executeUpdate();

      // SQL injection 공격이 불가.

      if (count == 0) {
        System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
      } else {
        System.out.println("변경하였습니다.");
      }
    }
  }
}
