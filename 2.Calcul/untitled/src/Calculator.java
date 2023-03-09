import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {
    private static final Map<String, Integer> romanNumerals = new HashMap<>();

    static {
        romanNumerals.put("I", 1);
        romanNumerals.put("II", 2);
        romanNumerals.put("III", 3);
        romanNumerals.put("IV", 4);
        romanNumerals.put("V", 5);
        romanNumerals.put("VI", 6);
        romanNumerals.put("VII", 7);
        romanNumerals.put("VIII", 8);
        romanNumerals.put("IX", 9);
        romanNumerals.put("X", 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter an expression to evaluate or 'exit' to quit:");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                String result = calculate(input);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static String calculate(String input) throws Exception {
        String[] operands = input.split(" ");

        if (operands.length != 3) {
            throw new Exception("Invalid input format");
        }

        String operator = operands[1];
        int num1, num2, result;
        boolean isRoman = false;

        try {
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[2]);
        } catch (NumberFormatException e) {
            num1 = romanToArabic(operands[0]);
            num2 = romanToArabic(operands[2]);
            isRoman = true;
        }

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new Exception("Invalid operator");
        }

        if (isRoman) {
            return arabicToRoman(result);
        } else {
            return String.valueOf(result);
        }
    }

    private static int romanToArabic(String romanNumeral) throws Exception {
        Integer result = romanNumerals.get(romanNumeral.toUpperCase());

        if (result == null) {
            throw new Exception("Invalid roman numeral");
        }

        return result;
    }

    private static String arabicToRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Value must be between 1 and 3999");
        }

        StringBuilder sb = new StringBuilder();

        while (number >= 1000) {
            sb.append("M");
            number -= 1000;
        }

        if (number >= 900) {
            sb.append("CM");
            number -= 900;
        }

        while (number >= 500) {
            sb.append("D");
            number -= 500;
        }

        if (number >= 400) {
            sb.append("CD");
            number -= 400;
        }

        while (number >= 100) {
            sb.append("");
            number -= 100;
        }
        if (number >= 90) {
            sb.append("XC");
            number -= 90;
        }

        while (number >= 50) {
            sb.append("L");
            number -= 50;
        }

        if (number >= 40) {
            sb.append("XL");
            number -= 40;
        }

        while (number >= 10) {
            sb.append("X");
            number -= 10;
        }

        if (number >= 9) {
            sb.append("IX");
            number -= 9;
        }

        while (number >= 5) {
            sb.append("V");
            number -= 5;
        }

        if (number >= 4) {
            sb.append("IV");
            number -= 4;
        }

        while (number >= 1) {
            sb.append("I");
            number -= 1;
        }

        return sb.toString();
    }
}
