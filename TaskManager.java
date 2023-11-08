import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TaskManager {
    ArrayList<Task> tasks = new ArrayList<>();


    Task createTask () {
        createUniqueID();
        Scanner scan = new Scanner(System.in);
        System.out.print("\n\u001b[38;5;15mTask name: \u001b[0m");
        String taskName = scan.nextLine();
        System.out.print("\n\u001b[38;5;15mDescription of task \u001b[0m");
        String taskDescription = scan.nextLine();
        Task newTask = new Task(createUniqueID(),taskName,taskDescription);
        tasks.add(newTask);
        System.out.println(newTask.id + " is created");

return newTask;
    }

    String createUniqueID() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
        return ft.format(dNow);
    }

    void getList(){
        System.out.println("\n\t\t\u001b[38;5;15mToDoList\u001b[0m");
        System.out.println("\u001b[33;1mYou have  tasks to do!\u001b[0m");
        System.out.println("\u001b[38;5;8m------------------------\u001b[0m");
        for (int i = 0; i <tasks.size() ; i++) {
            System.out.print("\nTask:" + tasks.get(i).taskName + " \nDescription: " + tasks.get(i).description );
        }
    }

    void deleteTaskByID(int Id){

    }




}

