package com.eomcs.pms.menu;

import com.eomcs.util.Prompt;

public class MenuGroup extends Menu{

  Menu[] childs = new Menu[100];
  int size=0;
  boolean prevDisable;

  public MenuGroup(String title) {
    super(title);
  }

  public MenuGroup(String title, boolean prevDisable) {
    super(title);
    this.prevDisable = prevDisable;
  }

  public void add(Menu child) {
    // 배열에서 추가함.
    if (this.size == this.childs.length) {
      return;
    }
    childs[this.size++] = child;
  }

  public Menu remove(Menu child) {
    // 배열에서 삭제되는것
    // 여기서 indexOf 사용.
    int index = indexOf(child);
    if (index==-1) {
      System.out.println("존재하지 않습니다.");
      return null;
    }
    for (int i=index+1; i<this.size; i++) {
      childs[i-1] = childs[i];
    }
    childs[--this.size] = null;
    return child;
  }

  public Menu getMenu(String title) {
    for (int i=0; i<this.size; i++) {
      if (childs[i].title.equals(title)) {
        return childs[i];
      }
    } return null;
  }

  public int indexOf(Menu child) {
    for (int i=0; i<this.size ; i++) {
      if (childs[i]==child) {
        return i;
      }
    } return -1;
    //remove할때 사용.
  }
  @Override
  public void execute() {
    //상속하는 메서드보다 접근제어가 더 넓어야함. (public)
    while (true) {
      System.out.printf("\n[%s]\n", this.title);
      for (int i=0; i<size; i++) {
        System.out.printf("%d. %s\n", i+1, childs[i].title);
      }
      if (!prevDisable) {
        System.out.printf("0. 이전메뉴\n");
      } else {
        System.out.println("0. 종료\n");
      }
      // prevDisable = true : 종료 > 아예 끝나야함.
      int menuNo = Prompt.inputInt("선택> ");

      if (menuNo<0 || size<menuNo) {
        System.out.println("입력값이 범위를 벗어났습니다.");
        continue;
      } 
      if (menuNo==0) {
        return;
      }
      System.out.println();
      childs[--menuNo].execute();

    }


  }
}
