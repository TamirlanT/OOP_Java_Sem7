package CodeReView.ToDoList;

public class Programm {
    public static void main(String[] args) {
        ToDoList myTasks = new ToDoList("Мои задачи");
        Task task1 = myTasks.addTask("Сделать хоть что то по ООП");
        task1.addItem("Создать калькулятор");
        task1.addItem("Ханнойская башня!?");
        task1.addItem("Волновой алгоритм");
        task1.setPriority(Task.Priority.Middle);
        System.out.println(task1);
        System.out.println("- - - - - - - - - -");
        task1.setState(Task.State.Done);
        System.out.println(task1);
        System.out.println(task1.itemList);
        System.out.println(myTasks.getTasks());
    }
}
