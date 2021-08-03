package com.eomcs.pms.menu;

import com.eomcs.pms.handler.MemberHandler;

public class MemberUpdateMenu extends Menu {
  String title;
  MemberHandler memberHandler;

  MemberUpdateMenu(MemberHandler memberHandler) {
    super("변경");
    this.memberHandler = memberHandler;
  }

  @Override
  public void execute() {
    memberHandler.update();
  }
}
