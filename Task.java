import java.util.ArrayList;

public class Task {

    ArrayList<TaskManager> taskNotes = new ArrayList<>();
    String id;
    String taskName;
    String description;



    public Task(String id, String taskName, String description) {
        this.id = id;
        this.taskName = taskName;
        this.description = description;
    }


}
