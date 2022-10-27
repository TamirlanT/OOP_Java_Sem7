package CodeReView.Calculator;
import java.util.Scanner;
import java.util.Set;

public class ConsoleView implements view{
    @Override
    public double getOperand(String message, String errorMessage){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print(message);
            if(scanner.hasNextDouble())
                return scanner.nextDouble();
            else{
                scanner.next();
                System.out.println(errorMessage);
            }
        }
    }

    @Override
    public String getOperator(String message, Set<String> trueOperators, String errorMessage){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(message);
            String input = scanner.next();
            if(trueOperators.contains(input))
                return input;
            else
                System.out.println(errorMessage);
        }
    }

    @Override
    public void viewMessage(String message){
        System.out.println(message);
    }

    @Override
    public void showResult(String result){
        System.out.println(result);
    }
}
