package com.example.coffeemachine;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;

@Component

@Scope("singleton")
public class EspressoMachine implements CoffeeMachine {
    public EspressoMachine() {
        System.out.println("EspressoMachine instance created");
    }

    @PostConstruct
    public void init() {
        System.out.println("Bean initialized");
    }

    @Override
    public void makeCoffee() {
        System.out.println("its Espresso");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean destroyed");
    }
}
