package com.castravet;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
/*Supported requests:
        - enter a natural number to know its properties;
        - enter two natural numbers to obtain the properties of the list:
        * the first parameter represents a starting number;
        * the second parameter shows how many consecutive numbers are to be printed;
        - two natural numbers and properties to search for;
        - a property preceded by minus must not be present in numbers;
        - separate the parameters with one space;
        - enter 0 to exit. */
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
/*
1) Welcome users;
2) Display the instructions;
3) Ask for a request;
4) If a user enters an empty request, print the instructions;
5) If the user enters zero, terminate the program;
6) If numbers are not natural, print the error message;
7) If an incorrect property is specified, print the error message and the list of available properties;
8) For one number, print the properties of the number;
9) For two numbers, print the properties of all numbers in the list;
10) For two numbers and two properties, print the list of numbers that contain the specified properties;
11) If a property is preceded by a minus, this property should not be present in a number;
12) If the user specifies mutually exclusive properties, abort the request and warn the user.
13) Once the request is processed, continue execution from step 3.
*/
public class Main extends DataProcessing{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        printWelcomeUser();

        boolean pendingRequest = true;
        while (pendingRequest) {
            System.out.print("Enter a request: ");
            String num = scanner.nextLine().toUpperCase(Locale.ROOT);
            System.out.println();

            if (num.isEmpty()) {
                continue;
            }
            ArrayList<String> paramsList = stringToObjectList(num);

            if (!isFirstNumNatural(paramsList)) {
                printFirstParameterError();
            } else if (!isSecondNumNaturalIfPresent(paramsList)) {
                printSecondParameterError();
            } else if (!areAllPropertiesValidIfPresent(paramsList)) {
                printKeyParametersError(paramsList);
            } else if(findMutuallyExclusiveNumbers(paramsList)!=null){
                String exclusiveNumbers = findMutuallyExclusiveNumbers(paramsList);
                printErrorForMutuallyExclusiveParams(exclusiveNumbers);
            } else if (getFirstParam(paramsList) == 0) {
                System.out.println("Goodbye!");
                pendingRequest = false;
            } else {
                if (paramsList.size() == 1) {
                    printExplanationForOneNumber(getFirstParam(paramsList));
                } else if (paramsList.size() == 2) {
                    printExplanationForTwoNumbers(getFirstParam(paramsList), getSecondParam(paramsList));
                } else {
                    printExplanationForThreeAndMoreNumbers(paramsList);
                }
            }
        }
    }
}
