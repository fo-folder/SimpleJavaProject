import java.util.*;
import com.farida.operations.*;
import com.farida.operations.Summarize; // added especially for import chacking

public class Calculator {
    // filename change suggested
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Which operation you'd like to process:");
        System.out.println("1 - Sum");
        System.out.println("2 - Subtraction");
        System.out.println("3 - Multiply");
        System.out.println("4 - Divide");
        int operationType = scan.nextInt();
        Operations operations;
        List<? extends Operations> list = new ArrayList<>();
        List<? super Operations> list2 = new ArrayList<>();
        Class<Operations> clazz = Operations.class;
        VarKeep operation = OperationsFactory.create(operationType);
        System.out.println("Input first number:");
        operation.addLeft(scan.nextInt());
        System.out.println("Input second number:");
        operation.addRight(scan.nextInt());
        System.out.println("The result is: " + operation.perform());
        System.out.println("operation instance of Operation: " + (operation instanceof Summarize));
    }

    public static Operations dummyMethod(Operations input) { // method signature with an interface
        Operations aaa;
        return null;
    }

// method for test
    /* private static void invoke(String text) {
        System.out.println(text); **/
}