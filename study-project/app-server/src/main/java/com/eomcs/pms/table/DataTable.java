package com.eomcs.pms.table;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.google.gson.Gson;

// 역할
// - 게시글 데이터를 저장하고 조회하는 일을 한다.

public abstract class DataTable<T> {

  protected List<T> list = new ArrayList<>();
  String filename;

  public DataTable(String filename) {
    this.filename = filename;
    // JSON 파일에서 데이터를 로딩한다.
    loadObjects();

  }

  public void save() {
    // 데이터를 JSON 형식으로 파일에 저장한다.
    saveObjects();

  }

  // JSON 형식으로 저장된 데이터를 읽어서 객체로 만든다.
  @SuppressWarnings("unchecked")
  private void loadObjects() {

    try (BufferedReader in = new BufferedReader(
        new FileReader(filename, Charset.forName("UTF-8")))) {

      StringBuilder strBuilder = new StringBuilder();
      String str;
      while ((str = in.readLine()) != null) { // 파일 전체를 읽는다.
        strBuilder.append(str);
      }


      // StringBuilder로 읽어 온 JSON 문자열을 객체로 바꾼다.
      //      Type type = TypeToken.getParameterized(Collection.class, domainType).getType(); 
      Collection<T> collection = new Gson().fromJson(strBuilder.toString(), list.getClass());

      // JSON 데이터로 읽어온 목록을 파라미터로 받은 List 에 저장한다.
      list.addAll(collection);

      System.out.printf("%s 데이터 로딩 완료!\n", filename);

    } catch (Exception e) {
      System.out.printf("%s 데이터 로딩 오류!\n", filename);
    }
  }

  // 객체를 JSON 형식으로 저장한다.
  private void saveObjects() {
    try (PrintWriter out = new PrintWriter(
        new BufferedWriter(
            new FileWriter(filename, Charset.forName("UTF-8"))))) {

      out.print(new Gson().toJson(list));

      System.out.printf("%s 데이터 출력 완료!\n", filename);

    } catch (Exception e) {
      System.out.printf("%s 데이터 출력 오류!\n", filename);
      e.printStackTrace();
    }
  }
}
