package src;

import src.model.Task;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private static final Logger logger = new Logger();
    private final List<Task> tasks;
    private final List<Task> deletedTasks;

    private final List<Task> completedTasks;

    public ToDoList() {
        this.tasks = new ArrayList<>();
        this.deletedTasks = new ArrayList<>();
        this.completedTasks = new ArrayList<>();
    }

    public void createTask(String name, String description) {
        try {
            if(tasks.size()<10) {
                Task newTask = new Task(name, description);
                tasks.add(newTask);
                logger.log(String.format("%s is created", newTask.getId()));
            } else{
              logger.error("Task limit !! Upgrade your task list to premium!");
            }
        } catch (Exception e) {
            logger.error("Something wrong..");
        }
    }


    public void markAsCompleted(int index){
        try {
            int taskIndex = -1;
            for (int i = 0; i < tasks.size(); i++) {
                if (index == i) {
                    taskIndex = i;
                }
            }
            completedTasks.add(tasks.get(taskIndex));
            tasks.remove(taskIndex);
        } catch (IndexOutOfBoundsException e){
            logger.error("Something wrong...");
        }
    }

    public void cleanCompletedTasks(int choose){
        try {
            if (choose == 1) {
                completedTasks.clear();
                logger.log("Cleaned with success!!");
            }
        } catch (Exception e ){
            logger.error("Something wrong bruuuuh!");
        }
    }

    public void deleteTask(int index) {

        try {
            deletedTasks.add(tasks.get(index));
            tasks.remove(index);
        } catch (IndexOutOfBoundsException e) {
            logger.error("error ");
        }
    }

    public void printTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            logger.log(String.format("%d - %s" , i , tasks.get(i)));
        }
    }

    public void printCompleteTasks(){
        for (int i = 0; i <completedTasks.size() ; i++) {
            logger.log(String.format("%d - %s" , i , completedTasks.get(i)));
        }
    }
    public void printTasksOnMenu() {

        int numberOfCompletedTasks = completedTasks.size();
        int notCompletedTasks = tasks.size();

        int totalTasks = numberOfCompletedTasks + notCompletedTasks;
        double percentageTaskComplete = (double) numberOfCompletedTasks / totalTasks * 100;
        if (tasks.size()>0 || completedTasks.size()>0 ) {
            logger.log("Completed Tasks");
            logger.log("Tasks complete: " + percentageTaskComplete + "%");
            printCompleteTasks();
            logger.log("To Do list");
            logger.log("You have " + notCompletedTasks + " tasks to do !");
            printTasks();
        } else {
            logger.error("The list is empty!");
        }
    }

    public void printDeletedTasks(){
        logger.error("Deleted Tasks");
        for (int i = 0; i <deletedTasks.size() ; i++) {
            logger.log(String.format("%d - %s" , i , deletedTasks.get(i)));
        }
    }

    public int getNumberOfTasks() {
        return tasks.size();
    }
}