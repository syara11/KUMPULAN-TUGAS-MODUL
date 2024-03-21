import java.util.Scanner;
import java.util.ArrayList;
class Admin {
    private Scanner scanner;
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    public Admin(Scanner scanner) {
        this.scanner = scanner;

        // Menambahkan beberapa mahasiswa contoh
        Mahasiswa mahasiswa1 = new Mahasiswa(scanner);
        mahasiswa1.setNama("John Doe");
        mahasiswa1.setNim("123456789012345");
        mahasiswa1.setFakultas("Teknik");
        mahasiswa1.setProgramStudi("Informatika");
        daftarMahasiswa.add(mahasiswa1);

        Mahasiswa mahasiswa2 = new Mahasiswa(scanner);
        mahasiswa2.setNama("Jane Doe");
        mahasiswa2.setNim("987654321098765");
        mahasiswa2.setFakultas("Ilmu Komunikasi");
        mahasiswa2.setProgramStudi("Jurnalistik");
        daftarMahasiswa.add(mahasiswa2);
    }

    public void menuAdmin() {
        int pilihanAdmin;
        do {
            System.out.println("Menu Admin:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Lihat Daftar Mahasiswa");
            System.out.println("3. Logout");
            System.out.print("Pilihan Anda: ");
            pilihanAdmin = scanner.nextInt();
            scanner.nextLine();

            switch (pilihanAdmin) {
                case 1:
                    tambahMahasiswa();
                    break;
                case 2:
                    tampilkanMahasiswa();
                    break;
                case 3:
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihanAdmin != 3);
    }

    private void tambahMahasiswa() {
        System.out.println("Masukkan Nama Mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.println("Masukkan NIM Mahasiswa (harus 15 karakter): ");
        String nim = scanner.nextLine();
        System.out.println("Masukkan Fakultas Mahasiswa: ");
        String fakultas = scanner.nextLine();
        System.out.println("Masukkan Program Studi Mahasiswa: ");
        String programStudi = scanner.nextLine();

        if (nim.length() == 15) {
            Mahasiswa mahasiswa = new Mahasiswa(scanner);
            mahasiswa.setNama(nama);
            mahasiswa.setNim(nim);
            mahasiswa.setFakultas(fakultas);
            mahasiswa.setProgramStudi(programStudi);
            daftarMahasiswa.add(mahasiswa);

            System.out.println("Mahasiswa berhasil ditambahkan.");
        } else {
            System.out.println("Gagal menambahkan mahasiswa. Panjang NIM harus 15 karakter.");
        }
    }

    private void tampilkanMahasiswa() {
        System.out.println("Daftar Mahasiswa:");
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            System.out.println("Nama: " + mahasiswa.getNama());
            System.out.println("NIM: " + mahasiswa.getNim());
            System.out.println("Fakultas: " + mahasiswa.getFakultas());
            System.out.println("Program Studi: " + mahasiswa.getProgramStudi());
            System.out.println();
        }
    }
}