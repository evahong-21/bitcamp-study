package com.eomcs.pms.menu;

import com.eomcs.pms.handler.BoardHandler;

public class BoardDeleteMenu extends Menu {
  String title;
  BoardHandler boardHandler;

  BoardDeleteMenu(BoardHandler boardHandler) {
    super("삭제");
    this.boardHandler = boardHandler;
  }

  @Override
  public void execute() {
    boardHandler.delete();
  }
}
