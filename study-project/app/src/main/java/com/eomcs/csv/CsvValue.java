package com.eomcs.csv;

// CSV 값을 다루는 도메인 객체를 사용한 
public interface CsvValue {
  String toCsvString();

  void loadCsv(String csv);
}
