package com.eomcs.pms.menu;

import com.eomcs.util.Prompt;

public class MenuGroup extends Menu{

  Menu[] childs = new Menu[100];
  int size;
  //boolean disablePrevMenu; 
  String prevMenuTitle = "이전 메뉴";
  MenuGroup(String title) {
    super(title);
  }
  //
  //  MenuGroup(String title, boolean disablePrevMenu) {
  //    super(title);
  //    this.disablePrevMenu = disablePrevMenu;
  //  }

  public void setPrevMenuTitle(String prevMenuTitle) {
    this.prevMenuTitle = prevMenuTitle;
  }

  public void add(Menu child) {
    if (this.size == this.childs.length) {
      return ;
    } this.childs[this.size++] = child;
  } 

  public Menu remove(Menu child) {
    int index = indexOf(child);
    if (index!=-1) {
      for (int i=index+1; i<this.size; i++) {
        childs[i-1] = childs[i];
      } childs[--this.size] = null;
      return child;
    } return null;
  }
  public Menu getMenu(String title) {
    for (int i=0; i<this.size; i++) {
      if (childs[i].title.equals(title)) {
        return childs[i];
      }
    } return null;
  }
  public int indexOf(Menu child) {
    for (int i =0; i<this.size; i++) {
      if (this.childs[i] == child) {
        return i;
      }
    } return -1;
  }

  @Override
  public void execute() {
    // 실질적으로 실행되는 곳은 이곳. 
    // while문이 한번 실행될때 현재 자기가 있는 디렉토리리(객체주소)를 나타냄.
    while(true) {
      System.out.printf("\n[%s]\n", title );
      for (int i=0; i<this.size; i++) {
        System.out.printf("%d. %s\n", i+1, this.childs[i].title);
      }
      System.out.printf("0. %s\n", this.prevMenuTitle); 

      int menuNo = Prompt.inputInt("선택> ");
      System.out.println();
      if (menuNo==0 && this.prevMenuTitle=="종료") {
        System.out.println("시스템 종료");
        return;
      }
      if (menuNo<0 || menuNo > this.size) {
        System.out.println("유효하지 않는 입력값입니다.\n");
        continue;
      } 

      if (menuNo==0 && this.prevMenuTitle.equals("이전 메뉴")) {
        //this.childs[menuNo].execute();
        continue;
      } 

      this.childs[--menuNo].execute();


    }
  }
}