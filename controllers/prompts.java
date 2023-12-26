package controllers;

import java.util.Scanner;

import models.todolistModel;
import view.menu;

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


                        // print task message has been added
                        for (String task : taskModel.create("Belajar Java")) {
                            System.out.println(task);
                        }

                        menu.back(scanner);
                        break;
                    case 3:
                        // clear screen with escape sequence
                        System.out.print("\033[H\033[2J");

                        System.out.println("Ubah todolist");
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
