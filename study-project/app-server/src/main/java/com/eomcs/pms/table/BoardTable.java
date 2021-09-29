package com.eomcs.pms.table;

import com.eomcs.pms.domain.Board;
import com.eomcs.server.Request;
import com.eomcs.server.Response;

// 역할
// - 게시글 데이터를 저장하고 조회하는 일을 한다.

public class BoardTable extends DataTable<Board>{

  public BoardTable() {
    // JSON 파일에서 데이터를 로딩한다.
    super("board.json");
  }

  public void execute(Request request, Response response) throws Exception {
    switch(request.getCommand()) {
      case "board.insert" : insert(request, response); break;
      case "board.selectList" : selectList(request, response); break;
      case "board.selectOne" : selectOne(request, response); break;
      case "board.update" : update(request, response); break;
      //      case "board.search" : search(request, response); break;
      case "board.delete" : delete(request, response); break;

      default :
        response.setStatus(Response.FAIL);
        response.setValue("해당 명령을 지원하지 않습니다.");
    }

  }
  private void insert(Request request, Response response) throws Exception {
    Board board = request.getObject(Board.class);
    list.add(board);

    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }

  private void selectOne(Request request, Response response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    Board b = findByNo(no);

    if (b != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(b);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 명령을 지원하지 않습니다.");
    }
  }

  private void update(Request request, Response response) throws Exception {
    Board board = request.getObject(Board.class);

    int index = indexOf(board.getNo());
    if (index==-1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당번호의 게시글을 찾을 수 없습니다.");
      return;
    } else {
      list.set(index, board);

      response.setStatus(Response.SUCCESS);
    }
  }

  private void delete(Request request, Response response) throws Exception {
    Board board = request.getObject(Board.class);
    int index = indexOf(board.getNo());
    if (index==-1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당번호의 게시글을 찾을 수 없습니다.");
      return;
    } else {
      list.remove(index);

      response.setStatus(Response.SUCCESS);
    }
  }

  private Board findByNo(int no) {
    for (Board m : list) {
      if (m.getNo() == no) {
        return m;
      }
    }
    return null;
  }

  private int indexOf(int memberNo) {
    for (int i = 0; i<list.size() ; i++) {
      if (list.get(i).getNo() == memberNo) {
        return i;
      }
    }
    return -1;
  }
}
