package src;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Main {

    private final static Logger logger = new Logger();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();


        try {
            int userChoice;
            do {


                logger.warning(String.format("You still have %d free spaces on the list!", (toDoList.freePlanTasks - toDoList.getNumberOfTasks())));

                logger.log("\n\u001b[38;5;15m1 - Show ToDoList\u001b[0m");
                logger.log("\u001b[38;5;15m2 - Create task\u001b[0m");
                logger.log("\u001b[38;5;15m3 - Mark as completed\u001b[0m");
                logger.log("\u001b[38;5;15m4 - Clean as completed\u001b[0m");
                logger.log("\u001b[38;5;15m5 - Edit task\u001b[0m");
                logger.log("\u001b[38;5;15m6 - Delete task\u001b[0m");
                logger.log("\u001b[38;5;15m7 - Show deleted tasks\u001b[0m");
                logger.log("\u001b[38;5;15m8 - Organize alphabetically\u001b[0m");
                logger.log("\u001b[38;5;15m9 - Upgrade ToDoList Plan\u001b[0m");
                logger.log("\u001b[38;5;15m0 - Exit ToDoList\u001b[0m\n");
                logger.log("\u001b[38;5;15mChoose a option: \u001b[0m");

                userChoice = scan.nextInt();

                scan.nextLine();

                switch (userChoice) {

                    case 1:
                        toDoList.printTasksOnMenu();
                        break;
                    case 2:
                        logger.logInsert("Task name:");
                        String taskName = scan.nextLine();
                        logger.logInsert("Description of task:");
                        String taskDescription = scan.nextLine() + " Created in " + LocalDate.now() + " at " + LocalTime.now();
                        logger.logInsert("Task note:");
                        String taskNote = scan.nextLine();
                        List<String> notes = new ArrayList<>();
                        notes.add(taskNote);
                        toDoList.createTask(taskName, taskDescription, notes);
                        break;


                    case 3:
                        logger.log("Tasks");
                        toDoList.printTasks();
                        logger.logInsert("What task you want complete?");
                        int taskChosen = scan.nextInt();
                        toDoList.markAsCompleted(taskChosen);
                        break;
                    case 4:
                        logger.log("You want to clean your complete tasks?\n 1  - Yes\n 2 - No");
                        int choose = scan.nextInt();
                        toDoList.cleanCompletedTasks(choose);
                        break;
                    case 5:
                        toDoList.printTasks();
                        logger.logInsert("What task do you want to update?");
                        int task = scan.nextInt();
                        scan.nextLine();
                        logger.log("New task");
                        logger.logInsert("Name: ");
                        String newTaskName = scan.nextLine();

                        logger.logInsert("Description: ");
                        String newDescription = scan.nextLine() + " Edited in " + LocalDate.now() + " at " + LocalTime.now();

                        toDoList.updateTask(task, newTaskName, newDescription);
                        break;
                    case 6:
                        logger.log("Remove Task");
                        logger.log("------------");
                        toDoList.printTasks();
                        logger.logInsert("Task index:");
                        int taskIndex = scan.nextInt();
                        toDoList.deleteTask(taskIndex);
                        break;
                    case 7:
                        toDoList.printDeletedTasks();

                        break;
                    case 8:
                        toDoList.organizeAlphabetically();
                        break;
                    case 9:
                        toDoList.updateToPremium();

                        break;
                    case 0:
                        System.out.println("\n\u001b[38;5;9mClosing ToDoList program...\u001b[0m");
                        break;
                    default:
                        System.out.println("\n\u001b[38;5;9mInvalid option!\u001b[0m");
                        break;

                }


            } while (userChoice != 0);
        } catch (InputMismatchException e){
            logger.error("Something Wrong.., Closing Program");
        }

    }


}

