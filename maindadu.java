package dadu;

import java.util.Scanner;

public class maindadu {
    public static void main(String[] args) {
        System.out.println("Program Start");
        System.out.println("Masukkan Inputan : ");
        Scanner in = new Scanner(System.in);
        Dadu dadu = new Dadu();
        String kode;

        while (true) {
            kode = in.nextLine().toLowerCase();
            if (kode.equals("q"))
                break;
            System.out.println(dadu.parse(kode));
        }
    }
}