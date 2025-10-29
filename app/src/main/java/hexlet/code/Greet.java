package hexlet.code;

import java.util.Scanner;

public class Greet {

    public static String greet() {
        System.out.println("Welcome to the Brain Games!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("May I have your name?");
        String name =  scanner.next();
        System.out.println("Hello, " + name + "!");
        return name;
    }
}
