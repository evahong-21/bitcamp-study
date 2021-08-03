package com.eomcs.pms.menu;

public class MenuGroup {
  String title;
  int size;

  MenuGroup(String title) {
    //super("메뉴");
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Menu[] childs = new Menu[100];
    MenuGroup menuGroup = new MenuGroup("메뉴");
    //@Override

  }

  @Override



  public Menu add(childs) {
    for (int i=0; i<this.size; i++) {
      if (childs[i].title.equals(title)) {
        return title;
      }
    } return null;
  }

  public void remove(title) {

  }
  public void getMenu(title) {

  }
  public int indexOf(childs) {
    for (int i =0; i<this.size; i++) {
      if (childs[i].title.equals(title)) {
        return i;
      }
    } return -1;
  }

}
