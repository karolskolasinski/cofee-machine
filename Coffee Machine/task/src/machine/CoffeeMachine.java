package machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        System.out.println("Write how many cups of coffee you will need:");
//        int amount = scanner.nextInt();
//
//        System.out.println(String.format("For %d cups of of coffee you will need: ", amount));
//        System.out.println(String.format("%d ml of water ", amount * 200));
//        System.out.println(String.format("%d ml of milk ", amount * 50));
//        System.out.println(String.format("%d ml of coffee beans ", amount * 15));

//        System.out.println("Write how many ml of water the coffee machine has:");
//        int water = scanner.nextInt();
//
//        System.out.println("Write how many ml of milk the coffee machine has:");
//        int milk = scanner.nextInt();
//
//        System.out.println("Write how many ml of coffee beans the coffee machine has:");
//        int coffeeBeans = scanner.nextInt();
//
//        System.out.println("Write how many cups of coffee you will need:");
//        int need = scanner.nextInt();
//
//
//        List<Integer> coffee = new ArrayList<>();
//        coffee.add(water / 200);
//        coffee.add(milk / 50);
//        coffee.add(coffeeBeans / 15);
//
//        int min = coffee.stream().min(Integer::compareTo).orElse(0);
//
//        if (min < need) {
//            System.out.println(String.format("No, I can make only %d cup(s) of coffee", min));
//        } else if (min == need) {
//            System.out.println("Yes, I can make that amount of coffee");
//        } else {
//            System.out.println(String.format(
//                    "Yes, I can make that amount of coffee (and even %d more than that)",
//                    min - need)
//            );
//        }

        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int disposableCups = 9;
        int moeny = 550;

        machineStatus(water, milk, coffeeBeans, disposableCups, moeny);

        System.out.println("Write action (buy, fill, take):");
        String action = scanner.next();
        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                int buyOption = scanner.nextInt();
                switch (buyOption) {
                    case 1:
                        water -= 250;
                        coffeeBeans -= 16;
                        moeny += 4;
                        disposableCups -= 1;
                        break;
                    case 2:
                        water -= 350;
                        milk -= 75;
                        coffeeBeans -= 20;
                        disposableCups -= 1;
                        moeny += 7;
                        break;
                    case 3:
                        water -= 200;
                        milk -= 100;
                        coffeeBeans -= 12;
                        disposableCups -= 1;
                        moeny += 6;
                }
                machineStatus(water, milk, coffeeBeans, disposableCups, moeny);
                break;
            case "fill":
                System.out.println("Write how many ml of water do you want to add:");
                water += scanner.nextInt();

                System.out.println("Write how many ml of milk do you want to add:");
                milk += scanner.nextInt();

                System.out.println("Write how many grams of coffee beans do you want to add:");
                coffeeBeans += scanner.nextInt();

                System.out.println("Write how many disposable cups of coffee do you want to add:");
                disposableCups += scanner.nextInt();

                machineStatus(water, milk, coffeeBeans, disposableCups, moeny);
                break;
            case "take":
                System.out.println("I gave you $" + moeny);
                moeny = 0;

                machineStatus(water, milk, coffeeBeans, disposableCups, moeny);
                break;
            default:
                break;
        }


    }

    private static void machineStatus(int water, int milk, int coffeeBeans, int disposableCups, int moeny) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(moeny + " of money");
    }
}
