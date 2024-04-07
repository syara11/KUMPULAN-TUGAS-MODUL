import java.util.Scanner;
import java.util.ArrayList;

class Buku {
    private String id;
    private String judul;
    private String pengarang;
    private String kategori;
    private int stok;
    private int durasiPinjam;

    //konstruktor buku
    public Buku(String id, String judul, String pengarang, String kategori, int stok) {
        this.id = id;
        this.judul = judul;
        this.pengarang = pengarang;
        this.kategori = kategori;
        this.stok = stok;
    }

    // Getter dan setter semua atribut

    public String getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public String getKategori() {
        return kategori;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getDurasiPinjam() {
        return durasiPinjam;
    }

    public void setDurasiPinjam(int durasiPinjam) {
        this.durasiPinjam = durasiPinjam;
    }
}
