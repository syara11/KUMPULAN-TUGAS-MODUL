import java.util.ArrayList;

class Pengguna {
    protected static ArrayList<Buku> daftarBuku = new ArrayList<>();

    public void tampilkanBuku() {
        System.out.println("Daftar Buku:");
        System.out.println("================================================================");
        System.out.println("|| No. || Id Buku || Judul Buku || Pengarang || Kategori || Stok ||");
        int indeks = 1;
        for (Buku buku : daftarBuku) {
            System.out.println("|| " + indeks + "  || " + buku.getId() + " || " + buku.getJudul() + " || " + buku.getPengarang() + " || " + buku.getKategori() + "  || " + buku.getStok() + " ||");
            indeks++;
        }
        System.out.println("================================================================");
    }
}