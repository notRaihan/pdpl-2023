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
    
    public HashMap<Integer, taskModel> tasks = new HashMap<Integer, taskModel>();

    // create task and add to tasks hashmap, return success message (create)
    public String[] create(String task) {
        
        // create task object, set status to undone
        taskModel newTask = new taskModel(task, "undone");

        // add task to tasks
        tasks.put(tasks.size() + 1, newTask);

        // return success message
        String[] result = new String[2];
        result[0] = "success";
        result[1] = "Tugas berhasil ditambahkan";
        return result;
    }


    // read all tasks from tasks hashmap, print all tasks (read)
    public void getAllTasks() {
        for (int i = 1; i <= tasks.size(); i++) {
            System.out.println("Task ID " + i + ": " + tasks.get(i).getTask() + " - " + tasks.get(i).getStatus());
        }
    }
    

    //TODO: update task/status (update)
    public void update() {
        System.out.println("Ini adalah fungsi update");
    }

    //TODO: delete task (delete)
    public void delete() {
        System.out.println("Ini adalah fungsi delete");
    }
}