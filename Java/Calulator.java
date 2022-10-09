package Java;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calulator {
    public static void main(String[] args) {
        SolveEquation solveEq = new SolveEquation();
        Scanner scan = new Scanner(System.in);
        String[] seperateEquation;
        System.out.println(
                "Hello! Welcome to the best calculator in the world!");
        while (true) { // Infinite loop to only end when the user wants to
            System.out.println(
                    "Please enter an equation below to be solved, or write type 'terminate' to end the session.");
            String equationInput = scan.nextLine(); // user input of the full equation in String form
            equationInput = equationInput.replaceAll("\\s", ""); // get rid of all spaces that may be in String
            seperateEquation = equationInput.split(""); // Split the String into a String[] to analyse each character
            equationInput = equationInput.toLowerCase(); // Change everything to lowercase, this is error handling for
                                                         // if terminate is entered
            if (equationInput.equals("terminate")) { // if user input requests to end session
                System.out.println("You have chosen to end the session. Goodbye!");
                System.exit(0); // end program as user has decided to finish
            }
            if (validArgument(seperateEquation)) {
                System.out.println("Yay! This is a valid entry");
                System.out.println("Your answer is:\n" + equationInput + " = " + solveEq.solve(equationInput) + "\n");
            } else {
                System.out.println("Whoopsies! What you entered is an invalid entry. Try again!");
            }
        }
    }

    /* START ERROR HANDLING */
    // Function to determine if what the user entered is a valid input or not
    public static boolean validArgument(String[] userInput) {
        int amount = 0;
        boolean doubleOperator = false;
        for (int i = 0; i < userInput.length; i++) {
            if (isDigit(userInput[i]) || isOperator(userInput[i])) {
                amount++;
            }
        }
        for (int i = 0; i < userInput.length; i++) {
            if (i < userInput.length - 1) {
                System.out.print(userInput[i] + ", ");
            } else {
                System.out.print(userInput[i] + "\n");

            }
        }
        // Checks for any double operator conditions and changes boolean outcome
        for (int i = 0; i < userInput.length - 1; i++) {
            if (isOperator(userInput[i]) && isOperator(userInput[i + 1])) {
                doubleOperator = true;
            }
        }
        if (amount == userInput.length && !isLast(userInput) && evenBrackets(userInput) && !doubleOperator) {
            return true;
        } else {
            return false;
        }
    }

    // Function is to determine if a character is a digit or not
    public static boolean isDigit(String digit) {
        if (digit.equals("0") || digit.equals("1") || digit.equals("2") || digit.equals("3") || digit.equals("4")
                || digit.equals("5") || digit.equals("6") || digit.equals("7") || digit.equals("8")
                || digit.equals("9")) {
            return true;
        } else {
            return false;
        }
    }

    // Function is to determine if a character is an operator or not
    public static boolean isOperator(String operator) {
        if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")
                || operator.equals("(")
                || operator.equals(")")) {
            return true;
        } else {
            return false;
        }
    }

    // Function is to determine if the last character of the userInput String[] is
    // an operator; if it is, it is an invalid entry
    public static boolean isLast(String[] equation) {
        if (equation[equation.length - 1].equals(")")) {
            return false;
        } else if (isOperator(equation[equation.length - 1])) {
            return true;
        }
        return false;
    }

    // Function to determine if equation is valid by having an even amount of
    // brackets
    public static boolean evenBrackets(String[] bracket) {
        double bracketAmount = 0;
        for (int i = 0; i < bracket.length; i++) {
            if (bracket[i].equals(")") || bracket[i].equals("(")) {
                bracketAmount++;
            }
        }
        if (bracketAmount % 2 == 0) {
            return true;
        }
        return false;
    }

    /* END ERROR HANDLING */
}
