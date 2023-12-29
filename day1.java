/* Advent of Code, Day 1: Trebuchet?!
 * Adrien Abbey, Dec. 2023
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class day1 {
    public static void main(String[] args) throws FileNotFoundException {

        // Load the input file for scanning:
        File inputFile = new File("input");
        Scanner inputScanner = new Scanner(inputFile);

        // Start parsing input lines for integers, summing them together:
        long totalSum = 0;
        while (inputScanner.hasNextLine()) {
            // Load a line up:
            String inputString = inputScanner.nextLine();
            System.out.println(" Input string:" + inputString);

            // For part two, replace any instances of words with their digits:
            // TODO: I need to do this differently!  Words CAN overlap!
            String cleanedInput = inputString;
            // https://www.geeksforgeeks.org/matcher-pattern-method-in-java-with-examples/
            Pattern wordPattern = Pattern.compile("(one|two|three|four|five|six|seven|eight|nine|ten)");
            Matcher wordMatcher = wordPattern.matcher(cleanedInput);
            while (wordMatcher.find()) {
                System.out.println(" Number of groups found: " + wordMatcher.groupCount());
                String word = wordMatcher.group(); // https://stackoverflow.com/a/5091147
                // System.out.println(" Word found: " + word);
                switch (word) {
                    case "one":
                        cleanedInput = cleanedInput.replaceFirst("one", "1");
                        break;
                    case "two":
                        cleanedInput = cleanedInput.replaceFirst("two", "2");
                        // System.out.println(" Replacing two with 2.");
                        // System.out.println(cleanedInput);
                        break;
                    case "three":
                        cleanedInput = cleanedInput.replaceFirst("three", "3");
                        break;
                    case "four":
                        cleanedInput = cleanedInput.replaceFirst("four", "4");
                        break;
                    case "five":
                        cleanedInput = cleanedInput.replaceFirst("five", "5");
                        break;
                    case "six":
                        cleanedInput = cleanedInput.replaceFirst("six", "6");
                        break;
                    case "seven":
                        cleanedInput = cleanedInput.replaceFirst("seven", "7");
                        break;
                    case "eight":
                        cleanedInput = cleanedInput.replaceFirst("eight", "8");
                        break;
                    case "nine":
                        cleanedInput = cleanedInput.replaceFirst("nine", "9");
                        // System.out.println(" Replacing nine with 9.");
                        // System.out.println(cleanedInput);
                        break;
                }
            }

            // Grab only integers:
            // https://stackoverflow.com/a/17076047
            // replaceAll uses RegEx, removing any character that isn't a digit.
            cleanedInput = cleanedInput.replaceAll("\\D+", "");
            System.out.println(" Cleaned input: " + cleanedInput);

            // Get the first and last digit (which can be the same digit):
            int firstInt = cleanedInput.charAt(0) - 48;
            // System.out.println(" First integer is: " + firstInt);
            int lastInt = cleanedInput.charAt(cleanedInput.length() - 1) - 48;
            // System.out.println(" Last integer is: " + lastInt);

            // Concatenate the integers together:
            // https://stackoverflow.com/a/13268944
            int lineSum = Integer.valueOf(String.valueOf(firstInt) + String.valueOf(lastInt));
            System.out.println(" Integer value: " + lineSum);
            totalSum += lineSum;
            System.out.println(" Current sum is: " + totalSum);
        }

        System.out.println("The answer for the given input is: " + totalSum);

        inputScanner.close();
    }
}