class Buku {
    private String id;
    private String judul;
    private String pencipta;
    private int stok;

    public Buku(String id, String judul, String pencipta, int stok) {
        this.id = id;
        this.judul = judul;
        this.pencipta = pencipta;
        this.stok = stok;
    }

    public String getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getPencipta() {
        return pencipta;
    }

    public int getStok() {
        return stok;
    }

    // Method untuk mengurangi stok buku
    public void setStok(int stok) {
        this.stok = stok;
    }
}