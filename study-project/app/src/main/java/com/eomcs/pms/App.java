package com.eomcs.pms;

import java.awt.Menu;
import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.pms.menu.MenuGroup;
import com.eomcs.util.Prompt;

public class App {
  BoardHandler boardHandler = new BoardHandler();
  MemberHandler memberHandler = new MemberHandler();
  ProjectHandler projectHandler = new ProjectHandler(memberHandler);
  TaskHandler taskHandler = new TaskHandler(memberHandler);

  public static void main(String[] args) {
    App app = new App();
    app.service();
  }

  void service() {
    //    Menu mainMenu = createMenu();
    //    mainMenu.execute();
    // mainMenu 한번만 사용할 것 같을때. >> createMenu().execute();
    createMenu().execute();
    Prompt.close();
  }

  Menu createMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");

    MenuGroup boardMenu = new MenuGroup("게시판");
    mainMenuGroup.add(boardMenu);
    // 중첩클래스 : 바깥에 있는 클래스를 안으로 갖고 옴 > 로컬클래스
    // 중첩 클래스에서 인스턴스를 한번만 만들 것 같을때 클래스 이름 지움 > 익명 클래스
    // 익명 클래스는 생성자가 없음. > super클래스의 생성자를 호출해야함.

    boardMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        boardHandler.add();
      }
    }); // 인스턴스를 생성하기 때문에 맨 끝에 ; 붙여야함

    boardMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        boardHandler.list();
      }
    });


    boardMenu.add(new Menu("상세보기") {
      @Override
      public void execute() {
        boardHandler.detail();
      }
    });
    boardMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        boardHandler.update();
      }
    });
    boardMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        boardHandler.delete();
      }
    });


    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenuGroup.add(memberMenu);


    memberMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        memberHandler.add();
      }
    });
    memberMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        memberHandler.list();
      }
    });
    memberMenu.add(new Menu("상세조회") {
      @Override
      public void execute() {
        memberHandler.detail();
      }
    });
    memberMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        memberHandler.update();
      }
    });
    memberMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        memberHandler.delete();
      }
    });


    MenuGroup projectMenu = new MenuGroup("프로젝트");
    mainMenuGroup.add(projectMenu);

    projectMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        projectHandler.add();
      }
    });
    projectMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        projectHandler.list();
      }
    });
    projectMenu.add(new Menu("상세조회") {
      @Override
      public void execute() {
        projectHandler.detail();
      }
    });
    projectMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        projectHandler.update();
      }
    });
    projectMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        projectHandler.delete();
      }
    });


    MenuGroup taskMenu = new MenuGroup("작업");
    mainMenuGroup.add(taskMenu);


    taskMenu.add(new Menu("등록") {
      @Override
      public void execute() {
        taskHandler.add();
      }
    });
    taskMenu.add(new Menu("목록") {
      @Override
      public void execute() {
        taskHandler.list();
      }
    });
    taskMenu.add(new Menu("상세조회") {
      @Override
      public void execute() {
        taskHandler.detail();
      }
    });
    taskMenu.add(new Menu("변경") {
      @Override
      public void execute() {
        taskHandler.update();
      }
    });
    taskMenu.add(new Menu("삭제") {
      @Override
      public void execute() {
        taskHandler.delete();
      }
    });


    return mainMenuGroup;
  }
}












