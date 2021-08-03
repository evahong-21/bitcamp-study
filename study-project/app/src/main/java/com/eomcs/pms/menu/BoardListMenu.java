package com.eomcs.pms.menu;

import com.eomcs.pms.handler.BoardHandler;

public class BoardListMenu extends Menu {
  String title;
  BoardHandler boardHandler;

  BoardListMenu(BoardHandler boardHandler) {
    super("목록");
    this.boardHandler = boardHandler;
  }

  @Override
  public void execute() {
    boardHandler.list();
  }
}
