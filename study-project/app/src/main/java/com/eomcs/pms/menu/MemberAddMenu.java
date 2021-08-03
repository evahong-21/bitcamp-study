package com.eomcs.pms.menu;

import com.eomcs.pms.handler.MemberHandler;

public class MemberAddMenu extends Menu {
  String title;
  MemberHandler memberHandler;

  MemberAddMenu(MemberHandler memberHandler) {
    super("등록");
    this.memberHandler = memberHandler;
  }

  @Override
  public void execute() {
    memberHandler.add();
  }
}
