package src;

import java.util.Scanner;

public class Main {

    private final static Logger logger = new Logger();
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        boolean premiumPlan = false;

        int userChoice;

        do {
            logger.log(String.format("You still have %d free spaces on the list!", (10 - toDoList.getNumberOfTasks())));

            System.out.println("\n\u001b[38;5;15m1 - Show ToDoList\u001b[0m");
            System.out.println("\u001b[38;5;15m2 - Create task\u001b[0m");
            System.out.println("\u001b[38;5;15m3 - Mark as completed\u001b[0m");
            System.out.println("\u001b[38;5;15m4 - Clean as completed\u001b[0m");
            System.out.println("\u001b[38;5;15m5 - Edit task\u001b[0m");
            System.out.println("\u001b[38;5;15m6 - Delete task\u001b[0m");
            System.out.println("\u001b[38;5;15m7 - Show deleted tasks\u001b[0m");
            System.out.println("\u001b[38;5;15m8 - Organize alphabetically\u001b[0m");
            System.out.println("\u001b[38;5;15m9 - Upgrade ToDoList Plan\u001b[0m");
            System.out.println("\u001b[38;5;15m0 - Exit ToDoList\u001b[0m\n");
            System.out.print("\u001b[38;5;15mChoose a option: \u001b[0m");

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
                    String taskDescription = scan.nextLine();
                    toDoList.createTask(taskName, taskDescription);
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
                    //editTask(toDoList);
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
                    //organizeAlphabetically(toDoList);
                    break;
                case 9:
//                    premiumPlan = upgradeToDoListPlan(toDoList, premiumPlan);
//                    if (premiumPlan) {
//                        String[] tempToDoList = new String[30];
//
//                        for (int i = 0; i < toDoList.length; i++) {
//                            if (i < tempToDoList.length) {
//                                tempToDoList[i] = toDoList[i];
//                            } else {
//                                break;
//                            }
//                        }
//
//                        toDoList = tempToDoList;
//                    }

                    break;
                case 0:
                    System.out.println("\n\u001b[38;5;9mClosing ToDoList program...\u001b[0m");
                    break;
                default:
                    System.out.println("\n\u001b[38;5;9mInvalid option!\u001b[0m");
                    break;
            }

        } while (userChoice != 0);
    }
}
