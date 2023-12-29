/* Advent of Code, Day 1: Trebuchet?!
 * Adrien Abbey, Dec. 2023
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class day1 {
    public static void main(String[] args) throws FileNotFoundException {

        // Load the input file for scanning:
        File inputFile = new File("input");
        Scanner inputScanner = new Scanner(inputFile);

        // Start parsing input lines for integers, summing them together:
        int totalSum = 0;
        while (inputScanner.hasNextLine()) {
            // Load a line up:
            String inputString = inputScanner.nextLine();

            // Grab only integers:
            // https://stackoverflow.com/a/17076047
            // replaceAll uses RegEx, removing any character that isn't a digit.
            String cleanedInput = inputString.replaceAll("\\D+", "");

            // Get the first and last digit (which can be the same digit):
            int firstInt = cleanedInput.charAt(0);
            int lastInt = cleanedInput.charAt(cleanedInput.length() - 1);

            // Concatenate the integers together:
            // https://stackoverflow.com/a/13268944
            int lineSum = Integer.valueOf(String.valueOf(firstInt) + String.valueOf(lastInt));
            totalSum += lineSum;
        }

        System.out.println("The answer of the given input is: " + totalSum);

        inputScanner.close();
    }
}