package com.eomcs.pms.menu;

import com.eomcs.pms.handler.ProjectHandler;

public class ProjectUpdateMenu extends Menu {
  String title;
  ProjectHandler projectHandler;

  ProjectUpdateMenu(ProjectHandler projectHandler) {
    super("변경");
    this.projectHandler = projectHandler;
  }

  @Override
  public void execute() {
    projectHandler.update();
  }
}
