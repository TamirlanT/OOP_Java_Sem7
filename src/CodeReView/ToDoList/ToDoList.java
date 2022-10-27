package CodeReView.ToDoList;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    String name;
    protected List<Task> tasks = new ArrayList<>();

    public ToDoList(String name){
        this.name = name;
    }

    public Task addTask(String name) {
        Task task = new Task(name);
        tasks.add(task);
        return task;
    }

    public StringBuilder getTasks() {
        StringBuilder sb = new StringBuilder();
        for (Task task: tasks) {
            sb.append(task);
        }
        return sb;
    }
}
