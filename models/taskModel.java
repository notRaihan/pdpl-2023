package models;


/**
 * taskModel (task, status)
 */
public class taskModel {
    private String task;
    private String status;

    public taskModel(String task, String status) {
        this.task = task;
        this.status = status;
    }

    public String getTask() {
        return this.task;
    }

    public String getStatus() {
        return this.status;
    }
}
