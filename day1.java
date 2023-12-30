/* Advent of Code, Day 1: Trebuchet?!
 * Adrien Abbey, Dec. 2023
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class day1 {
    public static void main(String[] args) throws FileNotFoundException {

        // Load the input file for scanning:
        File inputFile = new File("input");
        Scanner inputScanner = new Scanner(inputFile);

        // Track the total sum:
        long totalSum = 0;

        // Start parsing input lines for integers, summing them together:
        while (inputScanner.hasNextLine()) {
            // Load a line up:
            String inputString = inputScanner.nextLine();
            // System.out.println(" Input string: " + inputString);

            // Create a string to contain the found numbers:
            ArrayList<Integer> foundIntegers = new ArrayList<Integer>();

            // Go through the input string, parsing any numbers found:
            for (int i = 0; i < inputString.length(); i++) {
                if (parseNumber(inputString.substring(i)) > 0) {
                    // System.out.println(" Adding a new number: " +
                    // parseNumber(inputString.substring(i)));
                    foundIntegers.add(parseNumber(inputString.substring(i)));
                }
            }

            // System.out.println(" Found numbers are: " + foundIntegers);

            // Get the first and last digit (which can be the same digit):
            int firstInt = foundIntegers.get(0);
            // System.out.println(" First integer is: " + firstInt);
            int lastInt = foundIntegers.get(foundIntegers.size() - 1);
            // System.out.println(" Last integer is: " + lastInt);

            // Concatenate the integers together:
            // https://stackoverflow.com/a/13268944
            String stringSum = firstInt + "" + lastInt;
            int lineSum = Integer.parseInt(stringSum);
            // System.out.println(" Integer value: " + lineSum);
            totalSum += lineSum;
            // System.out.println(" Current sum is: " + totalSum);
        }

        System.out.println("The answer for the given input is: " + totalSum);

        inputScanner.close();
    }

    static int parseNumber(String inputString) {
        // Given any string, if that string starts with an integer or a word
        // of an integer, return that integer value. If none is found, return
        // -1.

        // If the first character in the string is a digit:
        // https://stackoverflow.com/a/20735611
        if (Character.isDigit(inputString.charAt(0))) {
            // System.out.println(" - Substring is: " + inputString);
            // System.out.println(" - Number found is: " + inputString.charAt(0));
            return inputString.charAt(0) - 48;
        }

        // Create an array of Strings to compare with:
        String[] numberNames = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        // Check for the given number names:
        for (int i = 1; i < 10; i++) {
            if (inputString.startsWith(numberNames[i - 1])) {
                // System.out.println(" - Substring is: " + inputString);
                // System.out.println(" - Number found is: " + i);
                return i;
            }
        }

        // If no valid integer was found, return -1:
        return -1;
    }
}