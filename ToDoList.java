import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ToDoList {
    static TaskManager task = new TaskManager();

    void mainMenu() {

        Scanner scan = new Scanner(System.in);
        boolean premiumPlan = false;
        String[] toDoList;
        ArrayList<String> doneTasks = new ArrayList<>();
        ArrayList<String> deletedTasks = new ArrayList<>();

        if (!premiumPlan) {
            System.out.println("\n\t\t\t\t\u001b[43;1m\u001b[38;5;15mIMPORTANT WARNING\u001b[0m\u001b[38;5;11m\nYou are currently using the Free Plan of ToDoList!\nYou can upgrade to Premium Plan in the upgrade menu!\u001b[0m");
            toDoList = new String[10];
        } else {
            toDoList = new String[30];
        }

        int userChoice = 0;

        do {

            int count = 0;
            for (int i = 0; i < toDoList.length; i++) {
                if (toDoList[i] == null) {
                    count++;
                }
            }

            System.out.println("\n\u001b[38;5;15mYou still have \u001b[38;5;11m" + count + "\u001b[38;5;15m free spaces on the list!\u001b[0m");

//            System.out.println("\n\u001b[38;5;15m " + Arrays.toString(toDoList) + "\u001b[0m");

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
                    task.getList();
                    break;
                case 2:
                   task.createTask();
                    break;
                case 3:
                    markTaskAsCompleted(toDoList, doneTasks);
                    break;
                case 4:
                    removeTaskAsCompleted(doneTasks);
                    break;
                case 5:
                    editTask(toDoList);
                    break;
                case 6:
                    deleteTask(toDoList, deletedTasks);
                    break;
                case 7:
                    viewDeletedTasks(deletedTasks, toDoList);

                    break;
                case 8:
                    organizeAlphabetically(toDoList);
                    break;
                case 9:
                    premiumPlan = upgradeToDoListPlan(toDoList, premiumPlan);
                    if (premiumPlan) {
                        String[] tempToDoList = new String[30];

                        for (int i = 0; i < toDoList.length; i++) {
                            if (i < tempToDoList.length) {
                                tempToDoList[i] = toDoList[i];
                            } else {
                                break;
                            }
                        }

                        toDoList = tempToDoList;
                    }
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





    public static void viewCompletedTasks(ArrayList<String> array){
        for (int i = 0; i < array.size(); i++) {
            System.out.println("\u001b[38;5;7m" + i + ". \u001b[38;5;40m" + array.get(i) + " ✅\u001b[0m");

        }
    }
    public static void showToDoList(String[] toDoList, ArrayList<String> array) {
        int completedTasks = array.size();
        int notCompletedTasks = 0;

        for (String task : toDoList) {
            if (task != null) {
                notCompletedTasks++;

            }
        }

        int totalTasks = completedTasks + notCompletedTasks;
        double percentageTaskComplete = (double) completedTasks / totalTasks * 100;
        if (notCompletedTasks > 0 || array.size() > 0) {
            System.out.println("\n\t\u001b[38;5;15mCompleted Tasks\u001b[0m");
            System.out.println("\u001b[32;1mTasks complete: " + percentageTaskComplete + " %\u001b[0m");
            System.out.println("\u001b[38;5;8m------------------------\u001b[0m");
            viewCompletedTasks(array);
            System.out.println("\u001b[38;5;8m------------------------\u001b[0m");
            System.out.println("\n\t\t\u001b[38;5;15mToDoList\u001b[0m");
            System.out.println("\u001b[33;1mYou have " + notCompletedTasks + " tasks to do!\u001b[0m");
            System.out.println("\u001b[38;5;8m------------------------\u001b[0m");
            for (int i = 0; i < toDoList.length; i++) {
                if (toDoList[i] != null) {

                    System.out.println("\u001b[31;1m" + i + " - " + toDoList[i] + "\u001b[0m");
                }
            }

            System.out.println("\u001b[38;5;8m------------------------\u001b[0m");
        } else{
            System.out.println("The list is empty");
        }
    }

    public static void createTask(String[] toDoList) {
        Scanner scan = new Scanner(System.in);

        System.out.print("\n\u001b[38;5;15mCreate task: \u001b[0m");
        String userNewTask = scan.nextLine().trim() + " || \u001b[32;1mcreated in:\u001b[0m " + LocalDate.now() + "\u001b[32;1m at \u001b[0m " + LocalTime.now();
        System.out.println("Insert a notes");
        String taskNotes = scan.next();

        userNewTask += " " + "\u001b[32;1mNote:\u001b[0m " + taskNotes;

        if (!userNewTask.isEmpty()) {
            boolean added = false;

            for (int i = 0; i < toDoList.length; i++) {
                if (toDoList[i] == null) {
                    toDoList[i] = userNewTask;
                    System.out.println("\n\u001b[38;5;10mThe task '\u001b[38;5;15m" + userNewTask +"\u001b[38;5;10m' was created!\u001b[0m");
                    added = true;
                    break;
                }
            }

            if (!added) {
                System.out.println("\n\n\u001b[38;5;9mThe list is full! You don't have more space.\u001b[0m");
            }
        } else {
            System.out.println("\n\n\u001b[38;5;9mTask name cannot be empty.\u001b[0m");
        }
    }

    public static void markTaskAsCompleted(String[] toDoList, ArrayList<String> array) {
        Scanner scan = new Scanner(System.in);

        int count = 0;
        for (int i = 0; i < toDoList.length; i++) {
            if (toDoList[i] != null) {
                System.out.println(i + " - " + toDoList[i]);
                count++;
            }
        }
        if (count != 0) {
            System.out.print("\n\u001b[38;5;15mChoose a task to mark as completed: \u001b[0m");
            int userChoiceOfTaskToMarkAsCompleted = scan.nextInt();

            if (toDoList[userChoiceOfTaskToMarkAsCompleted] != null) {

                    System.out.println("\u001b[38;5;10mThe task '\u001b[38;5;15m" + toDoList[userChoiceOfTaskToMarkAsCompleted] + "\u001b[38;5;10m' was successfully completed!\u001b[0m");
                array.add(toDoList[userChoiceOfTaskToMarkAsCompleted]);
                    toDoList[userChoiceOfTaskToMarkAsCompleted] = null;


            } else {
                System.out.println("\n\u001b[38;5;9mInvalid task option!\u001b[0m");
            }
        } else {
            System.out.println("\n\u001b[38;5;9mYou don't have tasks!\u001b[0m");
        }
    }

    public static void removeTaskAsCompleted(ArrayList<String> array) {
        Scanner scan = new Scanner(System.in);



        if (!array.isEmpty()) {

            System.out.println("\n\u001b[38;5;15mDo you want to clean Completed Tasks? \n 1 - Yes\n 2 - No\u001b[0m");
            String yesNo = scan.next();
            if (yesNo.equals("1")) {
              array.clear();
                System.out.println("Completed Tasks Cleaned with success!");
            } else {
                System.out.println("\n\u001b[38;5;9mInvalid task option!\u001b[0m");
            }
        } else {
            System.out.println("\n\u001b[38;5;9mYou don't have completed tasks!\u001b[0m");
        }
    }

    public static void editTask(String[] toDoList) {
        Scanner scan = new Scanner(System.in);

        int count = 0;
        for (int i = 0; i < toDoList.length; i++) {
            if (toDoList[i] != null) {
                System.out.println(i + " - " + toDoList[i]);
                count++;
            }
        }
        if (count != 0) {
            System.out.print("\n\u001b[38;5;15mChoose a task to edit: \u001b[0m");
            int userChoiceOfTaskToEdit = scan.nextInt();

            scan.nextLine();

            if (toDoList[userChoiceOfTaskToEdit] != null) {

                    System.out.println("\n\u001b[38;5;15mOld: " + toDoList[userChoiceOfTaskToEdit] + "\u001b[0m");
                    System.out.print("\u001b[38;5;15mNew: \u001b[0m");
                    String userEditTask = scan.nextLine() + "||\u001b[32;1m edited in:\u001b[0m " + LocalDate.now() + " \u001b[32;1mat:\u001b[0m " + LocalTime.now();;

                    System.out.println("\n\u001b[38;5;10mThe task '\u001b[38;5;15m" + toDoList[userChoiceOfTaskToEdit] + "\u001b[38;5;10m' was changed to '\u001b[38;5;15m" + userEditTask + "\u001b[38;5;10m'!");
                    toDoList[userChoiceOfTaskToEdit] = userEditTask;

            } else {
                System.out.println("\n\u001b[38;5;9mInvalid task option!\u001b[0m");
            }
        } else {
            System.out.println("\n\u001b[38;5;9mYou don't have tasks to edit!\u001b[0m");
        }
    }



    public static void viewDeletedTasks(ArrayList<String> array,String[] array2){
      Scanner scan = new Scanner(System.in);
      boolean notContinue = true;
      String choose = "";

      while(notContinue) {

          for (int i = 0; i < array.size(); i++) {
              System.out.println(i + " - " + array.get(i));
          }
          System.out.println("1 - Recover Task\n2 - Back");
          choose = scan.next();
          switch (choose){
              case "1":
                  System.out.println("What task do you want to recover?;");
                  int taskRemoved = scan.nextInt();
                  String temp = " ";
                 int taskIndex = -1;
                  for (int i = 0; i < array.size(); i++) {
                      if (taskRemoved == i){
                          taskIndex = i;
                      }
                  }

                  int taskIndex2 = -1;
                  for (int i = 0; i <array2.length ; i++) {
                      temp = array.get(taskIndex);
                      if (array2[i] == null) {
                        taskIndex2 = i;
                      }
                  }
                  array2[taskIndex2] = temp;
                  array.remove(taskIndex);

                  break;

              case "2":
                  notContinue = false;
          }

      }
    }



    public static void deleteTask(String[] toDoList,ArrayList<String> array) {
        Scanner scan = new Scanner(System.in);

        int existedTasks = 0;
        for (int i = 0; i < toDoList.length; i++) {
            if (toDoList[i] != null) {
                System.out.println(i + " - " + toDoList[i]);
                existedTasks++;
            }
        }
        if (existedTasks > 0) {
            System.out.print("\n\u001b[38;5;15mChoose a task to delete: \u001b[0m");
            int userChoiceOfTaskToDelete = scan.nextInt();

            if (toDoList[userChoiceOfTaskToDelete] != null) {
                System.out.println("\u001b[38;5;10mThe task '\u001b[38;5;15m" + toDoList[userChoiceOfTaskToDelete] + "\u001b[38;5;10m' was successfully deleted!\u001b[0m");
                array.add(toDoList[userChoiceOfTaskToDelete]);
                toDoList[userChoiceOfTaskToDelete] = null;


            } else {
                System.out.println("\u001b[38;5;9mInvalid task option!\u001b[0m");
            }
        } else {
            System.out.println("\u001b[38;5;9mYou don't have tasks to delete!\u001b[0m");
        }
    }

    public static void organizeAlphabetically(String[] toDoList) {
        int count = 0;
        for (int i = 0; i < toDoList.length; i++) {
            if (toDoList[i] != null) {
                count++;
            }
        }
        Arrays.sort(toDoList, 0, count);
    }

    public static boolean upgradeToDoListPlan(String[] toDoList, boolean premium) {
        Scanner scan = new Scanner(System.in);
        if (!premium) {
            System.out.println("\n\u001b[38;5;15mDo you want to buy Premium Plan? (yes or no)\u001b[0m");
            System.out.print("\u001b[38;5;15m> \u001b[0m");
            String userUpgradeOption = scan.next();

            switch (userUpgradeOption) {
                case "yes":
                    premium = true;
                    System.out.println("\n\u001b[38;5;10mCurrently plan setted to Premium! Thank you!\u001b[0m");
                    break;
                default:
                    premium = false;
                    System.out.println("\n\u001b[38;5;12mMaybe next time then...\u001b[0m");
                    break;
            }

            return premium;
        } else {
            System.out.println("\n\u001b[38;5;11mYour plan is already setted to Premium! You don't need to buy it again.\u001b[0m");
        }
        return premium;
    }

}