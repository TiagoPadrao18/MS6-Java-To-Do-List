/*
package src.temp;

import src.Logger;
import src.model.Task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TaskManager {
    private final Scanner scan;
    private final Logger logger;

    public TaskManager() {
        this.scan =
        this.logger = new Logger();
    }

    public Task createTask() {
        try {
            logger.logInsert("Task name:");
            String taskName = scan.nextLine();

            logger.logInsert("Description of task:");
            String taskDescription = scan.nextLine();

            Task newTask = new Task(createUniqueID(), taskName, taskDescription);
            logger.log(String.format("%s is created", newTask.getId()));
            return newTask;
        } catch (Exception e) {
            logger.log("Something wrong..");
            System.out.println("Something wrong..");
        }

        return null;
    }

    public void getList() {
        System.out.println("\n\t\t\u001b[38;5;15mToDoList\u001b[0m");
        System.out.println("\u001b[33;1mYou have  tasks to do!\u001b[0m");
        System.out.println("\u001b[38;5;8m------------------------\u001b[0m");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.print("\n" + i + " " + "src.model.Task:" + tasks.get(i).taskName + " Description: " + tasks.get(i).description);

        }
    }

    public void getRemovedTasks() {
        System.out.println("\n\t\t\u001b[38;5;15mRemoved Tasks\u001b[0m");
        System.out.println("\u001b[38;5;8m------------------------\u001b[0m");
        for (int i = 0; i < removedTasks.size(); i++) {
            System.out.print("\n" + i + " " + "src.model.Task:" + removedTasks.get(i).taskName + " Description: " + removedTasks.get(i).description);

        }
    }


    public void deleteTask(String id) {

        for (int i = 0; i < tasks.size(); i++) {
            System.out.print("\n" + i + " " + "src.model.Task:" + tasks.get(i).getTaskName() + " Description: " + tasks.get(i).getDescription());
        }


    }

    public void markTaskAsCompleted() {
        Scanner scan = new Scanner(System.in);


    }

    private String createUniqueID() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
        return ft.format(dNow);
    }
}

*/
