package com.eomcs.pms.menu;

import com.eomcs.pms.handler.MemberHandler;

public class MemberListMenu extends Menu {
  String title;
  MemberHandler memberHandler;

  MemberListMenu(MemberHandler memberHandler) {
    super("목록");
    this.memberHandler = memberHandler;
  }

  @Override
  public void execute() {
    memberHandler.list();
  }
}
