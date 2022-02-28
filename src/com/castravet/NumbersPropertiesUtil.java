package com.castravet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NumbersPropertiesUtil {
    public static int numSquareSum(long n)
    {
        int squareSum = 0;
        while (n!= 0)
        {
            squareSum += (n % 10) * (n % 10);
            n /= 10;
        }
        return squareSum;
    }

//  A happy number is a natural number in a given number base that eventually
//  reaches 1 when iterated over the perfect digital invariant function for.
//  Those numbers that do not end in 1 are -unhappy numbers.
    static boolean isHappyNumber(long n)
    {
        long slow, fast;
        //  initialize slow and fast by n
        slow = fast = n;
        do
        {
            //  move slow number
            // by one iteration
            slow = numSquareSum(slow);

            //  move fast number
            // by two iteration
            fast = numSquareSum(numSquareSum(fast));

        }
        while (slow != fast);

        //  if both number meet at 1,
        // then return true
        return (slow == 1);
    }

//  Jumping Numbers are the number whose adjacent digits differ by one only.
//  Some jumping numbers are 4565, 98, 7. All single-digit numbers are considered
//  as jumping numbers.
    public static boolean isJumpingNumber(long num){
        if (num<10L){
            return true;
        }
        String strNum = String.valueOf(num);
        for (int i=1;i<strNum.length();i++){
            int currentDigit=Integer.parseInt(strNum.substring(i,i+1));
            int previousDigit = Integer.parseInt(strNum.substring(i-1,i));
            if (Math.abs(currentDigit-previousDigit)!=1){
                return false;
            }
        }
        return true;
    }

//  Gapful Number is a number N of at least 3 digits such that it is divisible
//  by the concatenation of it's first and last digit. Few Gapful Numbers
//  are: 100, 105, 108, 110
    public static boolean isGapfulNumber(long num) {
        String numToCheck = "";
        if (num < 100) {
            return false;
        }
        int totalDigits = (int) Math.log10(num);
        long firstDigit = (long) (num / Math.pow(10, totalDigits));
        numToCheck += firstDigit;
        numToCheck += num % 10;

        if (num % Long.parseLong(numToCheck) == 0) {
            return true;
        }
        return false;
    }

//  A number is called a sunny number if the number next to the given number is
//  a perfect square. In other words, a number N will be a sunny number if N+1
//  is a perfect square.
    public static boolean isSunnyNumber(long num){
        double sqrt=Math.sqrt(num+1L);
        return ((sqrt - Math.floor(sqrt)) == 0);
    }

    public static boolean isSquareNumber(long num){
        double sqrt=Math.sqrt(num);
        return ((sqrt - Math.floor(sqrt)) == 0);
    }

//  A spy number is a number where the sum of its digits equals the product of its
//  digits. For example, 1124 is a spy number, the sum of its digits is 1+1+2+4=8 and
//  the product of its digits is 1*1*2*4=8.
    public static boolean isSpyNumber(long num) {
        ArrayList<Long> nums = Arrays.stream(String.valueOf(num).split(""))
                .map(Long::parseLong).collect(Collectors.toCollection(ArrayList::new));
        long product = nums.stream().reduce(1L, (a, b) -> a * b);
        long sum = nums.stream().mapToLong(Long::valueOf).sum();

        if (product == sum) {
            return true;
        }
        return false;
    }

//  A palindromic number (also known as a numeral palindrome or a numeric palindrome)
//  is a number (such as 16461) that remains the same when its digits are reversed.
    public static boolean isPalindromicNumber(long num) {
        String strNum = String.valueOf(num);
        for (int i = 0; i < strNum.length(); i++) {
            if (strNum.substring(i, i + 1).equals(String.valueOf(num % 10))) {
                num = num / 10;
            } else {
                return false;
            }

        }
        return true;
    }

//  A Duck number is a positive number which has zeroes present in it,
//  For example 3210, 8050896, 70709 are all Duck numbers. Please note that a
//  numbers with only leading 0s is not considered as Duck Number. For example,
//  numbers like 035 or 0012 are not considered as Duck Numbers. A number like
//  01203 is considered as Duck because there is a non-leading 0 present in it.
    public static boolean isDuckNumber(long num) {
        String strNum = String.valueOf(num);
        if (strNum.length() > 1) {
            if (strNum.substring(1).contains("0")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEvenNumber(long num) {
        if (num % 2 == 0) {
            return true;
        }
        return false;
    }

//  Buzz number is another special number in Java that ends with
//  digit 7 or divisible by 7.
    public static boolean isBuzzNumber(long num) {
        if (endsWith7(num) || isDivisibleBy7(num)) {
            return true;
        }
        return false;
    }

    public static boolean endsWith7(long num) {
        long lastDigit = num % 10;
        if (lastDigit == 7) {
            return true;
        }
        return false;
    }

    public static boolean isDivisibleBy7(long num) {
        long lastDigit = num % 10;
        long numWithoutLastDigit = num / 10;
        long result = numWithoutLastDigit - (lastDigit * 2);
        if (result % 7 == 0) {
            return true;
        }
        return false;
    }
}
