import models.*;


public class main {
    public static void main(String[] args) {
        todolistModel todolist = new todolistModel();
        todolist.create("Belajar Java");
        todolist.create("Belajar PHP");

        todolist.getAllTasks();
    }
}
