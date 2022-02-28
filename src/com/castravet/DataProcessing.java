package com.castravet;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DataProcessing extends NumbersPropertiesUtil{

    public static List<String> mutuallyExclusiveProperties = List.of(
            NumberProperties.getProperty(NumberProperties.EVEN),
            NumberProperties.getProperty(NumberProperties.ODD),
            NumberProperties.getProperty(NumberProperties.NEGATIVE_EVEN),
            NumberProperties.getProperty(NumberProperties.NEGATIVE_ODD),
            NumberProperties.getProperty(NumberProperties.DUCK),
            NumberProperties.getProperty(NumberProperties.SPY),
            NumberProperties.getProperty(NumberProperties.NEGATIVE_DUCK),
            NumberProperties.getProperty(NumberProperties.NEGATIVE_SPY),
            NumberProperties.getProperty(NumberProperties.SUNNY),
            NumberProperties.getProperty(NumberProperties.SQUARE),
            NumberProperties.getProperty(NumberProperties.NEGATIVE_SUNNY),
            NumberProperties.getProperty(NumberProperties.NEGATIVE_SQUARE),
            NumberProperties.getProperty(NumberProperties.HAPPY),
            NumberProperties.getProperty(NumberProperties.SAD),
            NumberProperties.getProperty(NumberProperties.NEGATIVE_HAPPY),
            NumberProperties.getProperty(NumberProperties.NEGATIVE_SAD),
            NumberProperties.getProperty(NumberProperties.EVEN),
            NumberProperties.getProperty(NumberProperties.NEGATIVE_EVEN),
            NumberProperties.getProperty(NumberProperties.ODD),
            NumberProperties.getProperty(NumberProperties.NEGATIVE_ODD),
            NumberProperties.getProperty(NumberProperties.DUCK),
            NumberProperties.getProperty(NumberProperties.NEGATIVE_DUCK),
            NumberProperties.getProperty(NumberProperties.SPY),
            NumberProperties.getProperty(NumberProperties.NEGATIVE_SPY),
            NumberProperties.getProperty(NumberProperties.SUNNY),
            NumberProperties.getProperty(NumberProperties.NEGATIVE_SUNNY),
            NumberProperties.getProperty(NumberProperties.SQUARE),
            NumberProperties.getProperty(NumberProperties.NEGATIVE_SQUARE),
            NumberProperties.getProperty(NumberProperties.HAPPY),
            NumberProperties.getProperty(NumberProperties.NEGATIVE_HAPPY),
            NumberProperties.getProperty(NumberProperties.SAD),
            NumberProperties.getProperty(NumberProperties.NEGATIVE_SAD)
    );

    static String findMutuallyExclusiveNumbers(ArrayList<String> listOfParams) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i=0;i<mutuallyExclusiveProperties.size();i++) {
            if (listOfParams.contains(mutuallyExclusiveProperties.get(i))){
                stringBuilder.append(mutuallyExclusiveProperties.get(i)+", ");
                count++;
                if (count==2){
                    return stringBuilder.toString().trim().substring(0,stringBuilder.length()-2);
                }
                if (i%2!=0){
                    count=0;
                }
            }else{
                count=0;
                stringBuilder.setLength(0);
            }
        }
        return null;
    }

    public static Long getFirstParam(ArrayList<String> params) {
        String param = params.get(0);
        return Long.parseLong(param);
    }

    public static Long getSecondParam(ArrayList<String> params) {
        String param = params.get(1);
        return Long.parseLong(param);
    }

    public static ArrayList<String> getAllPositiveKeyParams(ArrayList<String> params) {
        ArrayList<String> paramsToReturn=new ArrayList<>();
        for (int i=2;i<params.size();i++){
            if (params.get(i).charAt(0)!='-') {
                paramsToReturn.add(params.get(i));
            }
        }
        return paramsToReturn;
    }

    public static ArrayList<String> getAllNegativeParamsFromList(ArrayList<String> listOfParams){
        ArrayList<String> listOfNegativeParams = new ArrayList<>();
        for (int i=2;i<listOfParams.size();i++){
            if (listOfParams.get(i).charAt(0)=='-'){
                listOfNegativeParams.add(listOfParams.get(i));
            }
        }
        return listOfNegativeParams;
    }

    public static void removeParamsThatArePresentAsNegative(ArrayList<String> positiveKeyParams,
                                                            ArrayList<String> listOfNegativeParams){
        for (int i =0;i<listOfNegativeParams.size();i++){
            positiveKeyParams.remove(listOfNegativeParams.get(i).substring(1,listOfNegativeParams.size()));
        }
    }

    public static boolean isFirstNumNatural(ArrayList<String> listOfParameters) {
        String param = listOfParameters.get(0);
        if (isContainingLetters(param)) {
            return false;
        }

        if (Long.parseLong(param) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean isSecondNumNaturalIfPresent(ArrayList<String> listOfParameters) {
        if (listOfParameters.size() >= 2) {
            String param = listOfParameters.get(1);
            if (isContainingLetters(param)) {
                return false;
            }
            if (Long.parseLong(param) >= 0) {
                return true;
            } else {
                return false;
            }

        }
        return true;
    }

    public static boolean areAllPropertiesValidIfPresent(ArrayList<String> listOfParameters) {
        if (listOfParameters.size() >= 3) {
            for (int i=2;i<listOfParameters.size();i++){
                String param = listOfParameters.get(i);
                if (!isPropertyNameValid(param)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isPropertyNameValid(String property){
        NumberProperties propertyToCheck = NumberProperties.isPropertyPresent(property);
        return propertyToCheck != null;
    }

    public static boolean isContainingLetters(String str) {
        if (str.matches(".*[a-z].*")) {
            return true;
        }
        return false;
    }

    public static ArrayList<String> stringToObjectList(String str) {
        String[] arrOfParams = str.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String param : arrOfParams) {
            list.add(param);
        }
        return list;
    }


    public static void printExplanationForThreeAndMoreNumbers(ArrayList<String> listOfParams) {
        int countNumToPrint = 0;
        Long numToIncrement = getFirstParam(listOfParams);
        Long n = getSecondParam(listOfParams);

        ArrayList<String> positiveKeyParams = getAllPositiveKeyParams(listOfParams);
        ArrayList<String> listOfNegativeParams = getAllNegativeParamsFromList(listOfParams);
        removeParamsThatArePresentAsNegative(positiveKeyParams,listOfNegativeParams);

        while (countNumToPrint < n) {
            String rowToPrint = populateStringForPrinting(numToIncrement);

            int countStrParams = 0;
            if (listOfNegativeParams.size()>0){
                for (String param: listOfNegativeParams){
                    if (rowToPrint.contains(param.toLowerCase(Locale.ROOT).substring(1))){
                        countStrParams--;
                    }
                }
            }
            if (positiveKeyParams.size()>0) {
                for (String param : positiveKeyParams) {
                    if (rowToPrint.contains(param.toLowerCase(Locale.ROOT))) {
                        countStrParams++;
                    }
                }
            }

            if (countStrParams==positiveKeyParams.size()){
                System.out.println(rowToPrint);
                countNumToPrint++;
            }
            numToIncrement++;
        }
    }

    public static String populateStringForPrinting(Long num) {
        String dataToPrint = num + " is";
        if (isEvenNumber(num)) {
            dataToPrint += " even,";
        } else {
            dataToPrint += " odd,";
        }
        if (isBuzzNumber(num)) {
            dataToPrint += " buzz,";
        }
        if (isDuckNumber(num)) {
            dataToPrint += " duck,";
        }
        if (isPalindromicNumber(num)) {
            dataToPrint += " palindromic,";
        }
        if (isGapfulNumber(num)) {
            dataToPrint += " gapful,";
        }
        if (isSpyNumber(num)) {
            dataToPrint += " spy,";
        }
        if (isSunnyNumber(num)) {
            dataToPrint += " sunny,";
        }
        if (isSquareNumber(num)) {
            dataToPrint += " square,";
        }
        if (isJumpingNumber(num)) {
            dataToPrint += " jumping,";
        }
        if (isHappyNumber(num)) {
            dataToPrint += " happy,";
        }
        if (!isHappyNumber(num)) {
            dataToPrint += " sad,";
        }
        return dataToPrint.substring(0,dataToPrint.length()-1);
    }

    public static void printExplanationForTwoNumbers(Long num, Long n) {
        long numToIncrement = num;
        for (int i = 1; i <= n; i++) {
            String dataToPrint = populateStringForPrinting(numToIncrement);
            System.out.println(dataToPrint.substring(0, dataToPrint.length() - 1));
            numToIncrement++;
        }
    }

    public static void printExplanationForOneNumber(long num) {

        System.out.println("Properties of " + num);
        System.out.println("    even: " + isEvenNumber(num));
        System.out.println("    odd: " + !isEvenNumber(num));
        System.out.println("    buzz: " + isBuzzNumber(num));
        System.out.println("    duck: " + isDuckNumber(num));
        System.out.println("    palindromic: " + isPalindromicNumber(num));
        System.out.println("    gapful: " + isGapfulNumber(num));
        System.out.println("    spy: " + isSpyNumber(num));
        System.out.println("    square: " + isSquareNumber(num));
        System.out.println("    sunny: "+ isSunnyNumber(num));
        System.out.println("    jumping: "+ isJumpingNumber(num));
        System.out.println("    happy: "+ isHappyNumber(num));
        System.out.println("    sad: "+ !isHappyNumber(num));
    }

    public static void printWelcomeUser() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and properties to search for;");
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");

    }

    public static void printFirstParameterError() {
        System.out.println("The first parameter should be a natural number or zero.");
    }

    public static void printSecondParameterError() {
        System.out.println("The second parameter should be a natural number.");
    }

    public static void printKeyParametersError(ArrayList<String> listOfParams) {
        StringBuilder stringBuilder = new StringBuilder();
        int countWrongWords =0;
        for (int i=2;i<listOfParams.size();i++){
            if(!isPropertyNameValid(listOfParams.get(i))){
                stringBuilder.append(" " + listOfParams.get(i)+",");
                countWrongWords++;
            }
        }
        String strToPrint = stringBuilder.toString().trim().substring(0,stringBuilder.length()-2);
        if (countWrongWords>1){
            System.out.println("The properties [" + strToPrint + "] are wrong.");

        }else{
            System.out.println("The property [" + strToPrint + "] is wrong.");
        }
        System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
    }

    public static void printErrorForMutuallyExclusiveParams(String params){
        System.out.println("The request contains mutually exclusive properties: ["+params +"]");
        System.out.println("There are no numbers with these properties.");

    }
}
