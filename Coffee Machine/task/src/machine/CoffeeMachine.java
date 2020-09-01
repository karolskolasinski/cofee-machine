package machine;

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






    }
}
