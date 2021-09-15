package com.eomcs.pms.domain;

import java.sql.Date;
import com.eomcs.csv.CsvValue;

public class Board implements CsvValue {
  private int no;
  private String title;
  private String content;
  private Member writer;
  private Date registeredDate;
  private int viewCount;
  private int like;

  @Override
  public String toString() {
    return "Board [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer
        + ", registeredDate=" + registeredDate + ", viewCount=" + viewCount + ", like=" + like
        + "]";
  }

  @Override
  public String toCsvString() {
    return String.format("%d,%s,%s,%s,%d,%d,%d,%s",
        this.getNo(),
        this.getTitle(),
        this.getContent(),
        this.getRegisteredDate(),
        this.getViewCount(),
        this.getLike(),
        this.getWriter().getNo(),
        this.getWriter().getName());
  }

  @Override
  public void loadCsv(String csv) {
    // TODO Auto-generated method stub
    String[] values = csv.split(",");

    // 2) 콤마로 분리한 값을 Board 객체에 담는다.
    this.setNo(Integer.valueOf(values[0]));
    this.setTitle(values[1]);
    this.setContent(values[2]);
    this.setRegisteredDate(Date.valueOf(values[3]));
    this.setViewCount(Integer.valueOf(values[4]));
    this.setLike(Integer.valueOf(values[5]));

    // 3) 게시글을 작성한 회원 정보를 Member 객체에 담는다.
    Member m = new Member();
    m.setNo(Integer.valueOf(values[6]));
    m.setName(values[7]);

    // 4) Member 객체를 Board 객체의 작성자 필드에 저장한다.
    this.setWriter(m);
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public int getLike() {
    return like;
  }
  public void setLike(int like) {
    this.like = like;
  }
  public Member getWriter() {
    return writer;
  }
  public void setWriter(Member writer) {
    this.writer = writer;
  }

}
