import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Buku> daftarBuku = new ArrayList<>();
    static ArrayList<Mahasiswa> userMahasiswa = new ArrayList<>();

    public static void main(String[] args) {
        inisialisasiData();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== Sistem Perpustakaan =====");
            System.out.println("1. Login sebagai Mahasiswa");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    // Login sebagai mahasiswa
                    System.out.print("Masukkan NIM Anda: ");
                    String nim = scanner.nextLine();
                    Mahasiswa mahasiswa = cariMahasiswaDenganNIM(nim);
                    if (mahasiswa != null) {
                        menuMahasiswa(mahasiswa, scanner);
                    } else {
                        System.out.println("Mahasiswa tidak ditemukan.");
                    }
                    break;
                case "2":
                    // Login sebagai admin
                    System.out.print("Masukkan nama pengguna admin: ");
                    String namaPenggunaAdmin = scanner.nextLine();
                    System.out.print("Masukkan kata sandi admin: ");
                    String kataSandiAdmin = scanner.nextLine();
                    Admin admin = new Admin();
                    if (admin.isAdmin(namaPenggunaAdmin, kataSandiAdmin)) {
                        menuAdmin(admin, scanner);
                    } else {
                        System.out.println("Nama pengguna atau kata sandi tidak valid.");
                    }
                    break;
                case "3":
                    System.out.println("Keluar...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void inisialisasiData() {
        // Tambahkan beberapa buku awal ke perpustakaan
        Buku buku1 = new BukuCerita("C001", "Alice in Wonderland", "Lewis Carroll", 5);
        Buku buku2 = new BukuSejarah("S001", "The Guns of August", "Barbara W. Tuchman", 3);
        Buku buku3 = new BukuTeks("T001", "Introduction to Algorithms", "Thomas H. Cormen", 2);

        daftarBuku.add(buku1);
        daftarBuku.add(buku2);
        daftarBuku.add(buku3);
    }

    public static void menuMahasiswa(Mahasiswa mahasiswa, Scanner scanner) {
        while (true) {
            System.out.println("===== Menu Mahasiswa =====");
            System.out.println("1. Tampilkan Buku yang Tersedia");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Kembalikan Buku");
            System.out.println("4. Lihat Buku yang Dipinjam");
            System.out.println("5. Logout");
            System.out.print("Masukkan pilihan: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    mahasiswa.tampilkanBuku();
                    break;
                case "2":
                    System.out.print("Masukkan nomor buku yang ingin Anda pinjam: ");
                    int indeksBuku = Integer.parseInt(scanner.nextLine()) - 1;
                    if (indeksBuku >= 0 && indeksBuku < daftarBuku.size()) {
                        Buku bukuDipilih = daftarBuku.get(indeksBuku);
                        System.out.print("Masukkan durasi pinjam (dalam hari): ");
                        int durasiPinjam = Integer.parseInt(scanner.nextLine());
                        mahasiswa.pinjamBuku(bukuDipilih, durasiPinjam);
                    } else {
                        System.out.println("Nomor buku tidak valid.");
                    }
                    break;
                case "3":
                    if (!mahasiswa.getBukuYangDipinjam().isEmpty()) {
                        System.out.println("Pilih buku yang akan dikembalikan:");
                        mahasiswa.tampilkanBukuYangDipinjam();
                        System.out.print("Masukkan judul buku: ");
                        String judulBuku = scanner.nextLine();
                        Buku bukuKembali = null;
                        for (Buku buku : mahasiswa.getBukuYangDipinjam()) {
                            if (buku.getJudul().equalsIgnoreCase(judulBuku)) {
                                bukuKembali = buku;
                                break;
                            }
                        }
                        if (bukuKembali != null) {
                            mahasiswa.kembalikanBuku(bukuKembali);
                        } else {
                            System.out.println("Buku tidak ditemukan.");
                        }
                    } else {
                        System.out.println("Tidak ada buku yang sedang dipinjam.");
                    }
                    break;
                case "4":
                    mahasiswa.tampilkanBukuYangDipinjam();
                    break;
                case "5":
                    System.out.println("Logout...");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void menuAdmin(Admin admin, Scanner scanner) {
        while (true) {
            System.out.println("===== Menu Admin =====");
            System.out.println("1. Tampilkan Buku yang Tersedia");
            System.out.println("2. Tambahkan Buku");
            System.out.println("3. Tampilkan Mahasiswa Terdaftar");
            System.out.println("4. Tambahkan Mahasiswa");
            System.out.println("5. Logout");
            System.out.print("Masukkan pilihan: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    admin.tampilkanBuku();
                    break;
                case "2":
                    admin.masukkanBuku(scanner);
                    break;
                case "3":
                    admin.tampilkanMahasiswa();
                    break;
                case "4":
                    admin.tambahMahasiswa(scanner);
                    break;
                case "5":
                    System.out.println("Logout...");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static Mahasiswa cariMahasiswaDenganNIM(String nim) {
        for (Mahasiswa mahasiswa : userMahasiswa) {
            if (mahasiswa.getNim().equals(nim)) {
                return mahasiswa;
            }
        }
        return null;
    }
}