package controllers;

import java.util.InputMismatchException;
import java.util.Scanner;

import models.todoListModel;
import views.menu;

final public class prompts {

    public static void start() {
        todoListModel taskModel = todoListModel.getInstance();

        try (Scanner scanner = new Scanner(System.in)) {
            int choice = -1;
            while (choice != 0) {

                menu.clearScreen();

                menu.main();

                // handle input jika bukan angka
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    menu.clearScreen();

                    menu.window("Error on Main Menu - ToDo-List", "Input harus berupa angka!");
                    scanner.nextLine(); // consume newline
                    menu.back(scanner);
                    continue;
                }

                scanner.nextLine(); // consume newline

                switch (choice) {
                    // read all tasks
                    case 1:
                        menu.clearScreen();

                        taskModel.getAllTasks();
                        menu.back(scanner);
                        break;
                    // create task
                    case 2:
                        menu.clearScreen();

                        menu.windowTitle("Add - ToDo-List");
                        System.out.print("-> Masukkan nama task: ");
                        String taskName = scanner.nextLine();

                        // check if task name is empty
                        if (taskName.length() == 0) {
                            menu.clearScreen();

                            menu.window("Error on Add - ToDo-List", "Nama task tidak boleh kosong!");
                            menu.back(scanner);
                            break;
                        }

                        menu.clearScreen();

                        // print task message has been added
                        taskModel.create(taskName);

                        menu.back(scanner);
                        break;
                    // update task
                    case 3:
                        Integer taskIndexToUpdate;
                        menu.clearScreen();

                        taskModel.getAllTasks();
                        menu.windowTitle("Update - ToDo-List");
                        System.out.print("-> Masukkan nomor task yang ingin diubah: ");

                        // handle input jika bukan angka
                        try {
                            taskIndexToUpdate = scanner.nextInt();
                            scanner.nextLine(); // consume newline

                            // check if task index is valid (not out of bound)
                            if (taskIndexToUpdate > taskModel.getTasks().size() || taskIndexToUpdate <= 0) {
                                // clear screen with escape sequence
                                System.out.print("\033[H\033[2J");

                                menu.window("Error on Update - ToDo-List", "Nomor tidak valid!");
                                menu.back(scanner);
                                break;
                            }
                        } catch (InputMismatchException e) {
                            menu.clearScreen();

                            menu.window("Error on Update - ToDo-List", "Input harus berupa angka!");
                            scanner.nextLine(); // consume newline
                            menu.back(scanner);
                            break;
                        }

                        menu.clearScreen();

                        menu.windowTitle("Update - ToDo-List");
                        System.out.print("-> Masukkan nama task baru: ");

                        String updatedTaskName = scanner.nextLine();

                        // check if task name is empty
                        if (updatedTaskName.length() == 0) {
                            menu.clearScreen();

                            menu.window("Error on Update - ToDo-List", "Nama task tidak boleh kosong!");
                            menu.back(scanner);
                            break;
                        }

                        menu.clearScreen();

                        System.out.println("Ubah status todolist: ");
                        System.out.println("1. Selesai");
                        System.out.println("2. Belum selesai");
                        System.out.print("Pilih status: ");
                        String updatedStatus;
                        try {
                            Integer status = scanner.nextInt();
                            scanner.nextLine(); // consume newline

                            menu.clearScreen();

                            // check if status is valid
                            if (status == 1) {
                                updatedStatus = "Selesai";
                            } else if (status == 2) {
                                updatedStatus = "Belum selesai";
                            } else {
                                menu.window("Error on Update - ToDo-List", "Status tidak valid!");
                                menu.back(scanner);
                                break;
                            }
                        } catch (InputMismatchException e) {
                            menu.clearScreen();

                            menu.window("Error on Update - ToDo-List", "Input harus berupa angka!");
                            scanner.nextLine(); // consume newline
                            menu.back(scanner);
                            break;
                        }

                        menu.clearScreen();

                        // print task message has been updasted
                        taskModel.update(taskIndexToUpdate, updatedTaskName, updatedStatus);

                        menu.back(scanner);
                        break;

                    // delete task
                    case 4:
                        Integer taskId;
                        menu.clearScreen();

                        taskModel.getAllTasks();
                        menu.windowTitle("Delete - ToDo-List");
                        System.out.print("-> Masukkan nomor task yang ingin dihapus: ");

                        try {
                            taskId = scanner.nextInt();
                            scanner.nextLine(); // consume newline
                            // check if task index is valid
                            if (taskId > taskModel.getTasks().size() && taskId <= 1) {
                                menu.window("Error on Delete - ToDo-List", "Nomor tidak valid!");
                                menu.back(scanner);
                                break;
                            }
                        } catch (InputMismatchException e) {
                            menu.clearScreen();

                            menu.window("Error on Delete - ToDo-List", "Input harus berupa angka!");
                            scanner.nextLine(); // consume newline
                            menu.back(scanner);
                            break;
                        }

                        menu.clearScreen();

                        taskModel.delete(taskId);
                        menu.back(scanner);
                        break;

                    case 0:
                        System.out.println("Bye, terima kasih telah menggunakan aplikasi ini!");
                        break;
                    default:
                        menu.clearScreen();

                        menu.window("Error on Main Menu - ToDo-List", "Menu tidak valid!");
                        menu.back(scanner);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Terjadi error: " + e.getMessage());
        }

    }
}
