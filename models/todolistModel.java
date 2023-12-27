package models;

import java.util.HashMap;


/**
 * todolistModel
 */
interface todolistInterface {
        public String[] create(String task); // create
        public void getAllTasks(); // read
        public void update();
        public void delete();
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
    public HashMap<Integer, taskModel> tasks = new HashMap<Integer, taskModel>();





    // create task and add to tasks hashmap, return success message (create)
    public String[] create(String task) {
        
        // create task object, set status to undone
        taskModel newTask = new taskModel(task, "undone");

        // add task to tasks
        tasks.put(tasks.size() + 1, newTask);

        // return success message
        String[] result = {"success", "Task berhasil ditambahkan"};
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
    public void update(int taskId, String newTaskName, String newStatus) {
        if (tasks.containsKey(taskId)) {
            // get the task using the task ID
            taskModel taskToUpdate = tasks.get(taskId);

            // update task name and status
            taskToUpdate.setTask(newTaskName);
            taskToUpdate.setStatus(newStatus);

            System.out.println("Task berhasil diupdate.");
        } else {
            System.out.println("Task ID tidak valid.");
        }
    }

    //TODO: delete task (delete)
    public void delete() {
        System.out.println("Ini adalah fungsi delete");
    }
}
