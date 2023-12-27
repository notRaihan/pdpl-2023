package controllers;

import java.util.Scanner;

import models.todolistModel;
import views.menu;

public class prompts {
    public static void main(String[] args) {
        todolistModel taskModel = todolistModel.getInstance();

        try (Scanner scanner = new Scanner(System.in)) {

            while (!scanner.equals("0")) {

                // clear screen with escape sequence
                System.out.print("\033[H\033[2J");

                menu.main();
                System.out.print("Pilih menu: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        // clear screen with escape sequence
                        System.out.print("\033[H\033[2J");

                        taskModel.getAllTasks();
                        menu.back(scanner);
                        break;
                    case 2:
                        // clear screen with escape sequence
                        System.out.print("\033[H\033[2J");

                        System.out.print("Tambah todolist: ");
                        String taskName = scanner.nextLine();
                        


                        // print task message has been added
                        for (String task : taskModel.create(taskName)) {
                            System.out.println(task);
                        }

                        menu.back(scanner);
                        break;
                   case 3:
                         // clear screen with escape sequence
                        System.out.print("\033[H\033[2J");

                        taskModel.getAllTasks();
                        System.out.print("Pilih nomor todolist yang ingin diubah: ");
                        int taskIndexToUpdate = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        // Check if the index is valid
                        if (taskIndexToUpdate >= 1 && taskIndexToUpdate <= taskModel.getTaskCount()) {
                        System.out.print("Masukkan perubahan untuk todolist: ");
                        String updatedTaskName = scanner.nextLine();

                        // Update the task
                        for (String task : taskModel.update(taskIndexToUpdate, updatedTaskName)) {
                        System.out.println(task);
                        }
                        System.out.println("Todolist berhasil diubah.");
                        } else {
                        System.out.println("Nomor todolist tidak valid.");
                        }

                        menu.back(scanner);
                        break;

                    case 4:
                        // clear screen with escape sequence
                        System.out.print("\033[H\033[2J");

                        System.out.println("Hapus todolist");
                        break;
                    case 0:
                        System.out.println("Keluar");
                        break;
                    default:
                        System.out.println("Menu tidak tersedia");
                        break;
                }
            }
        }

    }
}
