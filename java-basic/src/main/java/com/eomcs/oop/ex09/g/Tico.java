package com.eomcs.oop.ex09.g;

public class Tico extends AbstractCar {
  //  int gas;
  //  int brakeOil;
  //  int engineOil;
  public Tico(int gas, int brakeOil, int engineOil) {
    //super(gas, brakeOil, engineOil);
    this.gas = gas;
    this.brakeOil = brakeOil;
    this.engineOil = engineOil;
  }

  @Override
  public void run() {
    System.out.println("붕붕~~ 잘 달린다!");

  }
}
