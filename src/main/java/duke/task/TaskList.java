package duke.task;

import duke.util.DukeException;

import java.util.List;
import java.util.ArrayList;

public class TaskList {
    private List<Task> listOfTasks;

    public TaskList() {
        listOfTasks = new ArrayList<>();
    }

    public TaskList(List<Task> tasks) {
        listOfTasks = tasks;
    }

    public void addTask(Task task) {
        listOfTasks.add(task);
        System.out.println("Got it. I've added this task:\n"
                + task + "\n"
                + "Now you have " + getSize()
                + " tasks in the list.");
    }

    public int getSize() {
        return listOfTasks.size();
    }

    public void listDownTask() {
        int size = getSize();
        System.out.println("Here are the tasks in your list:");
        for(int i = 1; i <= size; i++) {
            System.out.println(i +": " + listOfTasks.get(i - 1));
        }
    }

    public void deleteTask(int index) {
        Task removed = getTask(index - 1);
        System.out.println("Noted. I've removed this task:\n" + removed);
        listOfTasks.remove(index - 1);
        System.out.println("Now you have " + getSize() + " tasks in the list");
    }

    public void markTask(int index) {
        Task modTask = listOfTasks.get(index - 1);
        modTask.setIsDone(true);
        System.out.println("Nice! I've marked this task as done:\n" + modTask);
    }

    public void unmarkTask(int index) {
        Task modTask = listOfTasks.get(index - 1);
        modTask.setIsDone(false);
        System.out.println("OK, I've marked this task as not done yet:\n" + modTask);
    }

    public void findTask(String keyword) {
        List<Task> temp = new ArrayList<>();
        for (Task task : listOfTasks) {
            if (task.getDescription().contains(keyword)) {
                temp.add(task);
            }
        }
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < temp.size(); i++) {
            System.out.println((i + 1) + "." + temp.get(i));
        }
    }

    public Task getTask(int index) {
            return listOfTasks.get(index);
    }
}
