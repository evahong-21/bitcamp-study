package com.eomcs.pms.menu;

import com.eomcs.pms.handler.ProjectHandler;

public class ProjectDetailMenu extends Menu {
  String title;
  ProjectHandler projectHandler;

  ProjectDetailMenu(ProjectHandler projectHandler) {
    super("상세보기");
    this.projectHandler = projectHandler;
  }

  @Override
  public void execute() {
    projectHandler.detail();
  }
}
