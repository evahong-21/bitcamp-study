package com.eomcs.pms.web;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.eomcs.pms.dao.MemberDao;
import com.eomcs.pms.domain.Member;

@Controller
public class MemberListController {
  MemberDao memberDao;

  @Autowired
  @GetMapping("/member/list")
  public ModelAndView list() throws Exception {
    // 클라이언트 요청을 처리하는데 필요한 데이터 준비
    Collection<Member> memberList = memberDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("memberList", memberList);
    mv.addObject("pageTitle", "메인화면");
    mv.addObject("contentUrl", "member/MemberList.jsp");
    mv.setViewName("template1");
    return mv;
  }
}







