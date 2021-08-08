package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Board;

public class BoardList2 {

  public class Node {
    Node next;
    Board board;

    public Node(Board board) {
      this.board = board;
    }
  }
  int size = 0;
  Node head;
  Node tail;

  public void add(Board board) {
    Node node = new Node(board);

    if (head == null) {
      head = tail = node;
    } else {
      tail.next = node;
      tail = node;
    } size++;
  }


  public Board[] toArray() {
    Board[] arr = new Board[size];
    Node node = head;
    for (int i=0; i<size; i++) {
      arr[i] = node.board;
      node = node.next;
    }
    return arr;
  }

  public boolean remove(Board board) {

    Node node = head;
    Node prev = null;
    while(node!=null) {
      if (node.board == board) {
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

  public Board findByNo(int no) {
    Node node = head;
    while(node!=null) {
      if (node.board.no == no) {
        return node.board;
      }
      node = node.next;
    }
    return null;
  }


}
