package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Task;

public class TaskList2 extends ArrayList2{

  public Task findByNo(int no) {
    Object[] arr = toArray();
    Node node = head;
    int i=0;
    while(node!=null) {
      Task task = (Task) arr[i++];
      if (task.no == no) {
        return task;
      }
      node = node.next;
    }
    return null;
  }

}








