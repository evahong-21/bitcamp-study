package com.eomcs.pms.menu;

import com.eomcs.pms.handler.MemberHandler;

public class MemberDeleteMenu extends Menu {
  String title;
  MemberHandler memberHandler;

  MemberDeleteMenu(MemberHandler memberHandler) {
    super("삭제");
    this.memberHandler = memberHandler;
  }

  @Override
  public void execute() {
    memberHandler.delete();
  }
}
