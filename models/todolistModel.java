package models;

import java.util.HashMap;
import views.*;


/**
 * todolistModel
 */
interface todolistInterface {
        public void create(String task); // create
        public void getAllTasks(); // read
        public void update(int taskId, String newTaskName, String newStatus); // update
        public void delete(int taskId); // delete
}


/**
 * todolistModel
 */
public class todoListModel implements todolistInterface {

    /*
     * singleton pattern
     */

     // create private static instance of todolistModel, so there's only one instance of todolistModel
    private static todoListModel instance = new todoListModel();

    // make constructor private, so it can't be accessed from outside
    private todoListModel() {}

    // get the only instance of todolistModel
    public static todoListModel getInstance() {
        return instance;
    }
    
    /*
     * end of singleton pattern
     */





    // create hashmap to store tasks
    private HashMap<Integer, taskModel> tasks = new HashMap<Integer, taskModel>();





    // create task and add to tasks hashmap, return success message (create)
    public void create(String task) {
        
        // create task object, set status to undone
        taskModel newTask = new taskModel(task, "Belum selesai");

        // add task to tasks
        tasks.put(tasks.size() + 1, newTask);

        // return success message
        String result = "Task: " + newTask.getTask() + " - " + newTask.getStatus();

        menu.window("Success Create - ToDo-List", result);
    }


    // read all tasks from tasks hashmap, print all tasks (read)
    public void getAllTasks() {

        // check if tasks is empty
        if (tasks.size() == 0) {
            menu.window("Read - ToDo-List", "Tidak ada tugas!");
            return;
        }

        // print all tasks
        menu.showAllTasks(tasks);
    }
    
    // update task name and status based on task ID (update)
    public void update(int taskId, String newTaskName, String newStatus) {
        String result;
        if (tasks.containsKey(taskId)) {
            // get the task using the task ID
            taskModel taskToUpdate = tasks.get(taskId);

            // update task name and status
            taskToUpdate.setTask(newTaskName);
            taskToUpdate.setStatus(newStatus);

            result = "Task: " + taskToUpdate.getTask() + " - " + taskToUpdate.getStatus();

            menu.window("Update Task ID: " + taskId + " - ToDo-List", result);
        } else {
            result = "Task dengan ID: " + taskId + " tidak ditemukan.";
            menu.window("Update - ToDo-List", result);
        }
    }

    // delete task based on task ID (delete)
    public void delete(int taskId) {
        String result;
        if (tasks.containsKey(taskId)) {
            
            // get the task using the task ID
            taskModel taskToDelete = tasks.get(taskId);

            result = "Task: " + taskToDelete.getTask() + " - " + taskToDelete.getStatus();

            // delete task
            tasks.remove(taskId);

            

            menu.window("Success Delete - ToDo-List", result);
        } else {
            result = "Task dengan ID: " + taskId + " tidak ditemukan.";
            menu.window("Error on Delete - ToDo-List", result);
        }
    }

    // getter for tasks
    public HashMap<Integer, taskModel> getTasks() {
        return this.tasks;
    }
}
