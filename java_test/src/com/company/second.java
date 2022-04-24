package com.company;
import java.util.Scanner;
public class second {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = "y";
        while (str.equals("y")) {
            int target = (int) (Math.random() * 1000) + 1;
            System.out.println("Target:" + target);
            int max_guess_time = 10;
            System.out.println("You have " + max_guess_time + " times to guess in total");
            System.out.printf("Guess a number ranging from 1 to 1000: ");
            int bottom = 1, top = 1000;
            int guess_time = 1;

            int myGuess = s.nextInt();
            while (myGuess != target) {
                System.out.println("You still have " + (max_guess_time - guess_time) + " times to guess");
                if (myGuess < bottom || myGuess > top) {
                    System.out.printf("Range exceeded! Guess again ");
                } else if (myGuess < target) {
                    System.out.printf("Smaller than the number! Guess again ");
                    bottom = myGuess + 1;
                } else {
                    System.out.printf("Greater than the number! Guess again ");
                    top = myGuess - 1;
                }
                System.out.printf("(%d~%d): ", bottom, top);
                myGuess = s.nextInt();
                guess_time += 1;
                if (guess_time == 10) {
                    System.out.println("It‘s a pity you have failed!");
                    break;
                }
            }
            if (guess_time != 10)
                System.out.printf("Good job! You guessed %d time(s) to get the correct answer.", guess_time);
            System.out.println("Do you want to try again?(y/n)");
            str= s.next();
        }
        System.out.println("Thank you for your participation!");
    }

}
