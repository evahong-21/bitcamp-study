package com.eomcs.pms.menu;

import com.eomcs.pms.handler.ProjectHandler;

public class ProjectDeleteMenu extends Menu {
  String title;
  ProjectHandler projectHandler;

  ProjectDeleteMenu(ProjectHandler projectHandler) {
    super("삭제");
    this.projectHandler = projectHandler;
  }

  @Override
  public void execute() {
    projectHandler.delete();
  }
}
