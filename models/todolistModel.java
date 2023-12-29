package models;

import java.util.HashMap;


/**
 * todolistModel
 */
interface todolistInterface {
        public String create(String task); // create
        public void getAllTasks(); // read
        public String update(int taskId, String newTaskName, String newStatus); // update
        // public void delete();
}


/**
 * todolistModel
 */
public class todolistModel implements todolistInterface {

    /*
     * singleton pattern
     */

     // create private static instance of todolistModel, so there's only one instance of todolistModel
    private static todolistModel instance = new todolistModel();

    // make constructor private, so it can't be accessed from outside
    private todolistModel() {}

    // get the only instance of todolistModel
    public static todolistModel getInstance() {
        return instance;
    }
    
    /*
     * end of singleton pattern
     */





    // create hashmap to store tasks
    private HashMap<Integer, taskModel> tasks = new HashMap<Integer, taskModel>();





    // create task and add to tasks hashmap, return success message (create)
    public String create(String task) {
        
        // create task object, set status to undone
        taskModel newTask = new taskModel(task, "undone");

        // add task to tasks
        tasks.put(tasks.size() + 1, newTask);

        // return success message
        String result = "Task berhasil ditambahkan. \n" +
                        "Task: " + newTask.getTask() + " - " + newTask.getStatus() + "\n";
        return result;
    }


    // read all tasks from tasks hashmap, print all tasks (read)
    public void getAllTasks() {

        if (tasks.size() == 0) {
            System.out.println("yay, Tidak ada tugas!");
            return;
        }

        //
        for (int i = 1; i <= tasks.size(); i++) {
            System.out.println("Task ID " + i + ": " + tasks.get(i).getTask() + " - " + tasks.get(i).getStatus());
        }
    }
    

    //TODO: update task/status (update)
    // update task name and status based on task ID (update)
    public String update(int taskId, String newTaskName, String newStatus) {
        String result;
        if (tasks.containsKey(taskId)) {
            // get the task using the task ID
            taskModel taskToUpdate = tasks.get(taskId);

            // update task name and status
            taskToUpdate.setTask(newTaskName);
            taskToUpdate.setStatus(newStatus);

            result = "Task dengan ID: " + taskId + " berhasil diubah. \n" +
                     "Task: " + taskToUpdate.getTask() + " - " + taskToUpdate.getStatus() + "\n";

            return result;
        } else {
            result = "Task dengan ID: " + taskId + " tidak ditemukan.";
            return result;
        }
    }

    //TODO: delete task (delete)
    public String delete(int taskId) {
        String result;
        if (tasks.containsKey(taskId)) {
            
            // get the task using the task ID
            taskModel taskToDelete = tasks.get(taskId);

            result = "Task dengan ID: " + taskId + " berhasil dihapus. \n" +
                     "Task: " + taskToDelete.getTask() + " - " + taskToDelete.getStatus() + "\n";

            // delete task
            tasks.remove(taskId);

            

            return result;
        } else {
            result = "Task dengan ID: " + taskId + " tidak ditemukan.";
            return result;
        }
    }

    // getter for tasks
    public HashMap<Integer, taskModel> getTasks() {
        return this.tasks;
    }
}
