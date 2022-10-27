package CodeReView.Calculator;

public class Presenter {
    private Model model;
    private view view;

    public Presenter(Model model, view view){
        this.model = model;
        this.view = view;
    }

    public void Execute(){
        model.setOperand1(view.getOperand("Operand 1: ", "Invalid operand"));
        model.setOperator(view.getOperator("Operator: ", model.getSupportOperators(), "Invalid operand"));
        model.setOperand2(view.getOperand("Operand 2: ", "Invalid operand"));
        view.showResult(Double.toString(model.Calculate()));
    }
}
