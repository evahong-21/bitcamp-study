package com.eomcs.pms.menu;

import com.eomcs.pms.handler.TaskHandler;

public class TaskListMenu extends Menu {
  String title;
  TaskHandler taskHandler;

  TaskListMenu(TaskHandler taskHandler) {
    super("목록");
    this.taskHandler = taskHandler;
  }

  @Override
  public void execute() {
    taskHandler.list();
  }
}