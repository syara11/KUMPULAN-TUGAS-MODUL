import java.util.ArrayList;
import  java.util.Scanner;
class Mahasiswa {
    private Scanner scanner;

    private String nama;
    private String fakultas;
    private String programStudi;
    private String nim;  // Tambahkan atribut nim

    // Menambahkan beberapa contoh buku
    private ArrayList<Buku> daftarBuku = new ArrayList<>();

    public Mahasiswa(Scanner scanner) {
        this.scanner = scanner;

        // Menambahkan beberapa contoh buku
        Buku buku1 = new Buku("001", "Java Programming", "John Doe", 10);
        Buku buku2 = new Buku("002", "Data Structures and Algorithms", "Jane Doe", 5);
        Buku buku3 = new Buku("003", "Introduction to Artificial Intelligence", "Bob Smith", 8);

        daftarBuku.add(buku1);
        daftarBuku.add(buku2);
        daftarBuku.add(buku3);
    }

    // Tambahkan metode getNim
    public String getNim() {
        return nim;
    }

    // Metode untuk menampilkan daftar buku
    public void tampilkanDaftarBuku() {
        System.out.println("Daftar Buku:");
        for (Buku buku : daftarBuku) {
            System.out.println("ID: " + buku.getId());
            System.out.println("Judul: " + buku.getJudul());
            System.out.println("Pencipta: " + buku.getPencipta());
            System.out.println("Stok: " + buku.getStok());
            System.out.println();
        }
    }

    // Method untuk meminjam buku
    public void pinjamBuku() {
        System.out.println("Masukkan ID Buku yang ingin dipinjam: ");
        String idBuku = scanner.nextLine();

        // Cari buku berdasarkan ID
        Buku bukuDipinjam = null;
        for (Buku buku : daftarBuku) {
            if (buku.getId().equals(idBuku)) {
                bukuDipinjam = buku;
                break;
            }
        }

        if (bukuDipinjam != null) {
            if (bukuDipinjam.getStok() > 0) {
                // Kurangi stok buku
                bukuDipinjam.setStok(bukuDipinjam.getStok() - 1);
                System.out.println("Buku berhasil dipinjam.");
            } else {
                System.out.println("Maaf, stok buku tidak mencukupi.");
            }
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    public void logout() {
        System.out.println("Logout berhasil.");
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public void setProgramStudi(String programStudi) {
        this.programStudi = programStudi;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getFakultas() {
        return fakultas;
    }

    public String getProgramStudi() {
        return programStudi;
    }

    public void menuMahasiswa() {
        int pilihanMahasiswa;
        do {
            System.out.println("Menu Mahasiswa:");
            System.out.println("1. Lihat Daftar Buku");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Logout");
            System.out.print("Pilihan Anda: ");
            pilihanMahasiswa = scanner.nextInt();
            scanner.nextLine();

            switch (pilihanMahasiswa) {
                case 1:
                    tampilkanDaftarBuku();
                    break;
                case 2:
                    pinjamBuku();
                    break;
                case 3:
                    logout();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihanMahasiswa != 3);
    }
}