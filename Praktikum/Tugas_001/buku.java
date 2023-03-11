package Praktikum.Tugas_001;

public class buku{
    private String kategoriBuku;
    private String penulis;
    private String namaBuku;
    private String jumlahHalaman;
    private String nomorBuku;
    private String tahunTerbit;
    private String penerbit;

    //mutator (setter)
    public void setKategori(String kategoriBuku){
        this.kategoriBuku = kategoriBuku;
    }
    public void setNamaPenulis(String penulis){
        this.penulis = penulis;
    }
    public void setNamaBuku(String namaBuku){
        this.namaBuku = namaBuku;
    }
    public void setJumlahHalaman(String jumlahHalaman) {
        this.jumlahHalaman = jumlahHalaman;
    }
    public void setNomorBuku(String nomorBuku) {
        this.nomorBuku = nomorBuku;
    }
    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }
    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    //methods
    public void tampilkanKategori(){
        System.out.printf("=========[BUKU KATEGORI %s]========\n", kategoriBuku.toUpperCase());
    }
    public void tampilkan(){
        System.out.printf("Buku ke-%s\n", nomorBuku);
        System.out.printf("1. Nama Buku\t\t: %s\n", namaBuku);
        System.out.printf("2. Penulis\t\t: %s\n", penulis);
        System.out.printf("3. Jumlah Halaman\t: %s\n", jumlahHalaman);
        System.out.printf("4. Tahun Terbit\t\t: %s\n", tahunTerbit);
        System.out.printf("5. Nama Penerbit\t: %s\n", penerbit);
        System.out.println();
    }
}
