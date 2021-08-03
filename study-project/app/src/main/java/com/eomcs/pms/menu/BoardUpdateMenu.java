package com.eomcs.pms.menu;

import com.eomcs.pms.handler.BoardHandler;

public class BoardUpdateMenu extends Menu {
  String title;
  BoardHandler boardHandler;

  BoardUpdateMenu(BoardHandler boardHandler) {
    super("변경");
    this.boardHandler = boardHandler;
  }

  @Override
  public void execute() {
    boardHandler.update();
  }
}
