package com.eomcs.pms.handler;

public class ArrayList implements List{

  int size;
  static final int MAX_LENGTH = 5;
  Object[] objs = new Object[MAX_LENGTH];

  @Override
  public void add(Object obj) {
    if (size == objs.length) {
      Object[] arr = new Object[objs.length + (objs.length>>1)];
      for (int i=0; i<size; i++) {
        arr[i] = objs[i];
      }
      objs = arr;
    }
    objs[size++] = obj; 
  }


  @Override
  public Object[] toArray() {
    Object[] arr = new Object[size];
    for (int i=0; i<size; i++) {
      arr[i] = objs[i];
    }
    return arr;
  }

  @Override
  public boolean remove(Object obj) {
    int index = indexOf(obj);
    if (index == -1) {
      return false;
    }
    for (int i = index + 1; i < this.size; i++) {
      this.objs[i - 1] = this.objs[i];
    }
    this.objs[--this.size] = null;
    return true;
  }


  public int indexOf(Object obj) {
    for (int i = 0; i < this.size; i++) {
      if (this.objs[i] == obj) {
        return i;
      }
    }
    return -1;
  }
}
