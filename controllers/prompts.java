package controllers;

import java.util.InputMismatchException;
import java.util.Scanner;

import models.todolistModel;
import views.menu;

public class prompts {
    public static void main(String[] args) {
        todolistModel taskModel = todolistModel.getInstance();

        try (Scanner scanner = new Scanner(System.in)) {
            int choice = -1;
            while (choice != 0) {

                // clear screen with escape sequence
                System.out.print("\033[H\033[2J");

                menu.main();

                // handle input jika bukan angka
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    // clear screen with escape sequence
                    System.out.print("\033[H\033[2J");

                    System.out.println("Input harus berupa angka");
                    scanner.nextLine(); // consume newline
                    menu.back(scanner);
                    continue;
                }

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

                        // clear screen with escape sequence
                        System.out.print("\033[H\033[2J");

                        // print task message has been added
                        System.out.println(taskModel.create(taskName));

                        menu.back(scanner);
                        break;
                    case 3:
                        // clear screen with escape sequence
                        System.out.print("\033[H\033[2J");

                        taskModel.getAllTasks();
                        System.out.print("Pilih nomor task yang ingin diubah: ");
                        int taskIndexToUpdate = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        if (taskIndexToUpdate > taskModel.getTasks().size() && taskIndexToUpdate <= 1) {
                            System.out.println("Nomor tidak valid");
                            menu.back(scanner);
                            break;
                        }

                        System.out.print("Ubah todolist: ");
                        String updatedTaskName = scanner.nextLine();

                        // clear screen with escape sequence
                        System.out.print("\033[H\033[2J");

                        // print task message has been updasted
                        System.out.println(taskModel.update(taskIndexToUpdate, updatedTaskName, "undone"));

                        menu.back(scanner);
                        break;

                    case 4:
                        // clear screen with escape sequence
                        System.out.print("\033[H\033[2J");

                        taskModel.getAllTasks();
                        System.out.print("Masukkan id task yang ingin dihapus: ");
                        Integer taskId = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        // clear screen with escape sequence
                        System.out.print("\033[H\033[2J");

                        System.out.println(taskModel.delete(taskId));
                        menu.back(scanner);
                        break;

                    case 0:
                        System.out.println("Bye, terima kasih telah menggunakan aplikasi ini!");
                        break;
                    default:
                        // clear screen with escape sequence
                        System.out.print("\033[H\033[2J");

                        System.out.println("Menu tidak tersedia");
                        menu.back(scanner);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Terjadi error: " + e.getMessage());
        }

    }
}
