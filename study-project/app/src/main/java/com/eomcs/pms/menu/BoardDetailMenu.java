package com.eomcs.pms.menu;

import com.eomcs.pms.handler.BoardHandler;

public class BoardDetailMenu extends Menu {
  String title;
  BoardHandler boardHandler;

  BoardDetailMenu(BoardHandler boardHandler) {
    super("상세보기");
    this.boardHandler = boardHandler;
  }

  @Override
  public void execute() {
    boardHandler.detail();
  }
}
