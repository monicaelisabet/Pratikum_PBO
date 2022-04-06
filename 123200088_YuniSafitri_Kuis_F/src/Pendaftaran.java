public class Pendaftaran extends Bobot{String nik, nama, status, divisi;
    double tcoding, ttulis, twawancara, total;

    public Pendaftaran(int jenis) {
        if (jenis == 1) {
            super.tulis = 0.2;
            super.coding =  0.5;
            super.wawancara = 0.3;
            this.divisi = "Android";
        } else {
            super.tulis = 0.4;
            super.coding =  0.35;
            super.wawancara = 0.25;
            this.divisi = "Web";
        }
    }

    public void edit(String nik, String nama, double coding, double tulis, double wawancara) {
        this.nik = nik;
        this.nama = nama;
        this.tcoding = coding;
        this.ttulis = tulis;
        this.twawancara = wawancara;
    }

    public void cek() {
        this.total = ttulis * this.tulis + tcoding * this.coding + twawancara * this.wawancara;
        if ( total < 85) {
            this.status = "GAGAL\nmohon maaf " + nama + ", Anda belum bisa masuk ke divisi " + divisi;
        } else {
            this.status = "SELAMAT\n" + nama + " Kamu telah diterima di divisi " + divisi + "!";
        }
    }
}