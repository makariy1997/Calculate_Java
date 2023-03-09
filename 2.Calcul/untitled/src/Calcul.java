
    import java.util.Scanner;

    public class Calcul {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.print("Введите первое число: ");
            double firstNumber = input.nextDouble();

            System.out.print("Введите второе число: ");
            double secondNumber = input.nextDouble();

            System.out.print("Выберите операцию (+, -, *, /): ");
            char operator = input.next().charAt(0);

            double result;

            switch(operator) {
                case '+':
                    result = firstNumber + secondNumber;
                    break;

                case '-':
                    result = firstNumber - secondNumber;
                    break;

                case '*':
                    result = firstNumber * secondNumber;
                    break;

                case '/':
                    result = firstNumber / secondNumber;
                    break;

                default:
                    System.out.println("Неправильный оператор!");
                    return;
            }

            System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + result);
        }
    }
