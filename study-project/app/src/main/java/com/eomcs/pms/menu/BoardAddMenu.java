package com.eomcs.pms.menu;

import com.eomcs.pms.handler.BoardHandler;

public class BoardAddMenu extends Menu {
  String title;
  BoardHandler boardHandler;

  BoardAddMenu(BoardHandler boardHandler) {
    super("등록");
    this.boardHandler = boardHandler;
  }

  @Override
  public void execute() {
    boardHandler.add();
  }
}