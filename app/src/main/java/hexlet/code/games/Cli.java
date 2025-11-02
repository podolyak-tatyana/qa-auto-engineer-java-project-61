package hexlet.code.games;

import java.util.Scanner;

public class Cli {

    public static void hello(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("May I have your name?");
        String name =  scanner.next();
        System.out.println("Hello, " + name + "!");
        scanner.close();
    }
}
