package CodeReView.Calculator;

import java.util.Set;

public interface view {
    public double getOperand(String message, String errorMessage);
    public String getOperator(String message, Set<String> trueOperators, String errorMessage);

    public void viewMessage(String message);

    public void showResult(String result);

}
