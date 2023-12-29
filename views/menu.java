package views;

import java.util.Scanner;
import java.util.HashMap;
import models.*;

final public class menu {

    // center text in console
    private static String center(String text, int len){
        if (text.length() > len) return text.substring(0, len);
        if (text.length() == len) return text;
    
        int padding = (len - text.length()) / 2;
        if (padding <= 0) return text;
    
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < padding; i++) sb.append(' ');
        sb.append(text);
        while (sb.length() < len) sb.append(' ');
    
        return sb.toString();
    }

    // show main menu
    public static void main() {
        String border = "+" + "-".repeat(48) + "+";
        String emptyLine = "|" + " ".repeat(48) + "|";
    
        System.out.println(border);
        System.out.println("|" + center("Selamat datang di aplikasi - ToDo-List", 48) + "|");
        System.out.println(border);
        System.out.println("|" + center("Silahkan pilih menu di bawah ini:", 48) + "|");
        System.out.println(emptyLine);
        System.out.println("|" + center("1. Lihat todolist", 48) + "|");
        System.out.println("|" + center("2. Tambah todolist", 48) + "|");
        System.out.println("|" + center("3. Ubah todolist", 48) + "|");
        System.out.println("|" + center("4. Hapus todolist", 48) + "|");
        System.out.println("|" + center("0. Keluar", 48) + "|");
        System.out.println(border);
        System.out.println(" ");
        System.out.print("Pilih menu: ");
    }

    // show window
    public static void window(String title, String content) {
        String border = "+" + "-".repeat(48) + "+";
    
        System.out.println(border);
        System.out.println("|" + center(title, 48) + "|");
        System.out.println(border);
        System.out.println("|" + center(content, 48) + "|");
        System.out.println(border);
    }

    // show window title
    public static void windowTitle(String title) {
        String border = "+" + "-".repeat(48) + "+";
    
        System.out.println(" ");
        System.out.println(border);
        System.out.println("|" + center(title, 48) + "|");
        System.out.println(border);
        System.out.println(" ");
    }

    // back to main menu
    public static void back(Scanner scanner) {
        System.out.println(" ");
        System.out.print("Tekan enter atau apa saja untuk kembali...");

        scanner.nextLine();
    }

    public static void clearScreen() {
        // clear screen with escape sequence
        System.out.print("\033[H\033[2J");
    }

    // show all tasks
    public static void showAllTasks(HashMap<Integer, taskModel> tasks) {
        String border = "+" + "-".repeat(48) + "+";
    
        System.out.println(border);
        System.out.println("|" + center("Daftar todolist", 48) + "|");
        System.out.println(border);
    
        for (int i = 1; i <= tasks.size(); i++) {
            System.out.println("|" + center("Task ID " + i + ": " + tasks.get(i).getTask() + " - " + tasks.get(i).getStatus(), 48) + "|");
        }
        System.out.println(border);
    }
}
