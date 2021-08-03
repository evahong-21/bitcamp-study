package com.eomcs.pms.menu;

import com.eomcs.pms.handler.ProjectHandler;

public class ProjectListMenu extends Menu {
  String title;
  ProjectHandler projectHandler;

  ProjectListMenu(ProjectHandler projectHandler) {
    super("목록");
    this.projectHandler = projectHandler;
  }

  @Override
  public void execute() {
    projectHandler.list();
  }
}
