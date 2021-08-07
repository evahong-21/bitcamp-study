package com.eomcs.pms;

import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.pms.menu.Menu;
import com.eomcs.pms.menu.MenuGroup;
import com.eomcs.util.Prompt;

public class App {
  BoardHandler boardHandler = new BoardHandler();
  MemberHandler memberHandler = new MemberHandler();
  ProjectHandler projectHandler = new ProjectHandler(memberHandler);
  TaskHandler taskHandler = new TaskHandler(memberHandler);

  Menu createMenu() {
    MenuGroup rootMenu = new MenuGroup("메인", true);
    MenuGroup boardMenu = new MenuGroup("게시판");
    rootMenu.add(boardMenu);

    boardMenu.add(new Menu("등록") {
      public void execute() {
        boardHandler.add();
      }});

    boardMenu.add(new Menu("목록"){
      public void execute() {
        boardHandler.list();
      }});

    boardMenu.add(new Menu("상세조회"){
      public void execute() {
        boardHandler.detail();
      }});

    boardMenu.add(new Menu("변경") {
      public void execute() {
        boardHandler.update();
      }});

    boardMenu.add(new Menu("삭제") {
      public void execute() {
        boardHandler.delete();
      }});


    MenuGroup memberMenu = new MenuGroup("회원");
    rootMenu.add(memberMenu);

    memberMenu.add(new Menu("등록") {
      public void execute() {
        memberHandler.add();
      }});

    memberMenu.add(new Menu("목록"){
      public void execute() {
        memberHandler.list();
      }});

    memberMenu.add(new Menu("상세조회"){
      public void execute() {
        memberHandler.detail();
      }});

    memberMenu.add(new Menu("변경") {
      public void execute() {
        memberHandler.update();
      }});

    memberMenu.add(new Menu("삭제") {
      public void execute() {
        memberHandler.delete();
      }});


    MenuGroup projectMenu = new MenuGroup("프로젝트");
    rootMenu.add(projectMenu);

    projectMenu.add(new Menu("등록") {
      public void execute() {
        projectHandler.add();
      }});

    projectMenu.add(new Menu("목록"){
      public void execute() {
        projectHandler.list();
      }});

    projectMenu.add(new Menu("상세조회"){
      public void execute() {
        projectHandler.detail();
      }});

    projectMenu.add(new Menu("변경") {
      public void execute() {
        projectHandler.update();
      }});

    projectMenu.add(new Menu("삭제") {
      public void execute() {
        projectHandler.delete();
      }});

    MenuGroup taskMenu = new MenuGroup("작업");
    rootMenu.add(taskMenu);

    taskMenu.add(new Menu("등록") {
      public void execute() {
        taskHandler.add();
      }});

    taskMenu.add(new Menu("목록"){
      public void execute() {
        taskHandler.list();
      }});

    taskMenu.add(new Menu("상세조회"){
      public void execute() {
        taskHandler.detail();
      }});

    taskMenu.add(new Menu("변경") {
      public void execute() {
        taskHandler.update();
      }});

    taskMenu.add(new Menu("삭제") {
      public void execute() {
        taskHandler.delete();
      }});
    return rootMenu;
  }

  void service() { 
    //인스턴스 메서드는 다른 인스턴스 메서드를 new로 생성 안해도 사용가능.
    createMenu().execute();
    Prompt.close();
  }

  public static void main(String[] args) {
    App app = new App();
    app.service();


  }
}












