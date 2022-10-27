package CodeReView.Calculator;

public class main {
    public static void main(String[]args){
        (new Presenter(new Model(), new ConsoleView())).Execute();
    }
}
