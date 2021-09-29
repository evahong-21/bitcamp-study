package com.eomcs.pms.handler;

import java.util.HashMap;
import com.eomcs.pms.domain.Member;
import com.eomcs.request.RequestAgent;
import com.eomcs.util.Prompt;

public class MemberDeleteHandler implements Command {

  RequestAgent requestAgent;
  public MemberDeleteHandler(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[회원 삭제]");
    int no = Prompt.inputInt("번호? ");

    HashMap<String, String> params = new HashMap<>();
    params.put("no", String.valueOf(no));
    requestAgent.request("member.selectOne", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    Member member = requestAgent.getObject(Member.class);


    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 삭제를 취소하였습니다.");
      return;
    }

    requestAgent.request("member.delete", member);
    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      System.out.println("회원삭제 실패!");
      System.out.println(requestAgent.getObject(String.class));
      return;
    }

    System.out.println("회원을 삭제하였습니다.");
  }
}







