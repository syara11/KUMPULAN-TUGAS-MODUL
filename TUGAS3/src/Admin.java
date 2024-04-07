import java.util.ArrayList;
import java.util.Scanner;

class Admin extends Pengguna {
    private String namaPenggunaAdmin = "admin";
    private String kataSandiAdmin = "adm";
    private ArrayList<Mahasiswa> daftarMahasiswa;

    public Admin() {
        this.daftarMahasiswa = new ArrayList<>();
    }

    public boolean isAdmin(String namaPengguna, String kataSandi) {
        return namaPengguna.equals(namaPenggunaAdmin) && kataSandi.equals(kataSandiAdmin);
    }

    public void tambahMahasiswa(Scanner scanner) {
        System.out.println("Masukkan detail mahasiswa:");
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = scanner.nextLine();
        String nim;
        do {
            System.out.print("Masukkan NIM mahasiswa (15 digit): ");
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("NIM harus terdiri dari 15 digit.");
            }
        } while (nim.length() != 15);
        System.out.print("Masukkan fakultas mahasiswa: ");
        String fakultas = scanner.nextLine();
        System.out.print("Masukkan program studi mahasiswa: ");
        String programStudi = scanner.nextLine();
        Mahasiswa mahasiswaBaru = new Mahasiswa(nama, nim, fakultas, programStudi);
        daftarMahasiswa.add(mahasiswaBaru);
        Main.userMahasiswa.add(mahasiswaBaru); // Tambahkan mahasiswa ke daftar userMahasiswa
        System.out.println("Mahasiswa berhasil terdaftar.");
    }

    public void tampilkanMahasiswa() {
        System.out.println("Daftar Mahasiswa Terdaftar:");
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            mahasiswa.tampilkanInfo();
        }
    }

    public void masukkanBuku(Scanner scanner) {
        System.out.println("Pilih kategori buku:");
        System.out.println("1. Buku Cerita");
        System.out.println("2. Buku Sejarah");
        System.out.println("3. Buku Teks");
        System.out.print("Masukkan pilihan (1-3): ");
        String pilihanKategori = scanner.nextLine();

        String kategori;
        switch (pilihanKategori) {
            case "1":
                kategori = "Buku Cerita";
                break;
            case "2":
                kategori = "Buku Sejarah";
                break;
            case "3":
                kategori = "Buku Teks";
                break;
            default:
                System.out.println("Pilihan tidak valid. Default ke Buku Cerita.");
                kategori = "Buku Cerita";
                break;
        }
        System.out.println("Masukkan detail buku:");
        System.out.print("Masukkan ID buku: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan pengarang buku: ");
        String pengarang = scanner.nextLine();
        System.out.print("Masukkan stok buku: ");
        int stok = Integer.parseInt(scanner.nextLine());

        Buku bukuBaru = new Buku(id, judul, pengarang, kategori, stok);
        daftarBuku.add(bukuBaru);
        System.out.println("Buku berhasil ditambahkan ke perpustakaan.");
    }
}