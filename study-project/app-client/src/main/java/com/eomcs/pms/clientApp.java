package com.eomcs.pms;

import static com.eomcs.menu.Menu.ACCESS_ADMIN;
import static com.eomcs.menu.Menu.ACCESS_GENERAL;
import static com.eomcs.menu.Menu.ACCESS_LOGOUT;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.eomcs.context.ApplicationContextListener;
import com.eomcs.menu.Menu;
import com.eomcs.menu.MenuGroup;
import com.eomcs.pms.handler.Command;
import com.eomcs.pms.handler.CommandRequest;
import com.eomcs.pms.handler.MemberAddHandler;
import com.eomcs.pms.handler.MemberListHandler;
import com.eomcs.pms.listener.AppInitListener;
import com.eomcs.request.RequestAgent;
import com.eomcs.util.Prompt;

public class ClientApp {

  static RequestAgent requestAgent;
  HashMap<String,Command> commandMap = new HashMap<>();


  class MenuItem extends Menu {
    String menuId;

    public MenuItem(String title, String menuId) {
      super(title);
      this.menuId = menuId;
    }

    public MenuItem(String title, int accessScope, String menuId) {
      super(title, accessScope);
      this.menuId = menuId;
    }

    @Override
    public void execute() {
      Command command = commandMap.get(menuId);
      try {
        command.execute(new CommandRequest(commandMap));
      } catch (Exception e) {
        System.out.printf("%s 명령을 실행하는 중 오류 발생!\n", menuId);
        e.printStackTrace();
      }
    }
  }

  //옵저버 관련 필드와 메서드
  // => 옵저버(리스너) 목록
  List<ApplicationContextListener> listeners = new ArrayList<>();

  // => 옵저버(리스너)를 등록하는 메서드
  public void addApplicationContextListener(ApplicationContextListener listener) {
    this.listeners.add(listener);
  }

  // => 옵저버(리스너)를 제거하는 메서드
  public void removeApplicationContextListener(ApplicationContextListener listener) {
    this.listeners.remove(listener);
  }

  private void notifyOnApplicationStarted() {
    HashMap<String,Object> params = new HashMap<>();

    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(params);
    }
  }

  private void notifyOnApplicationEnded() {
    HashMap<String,Object> params = new HashMap<>();

    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(params);
    }
  }

  public ClientApp() throws Exception {
    // 서버와 통신을 담당할 객체 준비
    requestAgent = new RequestAgent("127.0.0.1", 8888);

    //Command 객체 준비
    commandMap.put("/member/add", new MemberAddHandler(requestAgent));
    commandMap.put("/member/list", new MemberListHandler(requestAgent));

  }


  Menu createMainMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");

    mainMenuGroup.add(new MenuItem("로그인", ACCESS_LOGOUT , "/auth/login"));
    mainMenuGroup.add(new MenuItem("내정보", ACCESS_GENERAL, "/auth/userinfo"));
    mainMenuGroup.add(new MenuItem("로그아웃", ACCESS_GENERAL, "/auth/logout"));

    mainMenuGroup.add(createBoardMenu());
    mainMenuGroup.add(createMemberMenu());
    mainMenuGroup.add(createProjectMenu());
    mainMenuGroup.add(createTaskMenu());
    mainMenuGroup.add(createAdminMenu());

    return mainMenuGroup;
  }

  private Menu createBoardMenu() {
    MenuGroup boardMenu = new MenuGroup("게시판");
    boardMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/board/add"));
    boardMenu.add(new MenuItem("목록", "/board/list"));
    boardMenu.add(new MenuItem("상세보기", "/board/detail"));
    //    boardMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/board/update"));
    //    boardMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/board/delete"));
    boardMenu.add(new MenuItem("검색", "/board/search"));
    return boardMenu;
  }

  private Menu createMemberMenu() {
    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/member/add"));
    memberMenu.add(new MenuItem("목록", "/member/list"));
    memberMenu.add(new MenuItem("상세보기", "/member/detail"));
    //    memberMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/member/update"));
    //    memberMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/member/delete"));
    return memberMenu;
  }

  private Menu createProjectMenu() {
    MenuGroup projectMenu = new MenuGroup("프로젝트");
    projectMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/project/add"));
    projectMenu.add(new MenuItem("목록", "/project/list"));
    projectMenu.add(new MenuItem("상세보기", "/project/detail"));
    //    projectMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/project/update"));
    //    projectMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/project/delete"));
    return projectMenu;
  }

  private Menu createTaskMenu() {
    MenuGroup taskMenu = new MenuGroup("작업");
    taskMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/task/add"));
    taskMenu.add(new MenuItem("목록", "/task/list"));
    taskMenu.add(new MenuItem("상세보기", "/task/detail"));
    //    taskMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/task/update"));
    //    taskMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/task/delete"));
    return taskMenu;
  }

  private Menu createAdminMenu() {
    MenuGroup adminMenu = new MenuGroup("관리자", ACCESS_ADMIN);
    adminMenu.add(new MenuItem("회원 등록", "/member/add"));
    adminMenu.add(new MenuItem("프로젝트 등록", "/project/add"));
    adminMenu.add(new MenuItem("작업 등록", "/task/add"));
    adminMenu.add(new MenuItem("게시글 등록", "/board/add"));
    return adminMenu;
  }
  void service() {

    notifyOnApplicationStarted();

    createMainMenu().execute();
    Prompt.close();

    notifyOnApplicationEnded();
  }

  public static void main(String[] args) throws Exception {
    System.out.println("[PMS 클라이언트]");

    ClientApp app = new ClientApp(); 
    app.addApplicationContextListener(new AppInitListener());
    app.service();

    //    while (true) {
    //      String input = Prompt.inputString("명령> ");
    //
    //      if (input.equals("/board/add")) {
    //        addBoard();
    //
    //      } else if (input.equals("/board/detail")) {
    //        detailBoard();
    //
    //      } else {
    //        requestAgent.request(input, null);
    //
    //        if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
    //          String result = requestAgent.getObject(String.class);
    //          System.out.println(">>> " + result);
    //        } else {
    //          System.out.println("명령 요청 실패!");
    //        }
    //      }
    //
    //      if (input.equalsIgnoreCase("quit")) {
    //        break;
    //      }
    //    }
    //
    //    requestAgent.close();
    Prompt.close();
  }
}











