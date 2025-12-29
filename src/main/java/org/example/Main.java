package org.example;

public class Main {

    // Palindrom sayıyı kontrol eden metod
    public static boolean isPalindrome(int number) {
        int originalNumber = Math.abs(number);
        int reversed = 0;
        int temp = originalNumber;

        while (temp > 0) {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        return originalNumber == reversed;
    }

    // Mükemmel sayı kontrolü yapan metod
    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }

    // Sayıyı kelimelere çeviren metod
    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }
        if (number == 0) {
            return "Zero";
        }

        String[] words = {"Zero", "One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine"};

        StringBuilder result = new StringBuilder();
        int temp = number;
        int reversed = 0;
        int count = 0;

        // Sayıyı tersine çevir
        while (temp > 0) {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
            count++;
        }

        // Ters çevrilmiş sayıyı kelimelere dönüştür
        for (int i = 0; i < count; i++) {
            int digit = reversed % 10;
            result.append(words[digit]);
            if (i < count - 1) {
                result.append(" ");
            }
            reversed /= 10;
        }

        return result.toString();
    }

    // Main metodu
    public static void main(String[] args) {

        System.out.println(isPalindrome(-1221)); // true
        System.out.println(isPalindrome(707));   // true
        System.out.println(isPalindrome(11212)); // false


        System.out.println(isPerfectNumber(6));   // true
        System.out.println(isPerfectNumber(28));  // true
        System.out.println(isPerfectNumber(5));   // false
        System.out.println(isPerfectNumber(-1));  // false


        System.out.println(numberToWords(123));   // One Two Three
        System.out.println(numberToWords(1010));  // One Zero One Zero
        System.out.println(numberToWords(-12));   // Invalid Value
    }
}

