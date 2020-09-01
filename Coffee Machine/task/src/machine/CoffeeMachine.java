package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;


        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String buyOption = scanner.next();
                    switch (buyOption) {
                        case "1":
                            int espressoWater = 250;
                            int espressoMilk = 0;
                            int espressoCoffeeBeans = 16;
                            boolean enoughForEspresso = isEnoughResources(water, milk, beans, cups, espressoWater, espressoMilk, espressoCoffeeBeans);
                            if (enoughForEspresso) {
                                System.out.println("I have enough resources, making you a coffee!");
                                water -= espressoWater;
                                beans -= espressoCoffeeBeans;
                                cups -= 1;
                                money += 4;
                            }
                            break;
                        case "2":
                            int cappuccinoWater = 350;
                            int cappuccinoMilk = 75;
                            int cappuccinoCoffeeBeans = 20;
                            boolean enoughForCappuccino = isEnoughResources(water, milk, beans, cups, cappuccinoWater, cappuccinoMilk, cappuccinoCoffeeBeans);
                            if (enoughForCappuccino) {
                                System.out.println("I have enough resources, making you a coffee!");
                                water -= cappuccinoWater;
                                milk -= cappuccinoMilk;
                                beans -= cappuccinoCoffeeBeans;
                                cups -= 1;
                                money += 7;
                            }
                            break;
                        case "3":
                            int latteWater = 200;
                            int latteMilk = 100;
                            int latteCoffeeBeans = 12;
                            boolean enoughForLatte = isEnoughResources(water, milk, beans, cups, latteWater, latteMilk, latteCoffeeBeans);
                            if (enoughForLatte) {
                                System.out.println("I have enough resources, making you a coffee!");
                                water -= latteWater;
                                milk -= latteMilk;
                                beans -= latteCoffeeBeans;
                                cups -= 1;
                                money += 6;
                            }
                            break;
                        case "back":
                        default:
                            break;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    water += scanner.nextInt();

                    System.out.println("Write how many ml of milk do you want to add:");
                    milk += scanner.nextInt();

                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    beans += scanner.nextInt();

                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    cups += scanner.nextInt();

                    break;
                case "take":
                    money = getMoney(money);
                    break;
                case "remaining":
                    machineStatus(water, milk, beans, cups, money);
                    break;
                case "exit":
                    System.exit(0);
                default:
                    break;
            }
        }


    }

    private static int getMoney(int money) {
        System.out.println("I gave you $" + money);
        money = 0;
        return money;
    }

    private static boolean isEnoughResources(int water, int milk, int coffeeBeans, int disposableCups, int needWater, int needMilk, int needCoffeeBeans) {
        boolean enoughResources = true;
        if (needWater >= water) {
            System.out.println("Sorry, not enough water!");
            enoughResources = false;
        }

        if (needMilk >= milk) {
            System.out.println("Sorry, not enough milk!");
            enoughResources = false;
        }

        if (needCoffeeBeans >= coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            enoughResources = false;
        }

        if (disposableCups <= 1) {
            System.out.println("Sorry, not enough disposable cups!");
            enoughResources = false;
        }
        return enoughResources;
    }

    private static void machineStatus(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println("$" + money + " of money\n");
    }
}
