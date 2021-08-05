package com.eomcs.pms.handler;

public class ArrayList2 {
  static class Node {
    Object item;
    Node next;

    public Node(Object item) {
      this.item = item;
    }
  }
  Node head;
  Node tail;

  //  static final int MAX_LENGTH = 5;
  //  Board[] boards = new Board[MAX_LENGTH];
  int size = 0;

  public void add(Object item) {
    Node node = new Node(item);

    if (head == null) {
      tail = head = node;
    } else {
      // 기존에 tail이 가리키는 마지막 노드의 next 변수에 새 노드 주소를 저장한다.
      tail.next = node;

      // 새로 만든 노드를 마지막 노드로 설정한다. 
      tail = node;
    }

    size++;
  }
  public Object[] toArray() {
    Object[] arr = new Object[this.size]; // 배열에 저장된 값을 담을 정도의 크기를 가진 새 배열을 만든다.
    Node node = head;

    int i=0;
    while(node!=null) {
      arr[i++] = node.item;
      node = node.next;
    }
    return arr;
  }

  public boolean remove(Object item) {
    Node node = head;
    Node prev = null;

    while (node != null) {
      if (node.item == item) {
        if (node == head) {
          head = node.next;
        } else {
          prev.next = node.next; // 이전 노드를 다음 노드와 연결한다.
        }

        node.next = null; // 다음 노드와의 연결을 끊는다.

        if (node == tail) { // 삭제할 현재 노드가 마지막 노드라면
          tail = prev; // 이전 노드를 마지막 노드로 설정한다.
        }
        size--;
        return true; // 이미 삭제가 되었으므로 리턴
      }

      // 현재 노드가 아니라면 while문 돌아감.
      prev = node; // 현재 노드의 주소를 prev 변수에 저장하고,
      node = node.next; // node 변수에는 다음 노드의 주소를 저장한다.
    }
    return false;
  }
}
