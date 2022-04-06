import java.util.Scanner;
//tt = Tes tulis
//tc = tes coding
//tw = tes wawancara
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int menu, menu2;
        String nik, nama;
        double tt, tc, tw;
        do {
            System.out.println("From Pendaftaran PT. UDIN");
            System.out.println("1. Android Develpoment");
            System.out.println("2. Web Development");
            System.out.println("0. exit");
            System.out.print("Pilih jenis form: ");

            menu = in.nextInt();
            if (menu == 0) {
                System.exit(0);
            }
            Pendaftaran pendaftar = null;
            if (menu == 1) {
                pendaftar = new Pendaftaran(menu);
            } else if (menu == '2') {
                pendaftar = new Pendaftaran(menu);
            }

            System.out.println("FORM INPUT DATA");
            System.out.print("NIK: ");
            nik = in.next();
            System.out.print("Nama: ");
            in.nextLine();
            nama = in.nextLine();
            System.out.print("Nilai tes Tulis: ");
            tt = in.nextDouble();
            System.out.print("Nilai tes Coding: ");
            tc = in.nextDouble();
            System.out.print("Nilai tes Wawancara: ");
            tw = in.nextDouble();

            pendaftar.edit(nik, nama, tc, tt, tw);

            if (menu == 1) {
                pendaftar.cek();
            } else if (menu == 2) {
                pendaftar.cek();
            }
            do {
                System.out.println("Menu");
                System.out.println("1. Edit");
                System.out.println("2. Tampil");
                System.out.println("0. Exit");
                System.out.print("Pilih : ");
                menu2 = in.nextInt();

                if (menu2 == 1) {
                    System.out.println("");
                    System.out.println("FORM INPUT DATA");

                    System.out.print("Nilai tes Tulis: ");
                    tt = in.nextDouble();
                    System.out.print("Nilai tes Coding: ");
                    tc = in.nextDouble();
                    System.out.print("Nilai tes Wawancara: ");
                    tw = in.nextDouble();
                    in.nextLine();

                    pendaftar.edit(nik, nama, tc, tt, tw);

                    if (menu == 1) {
                        pendaftar.cek();
                    } else if (menu == 2) {
                        pendaftar.cek();
                    }
                } else if (menu2 == 2) {
                    System.out.println("Nilai akhir: " + pendaftar.total);
                    System.out.println("KETERANGAN : " + pendaftar.status);
                }
            } while (menu2 != 0);
        }while(menu!=0);
    }

}