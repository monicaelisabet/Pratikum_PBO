import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int loop;
        do{
            System.out.println("==========");
            System.out.println("Menu Utama");
            System.out.println("==========");
            System.out.println("1. Hitung Balok");
            System.out.println("2. Hitung Tabung");
            System.out.println("0. Exit");

            System.out.print("Pilih : ");
            int pilih = in.nextInt();

            switch(pilih){
                case 1:
                    double panjang, lebar, tinggi;
                    System.out.print("Input Panjang \t: ");
                    panjang = in.nextInt();
                    System.out.print("Input Lebar \t: ");
                    lebar = in.nextInt();
                    System.out.print("Input Tinggi \t: ");
                    tinggi = in.nextInt();
                    Balok balok = new Balok(panjang, lebar, tinggi);
                    System.out.println("Luas Persegi Panjang \t\t: " + balok.hitungLuas());
                    System.out.println("Keliling Persegi Panjang \t: " + balok.hitungKeliling());
                    System.out.println("Volume Balok \t\t\t\t: " + balok.hitungVolume());
                    System.out.println("Luas Permukaan Balok \t\t: " + balok.hitungLuasPr());
                    break;
                case 2:
                    double r;
                    System.out.print("Input Tinggi \t\t: ");
                    tinggi = in.nextInt();
                    System.out.print("Input Jari - jari \t: ");
                    r = in.nextInt();
                    Tabung tabung = new Tabung(r, tinggi);
                    System.out.println("Luas Lingkaran \t\t\t: " + tabung.hitungLuas());
                    System.out.println("Keliling Lingkaran \t\t: " + tabung.hitungKeliling());
                    System.out.println("Volume Tabung \t\t\t: " + tabung.hitungVolume());
                    System.out.println("Luas Permukaan Tabung \t: " + tabung.hitungLuasPr());
                    break;
                case 0:
                    System.exit(0);
            }
            System.out.println("\n");
            System.out.print("Apakah ingin mengulangi menu? (Tekan 1 jika iya) : ");
            loop = in.nextInt();
        }while(loop == 1);
    }
}
