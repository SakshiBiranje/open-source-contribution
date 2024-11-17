import java.util.Scanner;

// Custom exception class extending Exception
class MyException extends Exception {
    MyException(String message) {
        super(message);
    }
}
// MathOperation class performing arithmetic operations with custom exceptions
public class MathOperation 
{
    // Method for addition with custom exception handling
    public static int add(int a, int b) throws MyException {
        int result = a + b;
        if (result > 1000) {
            throw new MyException("TooLongAddition: Addition result exceeds 1000.");
        }
        return result;
    }

    // Method for subtraction with custom exception handling
    public static int subtract(int a, int b) throws MyException {
        int result = a - b;
        if (result < 0) {
            throw new MyException("NegativeAnswer: Subtraction result is negative.");
        }
        return result;
    }

    // Method for multiplication with custom exception handling
    public static int multiply(int a, int b) throws MyException {
        int result = a * b;
        if (result > 5000) {
            throw new MyException("TooLongMultiplication: Multiplication result exceeds 5000.");
        }
        return result;
    }

    // Method for division
    public static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Asking for user input
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Menu for choosing an operation
            System.out.println("Choose an operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");

            int choice = scanner.nextInt();

            // Perform the selected operation
            switch (choice) {
                case 1:
                    int additionResult = add(num1, num2);
                    System.out.println("Addition Result: " + additionResult);
                    break;

                case 2:
                    int subtractionResult = subtract(num1, num2);
                    System.out.println("Subtraction Result: " + subtractionResult);
                    break;

                case 3:
                    int multiplicationResult = multiply(num1, num2);
                    System.out.println("Multiplication Result: " + multiplicationResult);
                    break;

                case 4:
                    int divisionResult = divide(num1, num2);
                    System.out.println("Division Result: " + divisionResult);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } catch (MyException | ArithmeticException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
