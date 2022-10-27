package CodeReView.ToDoList;

import java.util.ArrayList;
import java.util.List;


public class Task {
    private static int id;
    String name;
    List<String> items = new ArrayList<>();
    Priority priority;
    State state = State.InWork;


    String string = "";

    private int i = 1;
    public String itemList = "\nItems:\n";

    static {
        Task.id = 0;
    }

    enum Priority {Low, Middle, High}


    enum State {Done, InWork, Cancelled}

    public Task(String name) {
        this.name = name;
        string += String.format("Id: %d\nName: %s\n", ++id, name);
    }

    public void addItem(String item) {
        items.add(item);
        itemList += String.format("  %d. %s\n", i++, item);
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
        string += String.format("Priority: %s\n", priority);
    }

    public void setState(State state) {
        this.state = state;
    }
    @Override
    public String toString() {
        return string + ("State: " + state);
    }
}

