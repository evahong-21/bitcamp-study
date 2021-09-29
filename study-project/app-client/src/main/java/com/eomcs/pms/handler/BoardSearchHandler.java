package com.eomcs.pms.handler;

import java.util.Collection;
import com.eomcs.pms.domain.Board;
import com.eomcs.request.RequestAgent;
import com.eomcs.util.Prompt;

public class BoardSearchHandler implements Command {

  RequestAgent requestAgent;
  public BoardSearchHandler(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[게시글 검색]");

    String input = Prompt.inputString("검색어? ");

    requestAgent.request("board.selectList", null);
    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      System.out.println("게시글 검색 실패!");
      return;
    }

    Collection<Board> boardList = requestAgent.getObjects(Board.class);

    for (Board board : boardList) {
      if (!board.getTitle().contains(input) &&
          !board.getContent().contains(input) &&
          !board.getWriter().getName().contains(input)) {
        continue;
      }
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          board.getNo(), 
          board.getTitle(), 
          board.getWriter().getName(),
          board.getRegisteredDate(),
          board.getViewCount(), 
          board.getLike());
    }

  }
}







