import java.util.Scanner;

public class Console_calcul {
    public static String calc(String input) {
        Scanner scanner = new Scanner(input);
        double num1 = scanner.nextDouble();
        char operator = scanner.next().charAt(0);
        double num2 = scanner.nextDouble();
        double result = 0.0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0.0) {
                    return "Ошибка: деление на ноль невозможно";
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                return "Неверный оператор";
        }

        return String.format("%.2f", result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = calc(input);
        System.out.println(result);
    }

}
