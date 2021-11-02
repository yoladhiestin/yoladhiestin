package dadu;

import java.util.Random;

public class Dadu {
    private final Random random;

    Dadu() {
        random = new Random();
    }

    int parse(String kode) {
        String[] split = kode.split("[d|\\+]");
        String angka1;
        String angka2;
        String angka3;

        int hasil = 0;

        if (split.length <= 2) {
            if (kode.matches("(.*)d(.*)")) {
                System.out.print("Format Penulisan Benar = ");
                if (split[0].equals("")) {
                    System.out.println("1d" + split[1]);
                    angka1 = "1";
                    angka2 = split[1];
                } else {
                    System.out.println(split[0] + "d" + split[1]);
                    angka1 = split[0];
                    angka2 = split[1];
                }
                hasil = d(Integer.parseInt(angka2), Integer.parseInt(angka1));

            } else {
                System.out.println("Format Penulisan Salah !");
                hasil = 0;
            }
        } else if (kode.matches("(.*)d(.*)\\+(.*)")) {
            System.out.println("Format Benar :");
            if (split[0].equals("")) {
                System.out.println("1d" + split[1] + "+" + split[2]);
                angka1 = "1";
                angka2 = split[1];
                angka3 = split[2];
            } else {
                System.out.println(split[0] + "d" + split[1] + "+" + split[2]);
                angka1 = split[0];
                angka2 = split[1];
                angka3 = split[2];
            }

            hasil = e(Integer.parseInt(angka2), Integer.parseInt(angka1), Integer.parseInt(angka3));
        } else {
            System.out.println("Format Salah !!!");
            hasil = 0;
        }

        return hasil;

    }

    int d(int sides, int count) {
        int total = 0;

        for (int i = 0; i < count; i++) {
            int angkaacak = random.nextInt(sides) + 1;
            total += angkaacak;
            System.out.print(angkaacak);
            if (i < count - 1) {
                System.out.print(" + ");
            }
        }
        System.out.print(" = ");
        return total;
    }

    int e(int sides, int count, int tambahan) {
        int total = 0;
        int lemparan = 0;
        lemparan = count + tambahan;

        for (int i = 0; i < lemparan; i++) {
            int angkaacak = random.nextInt(sides) + 1;
            total += angkaacak;
            System.out.print(angkaacak);
            if (i < lemparan - 1) {
                System.out.print(" + ");
            }
        }
        System.out.print(" = ");
        return total;
    }
}