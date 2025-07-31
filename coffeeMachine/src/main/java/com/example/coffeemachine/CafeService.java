package com.example.coffeemachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CafeService {
  private final CoffeeMachine coffeemachine1;
  private final CoffeeMachine coffeemachine2;

  public CafeService( CoffeeMachine espressoMachine) {
    this.coffeemachine1 = espressoMachine;
    this.coffeemachine2 = espressoMachine;
  }

  public void startCoffee() {
    // it is used to cheeck the singleton scope
    System.out.println(this.coffeemachine1 == this.coffeemachine2);
    this.coffeemachine1.makeCoffee();
  }
}
