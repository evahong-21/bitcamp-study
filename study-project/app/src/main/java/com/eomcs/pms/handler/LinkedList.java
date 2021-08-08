package com.eomcs.pms.handler;

public class LinkedList implements List{

  public class Node {
    Node next;
    Object obj;

    public Node(Object obj) {
      this.obj = obj;
    }
  }
  int size;
  Node head;
  Node tail;

  @Override
  public void add(Object obj) {
    Node node = new Node(obj);

    if (head == null) {
      head = tail = node;
    } else {
      tail.next = node;
      tail = node;
    } size++;
  }


  @Override
  public Object[] toArray() {
    Object[] arr = new Object[size];
    Node node = head;
    for (int i=0; i<size; i++) {
      arr[i] = node.obj;
      node = node.next;
    }
    return arr;
  }

  @Override
  public boolean remove(Object obj) {

    Node node = head;
    Node prev = null;
    while(node!=null) {
      if (node.obj == obj) {
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


}
