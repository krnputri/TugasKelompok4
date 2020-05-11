package com.company;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Main {
    static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        boolean run = true;
        while (run) {
            int menu = showMenu();
            if (menu == 1) {
                list = getRandom();
                System.out.print(list);
            } else if (menu == 2) {
                bubbleAsc(list);
            } else if (menu == 3){
                selectionAsc();
            } else if (menu == 4){
                bubbleDesc(list);
            } else if (menu == 5){
                selectionDesc();
            } else if (menu == 6) {
                run = false;
            }
            System.out.println("\n-------------------------Terima kasih-------------------------");
        }
    }
    private static int showMenu() {
        Scanner input = new Scanner(System.in);
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
    private static Scanner input = new Scanner(System.in);
    public static int min, max, temp_min, temp_max, i,j,k, random_number []=new int [5];
    static boolean check = false;
    private String word;

    private static List<Integer> getRandom() {
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
        List<Integer> randomIntegers = new ArrayList<>();
        if (min<max){
            randomIntegers = new Random().ints(5, min, max).boxed().collect(toList());
        } else {
            System.out.print("Batas bawah harus lebih kecil \t: ");
        }
        return randomIntegers;
    }


    private static void bubbleAsc(List<Integer> list){
        Integer[] arr = list.toArray(new Integer[0]);

        for(int a = 0; a < (arr.length-1); a++)
        {
            System.out.println("Pass "+(a+1)+" :");
            for(int b = 0; b < arr.length; b++){
                System.out.print(arr[b]+"  ");
            }
            System.out.println("  ");
            for(int b = 0; b < arr.length-1; b++) {
                if(arr[b] > arr[b+1]) {
                    //    proses pertukaran nilai Data
                    int temp = arr[b];
                    arr[b] = arr[b+1];
                    arr[b+1] = temp;
                }

                if(b < arr.length-(a+1)) {
                    for(int c = 0; c < arr.length; c++){
                        System.out.print(arr[c]+"  ");
                    }
                    System.out.println("  ");
                }
            }
            ArrayList<Integer> result = new ArrayList<Integer>();

            for(int b = 0; b < arr.length; b++){
                result.add(arr[b]);
            }
            String Res = Arrays.toString(result.toArray()).replace("[", "").replace("]", "");
            System.out.println(" Result of pass "+(a+1)+":");
            System.out.println(Res);
            System.out.println(" ");
        }

    }

    private static void selectionAsc(){
        if(!check)
        {
            System.out.println("\nBelum Masukkan Bilangan, Silahkan Pilih Menu Nomor 1");
            input();
        }

        String extreme = "Minimum";

        for(int i=0; i <= random_number.length-2; i++)
        {
            temp_max = i;

            k = i+1;
            System.out.println("\nPass " +k);

            for(int j=1+i; j <= random_number.length-1; j++)
            {
                selectDisplay(random_number,extreme,j,temp_max);
                if(random_number[j]>=random_number[temp_max])
                {
                    temp_min = j;
                }
            }
            selectDisplay(random_number,extreme,temp_min,temp_min);
            swap(random_number,i,temp_min);
            System.out.println("Result of Pass " +k +": ");
            displayNumber(random_number);
        }

    }

    private static void bubbleDesc(List<Integer> list){
        Integer[] arr = list.toArray(new Integer[0]);

        for(int a = 0; a < (arr.length-1); a++)
        {
            System.out.println("Pass "+(a+1)+" :");
            for(int b = 0; b < arr.length; b++){
                System.out.print(arr[b]+"  ");
            }
            System.out.println("  ");
            for(int b = 0; b < arr.length-1; b++) {
                if(arr[b] < arr[b+1]) {
                    //    proses pertukaran nilai Data
                    int temp = arr[b];
                    arr[b] = arr[b+1];
                    arr[b+1] = temp;
                }

                if(b < arr.length-(a+1)) {
                    for(int c = 0; c < arr.length; c++){
                        System.out.print(arr[c]+"  ");
                    }
                    System.out.println("  ");
                }
            }
            ArrayList<Integer> result = new ArrayList<Integer>();

            for(int b = 0; b < arr.length; b++){
                result.add(arr[b]);
            }
            String Res = Arrays.toString(result.toArray()).replace("[", "").replace("]", "");
            System.out.println(" Result of pass "+(a+1)+":");
            System.out.println(Res);
            System.out.println(" ");
        }
    }

    private static void selectionDesc(){
        if(!check)
        {
            System.out.println("\nBelum Masukkan Bilangan, Silahkan Pilih Menu Nomor 1");
            input();
        }

        String extreme = "Maximum";

        for(int i=0; i <= random_number.length-2; i++)
        {
            temp_max = i;

            k = i+1;
            System.out.println("\nPass " +k);

            for(int j=1+i; j <= random_number.length-1; j++)
            {
                selectDisplay(random_number,extreme,j,temp_max);
                if(random_number[j]>=random_number[temp_max])
                {
                    temp_max = j;
                }
            }
            selectDisplay(random_number,extreme,temp_max,temp_max);

            swap(random_number,i,temp_max);
            System.out.println("Result of Pass " +k +": ");
            displayNumber(random_number);
        }

    }
    public static void displayNumber(int[] random_number)
    {
        for (int k=0; k <= random_number.length-1; k++){
            System.out.print(random_number[k]+"   ");
        }
        System.out.println();
    }

    public static void Exit(){
        System.out.println("Terima kasih broo!");
        System.exit(0);
    }

    public static void selectDisplay(int[] random_number, String extreme, int b, int temp_min) //printing selection method
    {
        for(int k=0; k<=random_number.length-1; k++)
        {
            if(k == temp_min)
            {
                System.out.print("Current " +extreme +" (" +random_number[k] +")   ");
            }
            else if(k == j)
            {
                System.out.print("(" +random_number[k] +")   ");
            }
            else
            {
                System.out.print(random_number[k] +"   ");
            }
        }
        System.out.println();
    }

    public static void swap(int[] random_number, int var1, int var2)
    {
        int temp;
        temp=random_number[var1];
        random_number[var1]=random_number[var2];
        random_number[var2]=temp;
    }
}

