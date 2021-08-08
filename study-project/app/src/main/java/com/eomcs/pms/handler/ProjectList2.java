package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Project;

public class ProjectList2 {

  static class Node {
    Node next;
    Project project;

    Node(Project project) {
      this.project = project;
    }
  }
  int size = 0;
  Node head;
  Node tail;

  public void add(Project project) {
    Node node = new Node(project);
    if (head == null) {
      head = tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
    size++;
  }

  public Project[] toArray() {
    Project[] arr = new Project[size];
    Node node = head;
    for (int i=0; i<size; i++) {
      arr[i] = node.project;
      node = node.next;
    }
    return arr;
  }

  public boolean remove(Project project) {
    Node node = head;
    Node prev = null;

    while(node!=null) {
      if (node.project == project) {
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

  public Project findByNo(int no) {
    Node node = head;
    while(node!=null) {
      if (node.project.no == no) {
        return node.project;
      }
      node = node.next;
    }
    return null;
  }


}
