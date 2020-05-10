package com.company;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class Main {
    static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            int menu = showMenu();
            if (menu == 1) {
                getRandom();
            } else if (menu == 2) {
                bubbleAsc();
            } else if (menu == 3){
                selectionAsc();
            } else if (menu == 4){
                bubbleDesc();
            } else if (menu == 5){
                selectionDesc();
            } else if (menu == 6) {
                run = false;
            }
            System.out.println("\n-------------------------Terima kasih-------------------------");
        }
    }
    private static int showMenu() {
        System.out.println("Selamat Datang di Prigram Simulasi Menu\n" +
                "1. Random Data\n" +
                "2. Simulasi Bubble Sort - Ascending\n" +
                "3. Simulasi Selection Sort - Ascending\n" +
                "4. Simulasi Bubble Sort - Descending\n" +
                "5. Simulasi Selection Sort - Descending\n" +
                "6. Keluar");
        int Menu = 0;

        while (Menu < 1 || Menu > 6) {
            try{
                System.out.print("Masukkan menu yang anda pilih: ");
                Menu = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Mohon maaf anda salah memasukkan menu");
            }
            in.nextLine();
        }

        return Menu;
    }

    private static void getRandom() {
        int min = 0, max = 0;
        boolean validasi =false;
        while (!validasi) {
            try {
                System.out.print("Batas Bawah \t: ");
                min = in.nextInt();
                validasi = true;
            } catch (InputMismatchException e) {
                System.out.println("Mohon maaf masukkan bilangan yang dimasukkan harus berupa angka");
            }
            in.nextLine();
            try {
                System.out.print("Batas Atas \t: ");
                max = in.nextInt();
                validasi = true;
            } catch (InputMismatchException e) {
                System.out.println("Mohon maaf masukkan bilangan yang dimasukkan harus berupa angka");
            }
        }
        //CEK
        if (min<max){
            List<Integer> randomIntegers = new Random().ints(5, min, max).boxed().collect(toList());
            System.out.print(randomIntegers);
        } else {
            System.out.print("Batas bawah harus lebih kecil \t: ");
        }
    }

    private static void bubbleAsc(){}

    private static void selectionAsc(){}

    private static void bubbleDesc(){}

    private static void selectionDesc(){}
}