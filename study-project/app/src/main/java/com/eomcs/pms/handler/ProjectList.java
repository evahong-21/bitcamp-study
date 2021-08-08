package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Project;

public class ProjectList extends ArrayList{

  public Project findByNo(int no) {
    Object[] list = toArray();
    for (Object obj : list) {
      Project project = (Project)obj;
      if (project.no == no) {
        return project;
      }
    }
    return null;
  }

}
