package com.example.coffeemachine;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Qualifier("latteMachine")
@Scope("prototype")
public class LatteMachine implements CoffeeMachine {
    public LatteMachine() {
        System.out.println("LatteMachine instance created");
    }

    @Override
    public void makeCoffee() {
        System.out.println("its latte");
    }
}
