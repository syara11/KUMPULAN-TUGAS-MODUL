import java.util.ArrayList;

class Mahasiswa extends Pengguna {
    private String nama;
    private String nim;
    private String fakultas;
    private String programStudi;
    private ArrayList<Buku> bukuYangDipinjam;

    public Mahasiswa(String nama, String nim, String fakultas, String programStudi) {
        this.nama = nama;
        this.nim = nim;
        this.fakultas = fakultas;
        this.programStudi = programStudi;
        this.bukuYangDipinjam = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getFakultas() {
        return fakultas;
    }

    public String getProgramStudi() {
        return programStudi;
    }

    public ArrayList<Buku> getBukuYangDipinjam() {
        return bukuYangDipinjam;
    }

    public void tampilkanInfo() {
        System.out.println("Informasi Mahasiswa:");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Fakultas: " + fakultas);
        System.out.println("Program Studi: " + programStudi);
    }

    public void tampilkanBukuYangDipinjam() {
        if (bukuYangDipinjam.isEmpty()) {
            System.out.println("Tidak ada buku yang sedang dipinjam.");
        } else {
            System.out.println("Buku yang Dipinjam:");
            for (Buku buku : bukuYangDipinjam) {
                System.out.println("Judul: " + buku.getJudul());
            }
        }
    }

    public void pinjamBuku(Buku buku, int durasiPinjam) {
        bukuYangDipinjam.add(buku);
        buku.setStok(buku.getStok() - 1);
        buku.setDurasiPinjam(durasiPinjam);
        System.out.println("Buku '" + buku.getJudul() + "' berhasil dipinjam selama " + durasiPinjam + " hari.");
    }

    public void kembalikanBuku(Buku buku) {
        bukuYangDipinjam.remove(buku);
        buku.setStok(buku.getStok() + 1);
        System.out.println("Buku '" + buku.getJudul() + "' berhasil dikembalikan.");
    }
}