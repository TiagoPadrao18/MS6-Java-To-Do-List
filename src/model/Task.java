package src.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Task {

    private List<String> taskNotes;
    private final String id;
    private String taskName;
    private String description;

    private boolean isCompleted = false;



    public Task(String taskName, String description) {
        this.id = UUID.randomUUID().toString();
        this.taskName = taskName;
        this.description = description;
        this.taskNotes = new ArrayList<>();
    }

    public List<String> getTaskNotes() {
        return taskNotes;
    }

    public void setTaskNotes(List<String> taskNotes) {
        this.taskNotes = taskNotes;
    }

    public String getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }



    @Override
    public String toString() {
        return "Name: " + taskName  + " " +
                " Description: " + description;
    }
}
