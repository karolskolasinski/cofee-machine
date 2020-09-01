package machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
//        int amount = scanner.nextInt();
//
//        System.out.println(String.format("For %d cups of of coffee you will need: ", amount));
//        System.out.println(String.format("%d ml of water ", amount * 200));
//        System.out.println(String.format("%d ml of milk ", amount * 50));
//        System.out.println(String.format("%d ml of coffee beans ", amount * 15));

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();

        System.out.println("Write how many ml of coffee beans the coffee machine has:");
        int coffeeBeans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int need = scanner.nextInt();


        List<Integer> coffee = new ArrayList<>();
        coffee.add(water / 200);
        coffee.add(milk / 50);
        coffee.add(coffeeBeans / 15);

        int min = coffee.stream().min(Integer::compareTo).orElse(0);

        if (min < need) {
            System.out.println(String.format("No, I can make only %d cup(s) of coffee", min));
        } else if (min == need) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.println(String.format(
                    "Yes, I can make that amount of coffee (and even %d more than that)",
                    min - need)
            );
        }

    }
}
