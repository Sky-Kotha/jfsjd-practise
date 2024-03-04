package com.example;

enum PizzaSize {
    REGULAR(2), MEDIUM(4), LARGE(6);

    int serving;

    PizzaSize(int serving) {
        this.serving = serving;
    }
};

public class EnumDemo {
    public static void main(String[] args) {
        new PizzaShop().displayItems();
    }
}

/**
 * 
 * 
 */
class PizzaShop {
    void displayItems() {
        System.out.println("Our pizza menu consists of");
        // PizzaSize size=PizzaSize.REGULAR;
        for (PizzaSize size : PizzaSize.values()) {
            System.out.println(size + " serves " + size.serving + " persons");
        }
    }

}
