package com.eomcs.pms.handler;

public abstract class AbstractList implements List{
  int size;

  @Override
  public int size() {
    return this.size;
  }
}
