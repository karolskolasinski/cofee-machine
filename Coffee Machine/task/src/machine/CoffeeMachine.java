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

        int espressoWater = 250;
        int espressoMilk = 0;
        int espressoBeans = 16;

        int cappuccinoWater = 350;
        int cappuccinoMilk = 75;
        int cappuccinoBeans = 20;

        int latteWater = 200;
        int latteMilk = 100;
        int latteBeans = 12;

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            switch (scanner.next()) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    switch (scanner.next()) {
                        case "1":
                            if (isEnoughResources(water, milk, beans, cups, espressoWater, espressoMilk, espressoBeans)) {
                                water -= espressoWater;
                                beans -= espressoBeans;
                                cups -= 1;
                                money += 4;
                            }
                            break;
                        case "2":
                            if (isEnoughResources(water, milk, beans, cups, cappuccinoWater, cappuccinoMilk, cappuccinoBeans)) {
                                water -= cappuccinoWater;
                                milk -= cappuccinoMilk;
                                beans -= cappuccinoBeans;
                                cups -= 1;
                                money += 7;
                            }
                            break;
                        case "3":
                            if (isEnoughResources(water, milk, beans, cups, latteWater, latteMilk, latteBeans)) {
                                water -= latteWater;
                                milk -= latteMilk;
                                beans -= latteBeans;
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
                    System.out.println("I gave you $" + money);
                    money = 0;
                    break;
                case "remaining":
                    System.out.println(String.format(
                            "The coffee machine has:\n" +
                                    "%d of water\n" +
                                    "%d of milk\n" +
                                    "%d of coffee beans\n" +
                                    "%d of disposable cups\n" +
                                    "$%d of money\n",
                            water, milk, beans, cups, money
                    ));
                    break;
                case "exit":
                    System.exit(0);
                default:
                    break;
            }
        }

    }

    private static boolean isEnoughResources(int water, int milk, int coffeeBeans, int disposableCups, int needWater, int needMilk, int needCoffeeBeans) {
        if (disposableCups <= 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }

        if (needWater >= water) {
            System.out.println("Sorry, not enough water!");
            return false;
        }

        if (needMilk >= milk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }

        if (needCoffeeBeans >= coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }

        System.out.println("I have enough resources, making you a coffee!");
        return true;
    }

}
