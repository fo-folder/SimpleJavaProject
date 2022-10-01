import java.awt.*;
import java.util.*;
import com.farida.operations.*;

public class Numbers {
    // filename change suggested
    
    public static void main(String[] args) {
        /* System.out.print("Hello");
        invoke(", World"); **/
        Scanner scan = new Scanner(System.in);
        System.out.println("Which operation you'd like to process:");
        System.out.println("1 - Sum");
        System.out.println("2 - Differ");
        System.out.println("3 - Multiply");
        System.out.println("4 - Divide");
        int operationType = scan.nextInt();
        Operation operation = createOperation(operationType);
        System.out.println("Input first number:");
        operation.addLeft(scan.nextInt());
        System.out.println("Input second number:");
        operation.addRight(scan.nextInt());
        System.out.println("The result is: " + operation.perform());
    }

    public static Operation createOperation(int operationType) {
        if (operationType == 1) {
            return new Sum();
        }
        else if (operationType == 2) {
            return new Differ();
        }
        else if (operationType == 3) {
            return new Multipl();
        }
        else if (operationType == 4) {
            return new Division();
        }
        else {
            throw new RuntimeException("Unsupported operation type!");
        }
    }
// method for test
    /* private static void invoke(String text) {
        System.out.println(text); **/
}
// inner class for test

    // class definition for variable

    // Classname.getclass or class

    // method signature

    // Instance of
    //+ comment change suggestion

