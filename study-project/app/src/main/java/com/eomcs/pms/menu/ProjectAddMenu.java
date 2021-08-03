package com.eomcs.pms.menu;

import com.eomcs.pms.handler.ProjectHandler;

public class ProjectAddMenu extends Menu {
  String title;
  ProjectHandler projectHandler;

  ProjectAddMenu(ProjectHandler projectHandler) {
    super("등록");
    this.projectHandler = projectHandler;
  }

  @Override
  public void execute() {
    projectHandler.add();
  }
}
