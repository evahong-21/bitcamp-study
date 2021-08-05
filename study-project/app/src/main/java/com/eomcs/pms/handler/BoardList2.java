package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Board;

public class BoardList2 extends ArrayList2{

  public Object findByNo(int no) {
    Object[] arr = toArray();
    Node node = head;
    int i = 0;
    while(node!=null) {
      Board board = (Board) arr[i++];
      if (board.no == no) {
        return board;
      }
    }
    return null;
  }
  /* Object[] list = toArray();
   * for (Object obj : list) {
   * Board board = (Board) obj;
   * if (board.no == no) {
   * return board;
   * 
   * 
   */
}








