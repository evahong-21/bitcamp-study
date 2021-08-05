package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Member;

public class MemberList2 extends ArrayList2{

  public Member findByNo(int no) {
    Node node = head;
    Object[] arr = toArray();
    int i=0;
    while(node!=null) {
      Member member = (Member) arr[i++];
      if (member.no == no) {
        return member;
      }
      node = node.next;
    }
    return null;
  }

  public boolean exist(String name) {
    Object[] arr = toArray();
    Node node = head;
    int i = 0;
    while(node!=null) {
      Member member = (Member) arr[i++];
      if(member.name.equals(name)) {
        return true;
      }
      node = node.next;
    }
    return false;
  }
}








