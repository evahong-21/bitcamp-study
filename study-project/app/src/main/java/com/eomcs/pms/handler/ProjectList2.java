package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Project;

public class ProjectList2 extends ArrayList2{


  public Project findByNo(int no) {
    Object[] arr = toArray();
    Node node = head;
    int i=0;
    while(node!=null) {
      Project project = (Project) arr[i++];
      if (project.no == no) {
        return project;
      }
      node = node.next;
    }
    return null;
  }

}








