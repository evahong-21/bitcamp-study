package com.eomcs.pms.table;

import com.eomcs.pms.domain.Member;
import com.eomcs.server.Request;
import com.eomcs.server.Response;

// 역할
// - 게시글 데이터를 저장하고 조회하는 일을 한다.

public class MemberTable extends DataTable<Member> {

  public MemberTable() {
    // JSON 파일에서 데이터를 로딩한다.
    super("member.json");
  }

  public void execute(Request request, Response response) throws Exception {
    switch(request.getCommand()) {
      case "member.insert" : insert(request, response); break;
      case "member.selectList" : selectList(request, response); break;
      case "member.selectOne" : selectOne(request, response); break;
      case "member.update" : update(request, response); break;
      case "member.delete" : delete(request, response); break;

      default :
        response.setStatus(Response.FAIL);
        response.setValue("해당 명령을 지원하지 않습니다.");
    }

  }
  private void insert(Request request, Response response) throws Exception {
    Member member = request.getObject(Member.class);
    list.add(member);

    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }

  private void selectOne(Request request, Response response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    Member m = findByNo(no);

    if (m != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(m);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 명령을 지원하지 않습니다.");
    }
  }

  private void update(Request request, Response response) throws Exception {
    Member member = request.getObject(Member.class);

    int index = indexOf(member.getNo());
    if (index==-1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당번호의 회원을 찾을 수 없습니다.");
      return;
    } else {
      list.set(index, member);

      response.setStatus(Response.SUCCESS);
    }
  }

  private void delete(Request request, Response response) throws Exception {
    Member member = request.getObject(Member.class);
    int index = indexOf(member.getNo());
    if (index==-1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당번호의 회원을 찾을 수 없습니다.");
      return;
    } else {
      list.remove(index);

      response.setStatus(Response.SUCCESS);
    }
  }

  private Member findByNo(int no) {
    for (Member m : list) {
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
