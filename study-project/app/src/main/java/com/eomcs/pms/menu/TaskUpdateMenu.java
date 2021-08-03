package com.eomcs.pms.menu;

import com.eomcs.pms.handler.TaskHandler;

public class TaskUpdateMenu extends Menu {
  String title;
  TaskHandler taskHandler;

  TaskUpdateMenu(TaskHandler taskHandler) {
    super("변경");
    this.taskHandler = taskHandler;
  }

  @Override
  public void execute() {
    taskHandler.update();
  }
}
