package view;

import java.util.Scanner;

final public class menu {

    // show main menu
    public static void main() {
            System.out.println("=" .repeat(50));
            System.out.println("Selamat datang di aplikasi todolist");
            System.out.println("Pilih menu dibawah ini");
            System.out.println("1. Lihat todolist");
            System.out.println("2. Tambah todolist");
            System.out.println("3. Ubah todolist (wip)");
            System.out.println("4. Hapus todolist (wip)");
            System.out.println("0. Keluar");
            System.out.println("=" .repeat(50));
    }


    // back to main menu
    public static void back(Scanner scanner) {
        System.out.println();
        System.out.println("Tekan enter atau apa saja untuk kembali...");

        scanner.nextLine();
    }
}