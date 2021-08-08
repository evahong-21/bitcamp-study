package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Task;

public class TaskList2 {
  static class Node {
    Node next;
    Task task;
    Node(Task task) {
      this.task = task;
    }
  }
  Node head;
  Node tail;
  int size = 0;

  public void add(Task task) {
    Node node = new Node(task);
    if (head == null) {
      head = tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
    size++;
  }

  public Task[] toArray() {
    Task[] arr = new Task[size];
    Node node = head;
    for (int i=0; i<size; i++) {
      arr[i] = node.task;
      node = node.next;
    }
    return arr;
  }

  public boolean remove(Task task) {
    Node node = head;
    Node prev = null;
    while(node!= null) {
      if (node.task == task) {
        if (node == head) {
          head = node.next;
        } else {
          prev.next = node.next;
        }
        node.next = null;
        if (node == tail) {
          tail = prev;
        }
        size--;
        return true;
      }
      prev = node;
      node = node.next;
    }
    return false;
  }

  public Task findByNo(int no) {
    Node node = head;
    while(node!=null) {
      if (node.task.no == no) {
        return node.task;
      }
      node = node.next;
    }
    return null;
  }


}
