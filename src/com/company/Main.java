package com.company;

import java.util.*;
import static java.lang.Math.abs;


class Main {

    private static int[] nums = new int[]{0,1,2,3,4,5,6,7,8,9};
    public static HashMap<Integer, Character> conversionDictionary = new HashMap<Integer, Character>();
    // Add any helper functions you may need here
    private static char convert(char ch, int factor) {
        int ascii = (int)ch + factor;
        System.out.println(ascii);
        return (char)ascii;
    }


    private static Character convertAlphabet(char c, int factor) {
        int mapping = conversionDictionary.get((int)c);
        int tempFactor = factor;
        if(abs(mapping + factor) > 23) {
            while(abs(tempFactor) > 23) {
                tempFactor = abs(tempFactor - 23);
            }
            if(mapping + tempFactor > 23) return Character.valueOf(conversionDictionary.get(abs(mapping + factor - 23)));
        }

        else return (char) (mapping + factor);

        return ']';
    }

    private static Character convertNums(char c, int factor) {
        return 'g';
    }

    String rotationalCipher(String input, int rotationFactor) {
        String output = "";
        for(char c: input.toCharArray()) {
            if ((int)c >= 97 && (int)c <= 122) {
                convertAlphabet(c, rotationFactor);
            }
            else if((int)c >= 97 && (int)c <= 122) output = output + convertNums(c,rotationFactor);
            else output = output + c;
        }

        return output;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        int index = 0;
        for(char alphabet = 'a'; alphabet <='z'; alphabet++ ) {
            conversionDictionary.put(index,Character.valueOf(alphabet));
            index++;
        }
        new Main().run();
    }
}
